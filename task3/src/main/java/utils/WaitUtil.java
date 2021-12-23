package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {
    private WebDriverWait wait;

    public WaitUtil() {
        this.wait = new WebDriverWait(DriverUtil.getInstance().getWebDriver(),
                Duration.ofSeconds(ConfigUtil.getInstance().getConfIntProperty("waitSeconds")));
    }
    public static boolean waitVisibility(){

        return true;
    }
    public static WebElement waitClickable(WebElement element){
        return new WebDriverWait(DriverUtil.getInstance().getWebDriver(), Duration.ofSeconds(ConfigUtil.getInstance().getConfIntProperty("waitSeconds"))).
                until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitPresence(By locator){
        return new WebDriverWait(DriverUtil.getInstance().getWebDriver(), Duration.ofSeconds(ConfigUtil.getInstance().getConfIntProperty("waitSeconds"))).
                until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
