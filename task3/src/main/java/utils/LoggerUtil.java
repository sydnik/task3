package utils;

import org.apache.log4j.Logger;

public class LoggerUtil {
    public static void log(String name,String message){
        Logger log = Logger.getLogger(name);
        log.info(message);
    }
}
