package framework.utils;

import org.apache.log4j.Logger;

public class LoggerUtil {
    public static void info(Class clazz, String message){
        Logger log = Logger.getLogger(clazz);
        log.info(message);
    }
    public static void trace(Class clazz, String message){
        Logger log = Logger.getLogger(clazz);
        log.trace(message);
    }
    public static void error(Class clazz, String message){
        Logger log = Logger.getLogger(clazz);
        log.error(message);
    }
    public static void debug(Class clazz, String message){
        Logger log = Logger.getLogger(clazz);
        log.debug(message);
    }
    public static void fatal(Class clazz, String message){
        Logger log = Logger.getLogger(clazz);
        log.fatal(message);
    }
    public static void warn(Class clazz, String message){
        Logger log = Logger.getLogger(clazz);
        log.warn(message);
    }
}
