package tests;

import Instruments.MyProperties;
import Instruments.MyWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class Page {
    protected WebDriver webDriver;
    protected MyProperties properties;
    protected WebDriverWait wait;

    public Page(){
        webDriver = MyWebDriver.getInstance();
        properties = MyProperties.getInstance();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(properties.getConfigurationInt("waitSeconds")));
    }
    public Page(int waitSecond){
        webDriver = MyWebDriver.getInstance();
        properties = MyProperties.getInstance();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(waitSecond));
    }
}
