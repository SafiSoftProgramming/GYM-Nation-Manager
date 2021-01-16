id()");
                this.rs.next();

                killConnection(adminConnection, this.rs.getString(1));

                try {
                    failoverStmt.executeQuery("SELECT connection_id()");
                } catch (SQLException sqlEx) {
                    // we expect this one
                }

                this.rs = failoverStmt.executeQuery("SELECT connection_id()");
            } finally {
                if (adminConnection != null) {
                    adminConnection.close();
                }
            }
        }
    }

    private static void killConnection(Connection adminConn, String threadId) throws SQLException {
        adminConn.createStatement().execute("KILL " + threadId);
    }

    /**
     * Tests fix for BUG#6966, connections starting up failed-over (due to down
     * master) never retry master.
     * 
     * @throws Exception
     *             if the test fails...Note, test is timing-dependent, but
     *             should work in most cases.
     */
    public void testBug6966() throws Exception {
        Properties props = new Driver().parseURL(BaseTestCase.dbUrl, null);
        props.setProperty("autoReconnect", "true");
        props.setProperty("socketFactory", "testsuite.UnreliableSocketFactory");

        Properties urlProps = new NonRegisteringDriver().parseURL(dbUrl, null);

        String host = urlProps.getProperty(NonRegisteringDriver.HOST_PROPERTY_KEY);
        String port = urlProps.getProperty(NonRegisteringDriver.PORT_PROPERTY_KEY);

        props.remove(NonRegisteringDriver.HOST_PROPERTY_KEY);
        props.remove(NonRegisteringDriver.NUM_HOSTS_PROPERTY_KEY);
        props.remove(NonRegisteringDriver.HOST_PROPERTY_KEY + ".1");
        props.remove(NonRegisteringDriver.PORT_PROPERTY_KEY + ".1");

        props.setProperty("queriesBeforeRetryMaster", "50");
        props.setProperty("maxReconnects", "1");

        UnreliableSocketFactory.mapHost("master", host);
        UnreliableSocketFactory.mapHost("slave", host);
        UnreliableSocketFactory.downHost("master");

        Connection failoverConnection = null;

        try {
            failoverConnection = getConnectionWithProps("jdbc:mysql://master:" + port + ",slave:" + port + "/", props);
            failoverConnection.setAutoCommit(false);

            String originalConnectionId = getSingleIndexedValueWithQuery(failoverConnection, 1, "SELECT CONNECTION_ID()").toString();

            for (int i = 0; i < 50; i++) {
                this.rs = failoverConnection.createStatement().executeQuery("SELECT 1");
            }

            UnreliableSocketFactory.dontDownHost("master");

            failoverConnection.setAutoCommit(true);

            String newConnectionId = getSingleIndexedValueWithQuery(failoverConnection, 1, "SELECT CONNECTION_ID()").toString();

            assertEquals("/master", UnreliableSocketFactory.getHostFromLastConnection());
            assertFalse(newConnectionId.equals(originalConnectionId));

            this.rs = failoverConnection.createStatement().executeQuery("SELECT 1");
        } finally {
            UnreliableSocketFactory.flushAllStaticData();

            if (failoverConnection != null) {
                failoverConnection.close();
            }
        }
    }

    /**
     * Test fix for BUG#7952 -- Infinite recursion when 'falling back' to master
     * in failover configuration.
     * 
     * @throws Exception
     *             if the tests fails.
     */
    public void testBug7952() throws Exception {
        Properties props = new Driver().parseURL(BaseTestCase.dbUrl, null);
        props.setProperty("autoReconnect", "true");

        String host = props.getProperty(NonRegisteringDriver.HOST_PROPERTY_KEY);

        if (!NonRegisteringDriver.isHostPropertiesList(host)) {
            String port = props.getProperty(NonRegisteringDriver.PORT_PROPERTY_KEY, "3306");

            host = host + ":" + port;
        }

        host = host + "," + host;

        props.remove("PORT");
        props.remove("HOST");

        props.setProperty("queriesBeforeRetryMaster", "10");
        props.setProperty("maxReconnects", "1");

        Connection failoverConnection = null;
        Connection killerConnection = getConnectionWithProps((String) null);

        try {
            failoverConnection = getConnectionWithProps("jdbc:mysql://" + host + "/", props);
            failoverConnection.setAutoCommit(false);

            String failoverConnectionId = getSingleIndexedValueWithQuery(failoverConnection, 1, "SELECT CONNECTION_ID()").toString();

            System.out.println("Connection id: " + failoverConnectionId);

            killConnection(killerConnection, failoverConnectionId);

            Thread.sleep(3000); // This can take some time....

            try {
                failoverConnection.createStatement().executeQuery("SELECT 1");
            } catch (SQLException sqlEx) {
                assertTrue("08S01".equals(sqlEx.getSQLState()));
            }

            ((com.mysql.jdbc.Connection) failoverConnection).setFailedOver(true);

            failoverConnection.setAutoCommit(true);

            String failedConnectionId = getSingleIndexedValueWithQuery(failoverConnection, 1, "SELECT CONNECTION_ID()").toString();
            System.out.println("Failed over connection id: " + failedConnectionId);

            ((com.mysql.jdbc.Connection) failoverConnection).setFailedOver(true);

            for (int i = 0; i < 30; i++) {
                failoverConnection.setAutoCommit(true);
                System.out.println(getSingleIndexedValueWithQuery(failoverConnection, 1, "SELECT CONNECTION_ID()"));
                // failoverConnection.createStatement().executeQuery("SELECT
                // 1");
                failoverConnection.setAutoCommit(true);
            }

            String fallbackConnectionId = getSingleIndexedValueWithQuery(failoverConnection, 1, "SELECT CONNECTION_ID()").toString();
            System.out.println("fallback connection id: " + fallbackConnectionId);

            /*
             * long begin = System.currentTimeMillis();
             * 
             * failoverConnection.setAutoCommit(true);
             * 
             * long end = System.currentTimeMillis();
             * 
             * assertTrue("Probably didn't try failing back to the
             * master....check test", (end - begin) > 500);
             * 
             * failoverConnection.createStatement().executeQuery("SELECT 1");
             */
        } finally {
            if (failoverConnection != null) {
                failoverConnection.close();
            }
        }
    }

    /**
     * Tests fix for BUG#7607 - MS932, SHIFT_JIS and Windows_31J not recog. as
     * aliases for sjis.
     * 
     * @throws Exception
     *             if the test fails.
     */
    public void testBug7607() throws Exception {
        if (versionMeetsMinimum(4, 1)) {
           