package Instruments;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class MyProperties {
    private final String PATH_DATA = "src/main/resources/dataForTest.properties";
    private final String PATH_CONFIGURATION = "src/main/resources/configuration.properties";
    private static MyProperties myProperties;
    private Properties propertiesData;
    private Properties propertiesConfiguration;
    private FileInputStream streamData;
    private FileInputStream streamConfiguration;

    private MyProperties(){
        try {
            streamData = new FileInputStream(PATH_DATA);
            propertiesData = new Properties();
            propertiesData.load(streamData);

            streamConfiguration = new FileInputStream(PATH_CONFIGURATION);
            propertiesConfiguration = new Properties();
            propertiesConfiguration.load(streamConfiguration);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (Exception e){

        }
    }

    public static MyProperties getInstance(){
        if(myProperties==null){
            myProperties = new MyProperties();
        }
        return myProperties;
    }
    public String getConfigurationString(String key){
        return (String) propertiesConfiguration.get(key);
    }

    public Integer getConfigurationInt(String key){
        return Integer.parseInt((String) propertiesConfiguration.get(key));
    }

    public String getDataString(String key){
        return (String) propertiesData.get(key);
    }

    public Integer getDataInt(String key){
        return Integer.parseInt((String)propertiesData.get(key));
    }

    public String getDataUTF8(String key){
        String line = (String) propertiesData.get(key);
        byte[] mainData = line.getBytes(StandardCharsets.ISO_8859_1);
        return new String(mainData, StandardCharsets.UTF_8);
    }

    public String getConfigurationUTF8(String key){
        String line = (String) propertiesData.get(key);
        byte[] mainData = line.getBytes(StandardCharsets.ISO_8859_1);
        return new String(mainData, StandardCharsets.UTF_8);
    }
    public void close(){
        try {
            streamConfiguration.close();
            streamData.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
