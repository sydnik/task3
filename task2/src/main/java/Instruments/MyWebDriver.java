package Instruments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyWebDriver {
    private static WebDriver driver;


    private MyWebDriver(){
    }

    public static WebDriver getInstance(){
        if(driver==null){
            WebDriverManager.getInstance().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void sizeWindow(){
        MyProperties myProperties = MyProperties.getInstance();
        driver.manage().window().setSize(new Dimension(
                Integer.parseInt(myProperties.getConfiguration("windowWidth")),Integer.parseInt(myProperties.getConfiguration("pixelY"))));
    }
}
