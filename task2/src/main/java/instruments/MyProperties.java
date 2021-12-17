package instruments;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class MyProperties {
    private final String PATH_DATA = "src/main/resources/dataForTest.properties";
    private final String PATH_CONFIGURATION = "src/main/resources/configuration.properties";
    private static MyProperties myProperties;
    private Properties propertiesData;
    private Properties propertiesConfiguration;

    private MyProperties(){
        try (InputStreamReader readerData = new InputStreamReader(new FileInputStream(PATH_DATA), StandardCharsets.UTF_8);
             InputStreamReader readerConfig = new InputStreamReader(new FileInputStream(PATH_CONFIGURATION), StandardCharsets.UTF_8))
        {
            propertiesData = new Properties();
            propertiesData.load(readerData);
            propertiesConfiguration = new Properties();
            propertiesConfiguration.load(readerConfig);
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

    public String getDataProperty(String key){
        return (String) propertiesData.get(key);
    }

    public Integer getDataIntProperty(String key){
        return Integer.parseInt((String) propertiesData.get(key));
    }

    public String getConfProperty(String key){
        return (String) propertiesConfiguration.get(key);
    }

    public Integer getConfIntProperty(String key){
        return Integer.parseInt((String) propertiesConfiguration.get(key));
    }



}
