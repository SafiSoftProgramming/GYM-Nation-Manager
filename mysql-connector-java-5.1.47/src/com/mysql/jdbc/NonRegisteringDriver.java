dex
035 �D��#�E��G�Z�s��e9t-   p   xV4        H  R   p      �          @  *   X     �  8  �  �	  �	  �	  �	  �	  �	  �	  �	  �	  �	  �	  �	  
  4
  O
  i
  �
  �
  �
  �
    R  �  �  �  �  �  �    8  A  {  ~  �  �  �  �  �  �  �  �  �  �  �  �  �      R  [  c  m  u  �  �  �  �  �  �  �  �  `  �  �  �  �        \  i  {  �  �  �  �  �  �  �  �  	          
                                                         &   (                                        	  	      $	     	   ,	                  4	                  <	        H	                  H	                   4	  !      P	  "      \	  $      ,	  $      d	  #      l	  #      t	  %      $	  $      |	  &          '      �	         
       F          )     -     4     6      7     8     9     :     @     A     E     G     H     I     J     K     L     M     N        
 
 *                   	 +     C          ,          P      >     B     .     1     2     5      ;     O     Q     3      ;                         6           h  n)  
 !, �   " 7#w Mn)  
q  M/ M q ( v p  e 'o  o!  o  o  
" p  V Fo " e 
" p  V F F o0 eo  o%  
" p  V F n  
o  e o  
" p  V o$  F o  e F n  
o  e F n  
F   F o@ epF n  
o  e o	  
" p  V F n   o0' eo  F o  e o#  o
  
" p  V F n  
o  e o  
" p  V o&      �&�rA��0���=,��!S�:�T��8K�Ȓ�Ip�כ+:�M�^��>��Kx-�� j, �34��S"zV��j&�*l��Yq��fuN`�xx�c}�   �   �   �   �   �   �   �   �   �   �   �   }   x   n   b   X   S   F   :   0   +   &   "        	  +   b  8 % < "#" M#F Mr0  F p0 = Mr0  p               <   F n)  
 �z52, �Ef\3 p    "  1# Mn)  
q  M$/ M q (  p  @ ' p        	  2   b  8  D 2#" MM#Mr0  `    4 "   p0 Pn   ("   p0 Pn    	  1@i��                                                                                $change <init> I J L LI LL LLL LLLL LZ 1Landroid/content/BroadcastReceiver$PendingResult; #Landroid/content/BroadcastReceiver; Landroid/content/ComponentName; Landroid/content/Context; Landroid/content/Intent; Landroid/os/Build$VERSION; Landroid/os/Bundle; Landroid/os/IBinder; 0Lcom/android/tools/ir/runtime/IncrementalChange; 5Lcom/android/tools/ir/runtime/InstantReloadException; 7Lcom/safisoft/fakelocation_duckgps/Gps_Startup_Service; DLcom/safisoft/fakelocation_duckgps/RestartService_BroadcastReceiver; Ljava/lang/Boolean; Ljava/lang/Class; Ljava/lang/Integer; Ljava/lang/Number; Ljava/lang/Object; Ljava/lang/String; %RestartService_BroadcastReceiver.java SDK_INT 8String switch could not find '%s' with hashcode %s in %s V VI VILL VJ VL VLL VZ Z ZL [Ljava/lang/Object; abortBroadcast access$dispatch access$super booleanValue clearAbortBroadcast clone Bcom/safisoft/fakelocation_duckgps/RestartService_BroadcastReceiver context equals finalize format getAbortBroadcast getClass getDebugUnregister getResultCode getResultData getResultExtras goAsync hashCode vinit$args.([Lcom/safisoft/fakelocation_duckgps/RestartService_BroadcastReceiver;[Ljava/lang/Object;)Ljava/lang/Object; dinit$body.(Lcom/safisoft/fakelocation_duckgps/RestartService_BroadcastReceiver;[Ljava/lang/Object;)V intValue intent isInitialStickyBroadcast isOrderedBroadcast 	longValue 	onReceive >onReceive.(Landroid/content/Context;Landroid/content/Intent;)V peekService serialVersionUID setDebugUnregister setOrderedHint 	setResult setResultCode setResultData setResultExtras startForegroundService startService toString valueOf wait  �!�������!�	�泃��F^                        R   p         �                @     *   X        �        �        	       	     R   �	                 6       D        H                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }

        return splitValues;
    }

    private static int safeIntParse(String intAsString) {
        try {
            return Integer.parseInt(intAsString);
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }

    /**
     * Construct a new driver and register it with DriverManager
     * 
     * @throws SQLException
     *             if a database error occurs.
     */
    public NonRegisteringDriver() throws SQLException {
        // Required for Class.forName().newInstance()
    }

    /**
     * Typically, drivers will return true if they understand the subprotocol
     * specified in the URL and false if they don't. This driver's protocols
     * start with jdbc:mysql:
     * 
     * @param url
     *            the URL of the driver
     * 
     * @return true if this driver accepts the given URL
     * 
     * @exception SQLException
     *                if a database access error occurs or the url is null
     * 
     * @see java.sql.Driver#acceptsURL
     */
    public boolean acceptsURL(String url) throws SQLException {
        if (url == null) {
            throw SQLError.createSQLException(Messages.getString("NonRegisteringDriver.1"), SQLError.SQL_STATE_UNABLE_TO_CONNECT_TO_DATASOURCE, null);
        }
        return (parseURL(url, null) != null);
    }

    //
    // return the database name property
    //

    /**
     * Try to make a database connection to the given URL. The driver should return "null" if it realizes it is the wrong kind of driver to connect to the given
     * URL. This will be common, as when the JDBC driverManager is asked to connect to a given URL, it passes the URL to each loaded driver in turn.
     * 
     * <p>
     * The driver should raise an SQLException if the URL is null or if it is the right driver to connect to the given URL, but has trouble connecting to the
     * database.
     * </p>
     * 
     * <p>
     * The java.util.Properties argument can be used to pass arbitrary string tag/value pairs as connection arguments. These properties take precedence over any
     * properties sent in the URL.
     * </p>
     * 
     * <p>
     * MySQL protocol takes the form:
     * 
     * <PRE>
     * jdbc:mysql://host:port/database
     * </PRE>
     * 
     * </p>
     * 
     * @param url
     *            the URL of the database to connect to
     * @param info
     *            a list of arbitrary tag/value pairs as connection arguments
     * 
     * @return a connection to the URL or null if it isn't us
     * 
     * @exception SQLException
     *                if a database access error occurs or the url is null
     * 
     * @see java.sql.Driver#connect
     */
    public java.sql.Connection connect(String url, Properties info) throws SQLException {
        if (url == null) {
            throw SQLError.createSQLException(Messages.getString("NonRegisteringDriver.1"), SQLError.SQL_STATE_UNABLE_TO_CONNECT_TO_DATASOURCE, null);
        }

        if (StringUtils.startsWithIgnoreCase(url, LOADBALANCE_URL_PREFIX)) {
            return connectLoadBalanced(url, info);
        } else if (StringUtils.startsWithIgnoreCase(url, REPLICATION_URL_PREFIX)) {
            return connectReplicationConnection(url, info);
        }

        Properties props = null;

        if ((props = parseURL(url, info)) == null) {
            return null;
        }

        if (!"1".equals(props.getProperty(NUM_HOSTS_PROPERTY_KEY))) {
            return connectFailover(url, info);
        }

        try {
            Connection newConn = com.mysql.jdbc.ConnectionImpl.getInstance(host(props), port(props), props, database(props), url);

            return newConn;
        } catch (SQLException sqlEx) {
            // Don't wrap SQLExceptions, throw
            // them un-changed.
            throw sqlEx;
        } catch (Exception ex) {
            SQLException sqlEx = SQLError.createSQLException(
                    Messages.getString("NonRegisteringDriver.17") + ex.toString() + Messages.getString("NonRegisteringDriver.18"),
                    SQLError.SQL_STATE_UNABLE_TO_CONNECT_TO_DATASOURCE, null);

            sqlEx.initCause(ex);

            throw sqlEx;
        }
    }

    protected static void trackConnection(Connection newConn) {

        ConnectionPhantomReference phantomRef = new ConnectionPhantomReference((ConnectionImpl) newConn, refQueue);
        connectionPhantomRefs.put(phantomRef, phantomRef);
    }

    private java.sql.Connection connectLoadBalanced(String url, Properties info) throws SQLException {
        Properties parsedProps = parseURL(url, info);

        if (parsedProps == null) {
            return null;
        }

        // People tend to drop this in, it doesn't make sense
        parsedProps.remove("roundRobinLoadBalance");

        int numHosts = Integer.parseInt(parsedProps.getProperty(NUM_HOSTS_PROPERTY_KEY));

        List<String> hostList = new ArrayList<String>();

        for (int i = 0; i < numHosts; i++) {
            int index = i + 1;

            hostList.add(parsedProps.getProperty(HOST_PROPERTY_KEY + "." + index) + ":" + parsedProps.getProperty(PORT_PROPERTY_KEY + "." + index));
        }

        return LoadBalancedConnectionProxy.createProxyInstance(hostList, parsedProps);
    }

    private java.sql.Connection connectFailover(String url, Properties info) throws SQLException {
        Properties parsedProps = parseURL(url, info);

        if (parsedProps == null) {
            return null;
        }

        // People tend to drop this in, it doesn't make sense
        parsedProps.remove("roundRobinLoadBalance");

        int numHosts = Integer.parseInt(parsedProps.getProperty(NUM_HOSTS_PROPERTY_KEY));

        List<String> hostList = new ArrayList<String>();

        for (int i = 0; i < numHosts; i++) {
            int index = i + 1;

            hostList.add(parsedProps.getProperty(HOST_PROPERTY_KEY + "." + index) + ":" + parsedProps.getProperty(PORT_PROPERTY_KEY + "." + index));
        }

        return FailoverConnectionProxy.createProxyInstance(hostList, parsedProps);
    }

    protected java.sql.Connection connectReplicationConnection(String url, Properties info) throws SQLException {
        Properties parsedProps = parseURL(url, info);

        if (parsedProps == null) {
            return null;
        }

        Properties masterProps = (Properties) parsedProps.clone();
        Properties slavesProps = (Properties) parsedProps.clone();

        // Marker used for further testing later on, also when
        // debugging
        slavesProps.setProperty("com.mysql.jdbc.ReplicationConnection.isSlave", "true");

        int numHosts = Integer.parseInt(parsedProps.getProperty(NUM_HOSTS_PROPERTY_KEY));

        if (numHosts < 2) {
            throw SQLError.createSQLException("Must specify at least one slave host to connect to for master/slave replication load-balancing functionality",
                    SQLError.SQL_STATE_INVALID_CONNECTION_ATTRIBUTE, null);
        }
        List<String> slaveHostList = new ArrayList<String>();
        List<String> masterHostList = new ArrayList<String>();

        String firstHost = masterProps.getProperty(HOST_PROPERTY_KEY + ".1") + ":" + masterProps.getProperty(PORT_PROPERTY_KEY + ".1");

        boolean usesExplicitServerType = NonRegisteringDriver.isHostPropertiesList(firstHost);

        for (int i = 0; i < numHosts; i++) {
            int index = i + 1;

            masterProps.remove(HOST_PROPERTY_KEY + "." + index);
            masterProps.remove(PORT_PROPERTY_KEY + "." + index);
            slavesProps.remove(HOST_PROPERTY_KEY + "." + index);
            slavesProps.remove(PORT_PROPERTY_KEY + "." + index);

            String host = parsedProps.getProperty(HOST_PROPERTY_KEY + "." + index);
            String port = parsedProps.getProperty(PORT_PROPERTY_KEY + "." + index);
            if (usesExplicitServerType) {
                if (isHostMaster(host)) {
                    masterHostList.add(host);
                } else {
                    slaveHostList.add(host);
                }
            } else {
                if (i == 0) {
                    masterHostList.add(host + ":" + port);
                } else {
                    slaveHostList.add(host + ":" + port);
                }
            }
        }

        slavesProps.remove(NUM_HOSTS_PROPERTY_KEY);
        masterProps.remove(NUM_HOSTS_PROPERTY_KEY);
        masterProps.remove(HOST_PROPERTY_KEY);
        masterProps.remove(PORT_PROPERTY_KEY);
        slavesProps.remove(HOST_PROPERTY_KEY);
        slavesProps.remove(PORT_PROPERTY_KEY);

        return ReplicationConnectionProxy.createProxyInstance(masterHostList, masterProps, slaveHostList, slavesProps);
    }

    private boolean isHostMaster(String host) {
        if (NonRegisteringDriver.isHostPropertiesList(host)) {
            Properties hostSpecificProps = NonRegisteringDriver.expandHostKeyValues(host);
            if (hostSpecificProps.containsKey("type") && "master".equalsIgnoreCase(hostSpecificProps.get("type").toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the database property from <code>props</code>
     * 
     * @param props
     *            the Properties to look for the database property.
     * 
     * @return the database name.
     */
    public String database(Properties props) {
        return props.getProperty(DBNAME_PROPERTY_KEY);
    }

    /**
     * Gets the drivers major version number
     * 
     * @return the drivers major version number
     */
    public int getMajorVersion() {
        return getMajorVersionInternal();
    }

    /**
     * Get the drivers minor version number
     * 
     * @return the drivers minor version number
     */
    public int getMinorVersion() {
        return getMinorVersionInternal();
    }

    /**
     * The getPropertyInfo method is intended to allow a generic GUI tool to
     * discover what properties it should prompt a human for in order to get
     * enough information to connect to a database.
     * 
     * <p>
     * Note that depending on the values the human has supplied so far, additional values may become necessary, so it may be necessary to iterate through
     * several calls to getPropertyInfo
     * </p>
     * 
     * @param url
     *            the Url of the database to connect to
     * @param info
     *            a proposed list of tag/value pairs that will be sent on
     *            connect open.
     * 
     * @return An array of DriverPropertyInfo objects describing possible
     *         properties. This array may be an empty array if no properties are
     *         required
     * 
     * @exception SQLException
     *                if a database-access error occurs
     * 
     * @see java.sql.Driver#getPropertyInfo
     */
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        if (info == null) {
            info = new Properties();
        }

        if ((url != null) && url.startsWith(URL_PREFIX)) {
            info = parseURL(url, info);
        }

        DriverPropertyInfo hostProp = new DriverPropertyInfo(HOST_PROPERTY_KEY, info.getProperty(HOST_PROPERTY_KEY));
        hostProp.required = true;
        hostProp.description = Messages.getString("NonRegisteringDriver.3");

        DriverPropertyInfo portProp = new DriverPropertyInfo(PORT_PROPERTY_KEY, info.getProperty(PORT_PROPERTY_KEY, "3306"));
        portProp.required = false;
        portProp.description = Messages.getString("NonRegisteringDriver.7");

        DriverPropertyInfo dbProp = new DriverPropertyInfo(DBNAME_PROPERTY_KEY, info.getProperty(DBNAME_PROPERTY_KEY));
        dbProp.required = false;
        dbProp.description = "Database name";

        DriverPropertyInfo userProp = new DriverPropertyInfo(USER_PROPERTY_KEY, info.getProperty(USER_PROPERTY_KEY));
        userProp.required = true;
        userProp.description = Messages.getString("NonRegisteringDriver.13");

        DriverPropertyInfo passwordProp = new DriverPropertyInfo(PASSWORD_PROPERTY_KEY, info.getProperty(PASSWORD_PROPERTY_KEY));
        passwordProp.required = true;
        passwordProp.description = Messages.getString("NonRegisteringDriver.16");

        DriverPropertyInfo[] dpi = ConnectionPropertiesImpl.exposeAsDriverPropertyInfo(info, 5);

        dpi[0] = hostProp;
        dpi[1] = portProp;
        dpi[2] = dbProp;
        dpi[3] = userProp;
        dpi[4] = passwordProp;

        return dpi;
    }

    //
    // return the value of any property this driver knows about
    //

    /**
     * Returns the hostname property
     * 
     * @param props
     *            the java.util.Properties instance to retrieve the hostname
     *            from.
     * 
     * @return the hostname
     */
    public String host(Properties props) {
        return props.getProperty(HOST_PROPERTY_KEY, "localhost");
    }

    /**
     * Report whether the driver is a genuine JDBC compliant driver. A driver
     * may only report "true" here if it passes the JDBC compliance tests,
     * otherwise it is required to return false. JDBC compliance requires full
     * support for the JDBC API and full support for SQL 92 Entry Level.
     * 
     * <p>
     * MySQL is not SQL92 compliant
     * </p>
     * 
     * @return is this driver JDBC compliant?
     */
    public boolean jdbcCompliant() {
        return false;
    }

    @SuppressWarnings("deprecation")
    public Properties parseURL(String url, Properties defaults) throws java.sql.SQLException {
        Properties urlProps = (defaults != null) ? new Properties(defaults) : new Properties();

        if (url == null) {
            return null;
        }

        if (!StringUtils.startsWithIgnoreCase(url, URL_PREFIX) && !StringUtils.startsWithIgnoreCase(url, MXJ_URL_PREFIX)
                && !StringUtils.startsWithIgnoreCase(url, LOADBALANCE_URL_PREFIX) && !StringUtils.startsWithIgnoreCase(url, REPLICATION_URL_PREFIX)) {

            return null;
        }

        int beginningOfSlashes = url.indexOf("//");

        if (StringUtils.startsWithIgnoreCase(url, MXJ_URL_PREFIX)) {

            urlProps.setProperty("socketFactory", "com.mysql.management.driverlaunched.ServerLauncherSocketFactory");
        }

        /*
         * Parse parameters after the ? in the URL and remove them from the
         * original URL.
         */
        int index = url.indexOf("?");

        if (index != -1) {
            String paramString = url.substring(index + 1, url.length());
            url = url.substring(0, index);

            StringTokenizer queryParams = new StringTokenizer(paramString, "&");

            while (queryParams.hasMoreTokens()) {
                String parameterValuePair = queryParams.nextToken();

                int indexOfEquals = StringUtils.indexOfIgnoreCase(0, parameterValuePair, "=");

                String parameter = null;
                String value = null;

                if (indexOfEquals != -1) {
                    parameter = parameterValuePair.substring(0, indexOfEquals);

                    if (indexOfEquals + 1 < parameterValuePair.length()) {
                        value = parameterValuePair.substring(indexOfEquals + 1);
                    }
                }

                if ((value != null && value.length() > 0) && (parameter != null && parameter.length() > 0)) {
                    try {
                        urlProps.setProperty(parameter, URLDecoder.decode(value, "UTF-8"));
                    } catch (UnsupportedEncodingException badEncoding) {
                        // punt
                        urlProps.setProperty(parameter, URLDecoder.decode(value));
                    } catch (NoSuchMethodError nsme) {
                        // punt again
                        urlProps.setProperty(parameter, URLDecoder.decode(value));
                    }
                }
            }
        }

        url = url.substring(beginningOfSlashes + 2);

        String hostStuff = null;

        int slashIndex = StringUtils.indexOfIgnoreCase(0, url, "/", ALLOWED_QUOTES, ALLOWED_QUOTES, StringUtils.SEARCH_MODE__ALL);

        if (slashIndex != -1) {
            hostStuff = url.substring(0, slashIndex);

            if ((slashIndex + 1) < url.length()) {
                urlProps.put(DBNAME_PROPERTY_KEY, url.substring((slashIndex + 1), url.length()));
            }
        } else {
            hostStuff = url;
        }

        int numHosts = 0;

        if ((hostStuff != null) && (hostStuff.trim().length() > 0)) {
            List<String> hosts = StringUtils.split(hostStuff, ",", ALLOWED_QUOTES, ALLOWED_QUOTES, false);

            for (String hostAndPort : hosts) {
                numHosts++;

                String[] hostPortPair = parseHostPortPair(hostAndPort);

                if (hostPortPair[HOST_NAME_INDEX] != null && hostPortPair[HOST_NAME_INDEX].trim().length() > 0) {
                    urlProps.setProperty(HOST_PROPERTY_KEY + "." + numHosts, hostPortPair[HOST_NAME_INDEX]);
                } else {
                    urlProps.setProperty(HOST_PROPERTY_KEY + "." + numHosts, "localhost");
                }

                if (hostPortPair[PORT_NUMBER_INDEX] != null) {
                    urlProps.setProperty(PORT_PROPERTY_KEY + "." + numHosts, hostPortPair[PORT_NUMBER_INDEX]);
                } else {
                    urlProps.setProperty(PORT_PROPERTY_KEY + "." + numHosts, "3306");
                }
            }
        } else {
            numHosts = 1;
            urlProps.setProperty(HOST_PROPERTY_KEY + ".1", "localhost");
            urlProps.setProperty(PORT_PROPERTY_KEY + ".1", "3306");
        }

        urlProps.setProperty(NUM_HOSTS_PROPERTY_KEY, String.valueOf(numHosts));
        urlProps.setProperty(HOST_PROPERTY_KEY, urlProps.getProperty(HOST_PROPERTY_KEY + ".1"));
        urlProps.setProperty(PORT_PROPERTY_KEY, urlProps.getProperty(PORT_PROPERTY_KEY + ".1"));

        String propertiesTransformClassName = urlProps.getProperty(PROPERTIES_TRANSFORM_KEY);

        if (propertiesTransformClassName != null) {
            try {
                ConnectionPropertiesTransform propTransformer = (ConnectionPropertiesTransform) Class.forName(propertiesTransformClassName).newInstance();

                urlProps = propTransformer.transformProperties(urlProps);
            } catch (InstantiationException e) {
                throw SQLError.createSQLException(
                        "Unable to create properties transform instance '" + propertiesTransformClassName + "' due to underlying exception: " + e.toString(),
                        SQLError.SQL_STATE_INVALID_CONNECTION_ATTRIBUTE, null);
            } catch (IllegalAccessException e) {
                throw SQLError.createSQLException(
                        "Unable to create properties transform instance '" + propertiesTransformClassName + "' due to underlying exception: " + e.toString(),
                        SQLError.SQL_STATE_INVALID_CONNECTION_ATTRIBUTE, null);
            } catch (ClassNotFoundException e) {
                throw SQLError.createSQLException(
                        "Unable to create properties transform instance '" + propertiesTransformClassName + "' due to underlying exception: " + e.toString(),
                        SQLError.SQL_STATE_INVALID_CONNECTION_ATTRIBUTE, null);
            }
        }

        if (Util.isColdFusion() && urlProps.getProperty("autoConfigureForColdFusion", "true").equalsIgnoreCase("true")) {
            String configs = urlProps.getProperty(USE_CONFIG_PROPERTY_KEY);

            StringBuilder newConfigs = new StringBuilder();

            if (configs != null) {
                newConfigs.append(configs);
                newConfigs.append(",");
            }

            newConfigs.append("coldFusion");

            urlProps.setProperty(USE_CONFIG_PROPERTY_KEY, newConfigs.toString());
        }

        // If we use a config, it actually should get overridden by anything in the URL or passed-in properties

        String configNames = null;

        if (defaults != null) {
            configNames = defaults.getProperty(USE_CONFIG_PROPERTY_KEY);
        }

        if (configNames == null) {
            configNames = urlProps.getProperty(USE_CONFIG_PROPERTY_KEY);
        }

        if (configNames != null) {
            List<String> splitNames = StringUtils.split(configNames, ",", true);

            Properties configProps = new Properties();

            Iterator<String> namesIter = splitNames.iterator();

            while (namesIter.hasNext()) {
                String configName = namesIter.next();

                try {
                    InputStream configAsStream = getClass().getResourceAsStream("configs/" + configName + ".properties");

                    if (configAsStream == null) {
                        throw SQLError.createSQLException("Can't find configuration template named '" + configName + "'",
                                SQLError.SQL_STATE_INVALID_CONNECTION_ATTRIBUTE, null);
                    }
                    configProps.load(configAsStream);
                } catch (IOException ioEx) {
                    SQLException sqlEx = SQLError.createSQLException(
                            "Unable to load configuration template '" + configName + "' due to underlying IOException: " + ioEx,
                            SQLError.SQL_STATE_INVALID_CONNECTION_ATTRIBUTE, null);
                    sqlEx.initCause(ioEx);

                    throw sqlEx;
                }
            }

            Iterator<Object> propsIter = urlProps.keySet().iterator();

            while (propsIter.hasNext()) {
                String key = propsIter.next().toString();
                String property = urlProps.getProperty(key);
                configProps.setProperty(key, property);
            }

            urlProps = configProps;
        }

        // Properties passed in should override ones in URL

        if (defaults != null) {
            Iterator<Object> propsIter = defaults.keySet().iterator();

            while (propsIter.hasNext()) {
                String key = propsIter.next().toString();
                if (!key.equals(NUM_HOSTS_PROPERTY_KEY)) {
                    String property = defaults.getProperty(key);
                    urlProps.setProperty(key, property);
                }
            }
        }

        return urlProps;
    }

    /**
     * Returns the port number property
     * 
     * @param props
     *            the properties to get the port number from
     * 
     * @return the port number
     */
    public int port(Properties props) {
        return Integer.parseInt(props.getProperty(PORT_PROPERTY_KEY, "3306"));
    }

    /**
     * Returns the given property from <code>props</code>
     * 
     * @param name
     *            the property name
     * @param props
     *            the property instance to look in
     * 
     * @return the property value, or null if not found.
     */
    public String property(String name, Properties props) {
        return props.getProperty(name);
    }

    /**
     * Expands hosts of the form address=(protocol=tcp)(host=localhost)(port=3306)
     * into a java.util.Properties. Special characters (in this case () and =) must be quoted.
     * Any values that are string-quoted ("" or '') are also stripped of quotes.
     */
    public static Properties expandHostKeyValues(String host) {
        Properties hostProps = new Properties();

        if (isHostPropertiesList(host)) {
            host = host.substring("address=".length() + 1);
            List<String> hostPropsList = StringUtils.split(host, ")", "'\"", "'\"", true);

            for (String propDef : hostPropsList) {
                if (propDef.startsWith("(")) {
                    propDef = propDef.substring(1);
                }

                List<String> kvp = StringUtils.split(propDef, "=", "'\"", "'\"", true);

                String key = kvp.get(0);
                String value = kvp.size() > 1 ? kvp.get(1) : null;

                if (value != null && ((value.startsWith("\"") && value.endsWith("\"")) || (value.startsWith("'") && value.endsWith("'")))) {
                    value = value.substring(1, value.length() - 1);
                }

                if (value != null) {
                    if (HOST_PROPERTY_KEY.equalsIgnoreCase(key) || DBNAME_PROPERTY_KEY.equalsIgnoreCase(key) || PORT_PROPERTY_KEY.equalsIgnoreCase(key)
                            || PROTOCOL_PROPERTY_KEY.equalsIgnoreCase(key) || PATH_PROPERTY_KEY.equalsIgnoreCase(key)) {
                        key = key.toUpperCase(Locale.ENGLISH);
                    } else if (USER_PROPERTY_KEY.equalsIgnoreCase(key) || PASSWORD_PROPERTY_KEY.equalsIgnoreCase(key)) {
                        key = key.toLowerCase(Locale.ENGLISH);
                    }

                    hostProps.setProperty(key, value);
                }
            }
        }

        return hostProps;
    }

    public static boolean isHostPropertiesList(String host) {
        return host != null && StringUtils.startsWithIgnoreCase(host, "address=");
    }

    static class ConnectionPhantomReference extends PhantomReference<ConnectionImpl> {
        private NetworkResources io;

        ConnectionPhantomReference(ConnectionImpl connectionImpl, ReferenceQueue<ConnectionImpl> q) {
            super(connectionImpl, q);

            try {
                this.io = connectionImpl.getIO().getNetworkResources();
            } catch (SQLException e) {
                // if we somehow got here and there's really no i/o, we deal with it later
            }
        }

        void cleanup() {
            if (this.io != null) {
                try {
                    this.io.forceClose();
                } finally {
                    this.io = null;
                }
            }
        }
    }
}
