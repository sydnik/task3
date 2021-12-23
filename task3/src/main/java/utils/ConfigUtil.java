package utils;

import java.io.FileInputStream;
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
//            throw new FileNotFoundException(e.getMessage());
        }
    }
    public static ConfigUtil getInstance()  {
        if(configUtils==null){
            configUtils = new ConfigUtil();
        }
        return configUtils;
    }

    public String getDataProperty(String key){
        return (String) testDataProperties.get(key);
    }

    public Integer getDataIntProperty(String key){
        return Integer.parseInt((String) testDataProperties.get(key));
    }

    public String getConfProperty(String key){
        return (String) configProperties.get(key);
    }

    public Integer getConfIntProperty(String key){
        return Integer.parseInt((String) configProperties.get(key));
    }
}
