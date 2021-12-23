package utils;

import org.apache.log4j.Logger;

public class LoggerUtil {
    public static void info(String name, String message){
        Logger log = Logger.getLogger(name);
        log.info(message);
    }
    public static void trace(String name, String message){
        Logger log = Logger.getLogger(name);
        log.trace(message);
    }
    public static void error(String name, String message){
        Logger log = Logger.getLogger(name);
        log.error(message);
    }
    public static void debug(String name, String message){
        Logger log = Logger.getLogger(name);
        log.debug(message);
    }
    public static void fatal(String name, String message){
        Logger log = Logger.getLogger(name);
        log.fatal(message);
    }
    public static void warn(String name, String message){
        Logger log = Logger.getLogger(name);
        log.warn(message);
    }
}
