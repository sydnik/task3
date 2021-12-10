package Instruments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyWebDriver extends ChromeDriver  {
    private static MyWebDriver driver;


    private MyWebDriver(){
    }

    public static MyWebDriver getInstance(){
        if(driver==null){
            WebDriverManager.getInstance().setup();
            driver = new MyWebDriver();
            sizeWindow();

        }
        return driver;
    }

    private static void sizeWindow(){
        MyProperties properties = MyProperties.getInstance();
        driver.manage().window().setSize(new Dimension(
                properties.getConfigurationInt("windowWidth"),properties.getConfigurationInt("windowHeight")));
    }

}
