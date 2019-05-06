package com.epam.mentorship.utils;

import  org.slf4j.*;

public class Logger {
    private static org.slf4j.Logger log;

    private Logger() {
    }

    private static org.slf4j.Logger getLogger() {
        if (log == null) {
            log = LoggerFactory.getLogger(Logger.class);
        }
        return log;
    }

    public static void info(String message) {

        getLogger().info("[INFO]: " + message);
    }

    public static void step(String message) {
        getLogger().info("[STEP]: " + message);
    }

    public static void debug(String message) {
        getLogger().debug(message);
    }

    public static void error(String message) {
        getLogger().error("[ERROR]: " + message);
    }
}
