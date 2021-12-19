package tests;

import instruments.MyProperties;
import instruments.MyWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class Page {
    protected WebDriver webDriver;
    protected MyProperties properties;
    protected WebDriverWait wait;

    public Page(){
        webDriver = MyWebDriver.getInstance();
        properties = MyProperties.getInstance();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(properties.getConfIntProperty("waitSeconds")));
    }
    public Page(int waitSecond){
        webDriver = MyWebDriver.getInstance();
        properties = MyProperties.getInstance();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(waitSecond));
    }

    public WebElement waitVisibility(By by){
         return  wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public WebElement waitClickable(By by){
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public WebElement waitPresence(By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public Boolean waitStalenessOf(WebElement element){
        return wait.until(ExpectedConditions.stalenessOf(element));
    }


}
