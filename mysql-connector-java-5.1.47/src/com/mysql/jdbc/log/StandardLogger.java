INDX( 	                 (   �   �      ) � d                   ��   � ` L     ��    ���x����x����x���W�y���       $               R . d e x                   ��   � ` L     ��    ���x����x����x���W�y���       $               R . d e x                   ` L     ��    ���x����x����x���W�y���       $               R . d e x                   ��   � ` L     ��    ���x����x����x���W�y���       $               R . d e x                   ��   ) ` L     ��    ���x����x����x���W�y���       $               R . d e x                   ��   � ` L     ��    ���x����x����x���W�y���       $               R . d e x                   ` L     ��    ���x����x����x���W�y���       $               R . d e x                   ��   � ` L     ��    ���x����x����x���W�y���       $               R . d e x                   ` L     ��    ���x����x����x���W�y���       $               R . ) e x                   ` L     ��    ���x����x����x���W�y���       $               R . d e x                   ` L     ��    ���x����x����x���W�y���       $               R . d e x                   ` L     ��    ���x����x����x���W�y���       $               R . d e x                                                                                                                                                                                                 )                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               )                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               )                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               )                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               )                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ) l.
     * 
     * @param message
     *            the message to log
     * @param exception
     *            the throwable to log (may be null)
     */
    public void logError(Object message, Throwable exception) {
        logInternal(ERROR, message, exception);
    }

    /**
     * Logs the given message instance using the 'fatal' level
     * 
     * @param message
     *            the message to log
     */
    public void logFatal(Object message) {
        logInternal(FATAL, message, null);
    }

    /**
     * Logs the given message and Throwable at the 'fatal' level.
     * 
     * @param message
     *            the message to log
     * @param exception
     *            the throwable to log (may be null)
     */
    public void logFatal(Object message, Throwable exception) {
        logInternal(FATAL, message, exception);
    }

    /**
     * Logs the given message instance using the 'info' level
     * 
     * @param message
     *            the message to log
     */
    public void logInfo(Object message) {
        logInternal(INFO, message, null);
    }

    /**
     * Logs the given message and Throwable at the 'info' level.
     * 
     * @param message
     *            the message to log
     * @param exception
     *            the throwable to log (may be null)
     */
    public void logInfo(Object message, Throwable exception) {
        logInternal(INFO, message, exception);
    }

    /**
     * Logs the given message instance using the 'trace' level
     * 
     * @param message
     *            the message to log
     */
    public void logTrace(Object message) {
        logInternal(TRACE, message, null);
    }

    /**
     * Logs the given message and Throwable at the 'trace' level.
     * 
     * @param message
     *            the message to log
     * @param exception
     *            the throwable to log (may be null)
     */
    public void logTrace(Object message, Throwable exception) {
        logInternal(TRACE, message, exception);
    }

    /**
     * Logs the given message instance using the 'warn' level
     * 
     * @param message
     *            the message to log
     */
    public void logWarn(Object message) {
        logInternal(WARN, message, null);
    }

    /**
     * Logs the given message and Throwable at the 'warn' level.
     * 
     * @param message
     *            the message to log
     * @param exception
     *            the throwable to log (may be null)
     */
    public void logWarn(Object message, Throwable exception) {
        logInternal(WARN, message, exception);
    }

    protected void logInternal(int level, Object msg, Throwable exception) {
        StringBuilder msgBuf = new StringBuilder();
        msgBuf.append(new Date().toString());
        msgBuf.append(" ");

        switch (level) {
            case FATAL:
                msgBuf.append("FATAL: ");

                break;

            case ERROR:
                msgBuf.append("ERROR: ");

                break;

            case WARN:
                msgBuf.append("WARN: ");

                break;

            case INFO:
                msgBuf.append("INFO: ");

                break;

            case DEBUG:
                msgBuf.append("DEBUG: ");

                break;

            case TRACE:
                msgBuf.append("TRACE: ");

                break;
        }

        if (msg instanceof ProfilerEvent) {
            msgBuf.append(LogUtils.expandProfilerEventIfNecessary(msg));

        } else {
            if (this.logLocationInfo && level != TRACE) {
                Throwable locationException = new Throwable();
                msgBuf.append(LogUtils.findCallingClassAndMethod(locationException));
                msgBuf.append(" ");
            }

            if (msg != null) {
                msgBuf.append(String.valueOf(msg));
            }
        }

        if (exception != null) {
            msgBuf.append("\n");
            msgBuf.append("\n");
            msgBuf.append("EXCEPTION STACK TRACE:");
            msgBuf.append("\n");
            msgBuf.append("\n");
            msgBuf.append(Util.stackTraceToString(exception));
        }

        String messageAsString = msgBuf.toString();

        System.err.println(messageAsString);

        if (bufferedLog != null) {
            bufferedLog.append(messageAsString);
        }
    }
}
