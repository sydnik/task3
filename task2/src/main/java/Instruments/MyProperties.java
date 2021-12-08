package Instruments;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    public String getConfiguration(String key){
        return (String) propertiesConfiguration.get(key);
    }

    public String getData(String key){
        return (String) propertiesData.get(key);
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
