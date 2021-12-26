package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConfigUtil {
    private final String CONFIG_FILE_PATH = "src/main/resources/configuration.properties";
    private final String TEST_DATA_FILE_PATH = "src/main/resources/dataForTest.properties";
    private static ConfigUtil configUtils;
    private Properties configProperties;
    private Properties testDataProperties;

    private ConfigUtil() {
        try (InputStreamReader readerData = new InputStreamReader(new FileInputStream(TEST_DATA_FILE_PATH), StandardCharsets.UTF_8);
             InputStreamReader readerConfig = new InputStreamReader(new FileInputStream(CONFIG_FILE_PATH), StandardCharsets.UTF_8))
        {
            testDataProperties = new Properties();
            testDataProperties.load(readerData);
            configProperties = new Properties();
            configProperties.load(readerConfig);
        } catch (IOException e) {
            LoggerUtil.fatal("startTest",e.getMessage());
            throw new RuntimeException();
        }
    }
    public static ConfigUtil getInstance()  {
        if(configUtils==null){
                configUtils = new ConfigUtil();
        }
        return configUtils;
    }

    public static String getDataProperty(String key){
        return (String) getInstance().testDataProperties.get(key);
    }

    public static Integer getDataIntProperty(String key){
        return Integer.parseInt((String) getInstance().testDataProperties.get(key));
    }

    public static String getConfProperty(String key){

        return (String) getInstance().configProperties.get(key);
    }

    public static Integer getConfIntProperty(String key){
        return Integer.parseInt((String) getInstance().configProperties.get(key));
    }
}
