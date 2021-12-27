package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtil {
    private WebDriverWait wait;
    private static WaitUtil waitUtil;

    private WaitUtil() {
        this.wait = new WebDriverWait(DriverUtil.getWebDriver(),
                Duration.ofSeconds(ConfigUtil.getConfIntProperty("waitSeconds")),
                Duration.ofMillis(ConfigUtil.getConfIntProperty("timeoutMillis")));
    }
    public static WaitUtil getInstance(){
        if(waitUtil!=null){
            return waitUtil;
        }
        return new WaitUtil();

    }
    public static WebElement waitVisibility(WebElement element){
        return getInstance().wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static boolean waitInVisibility(By locator){
        return getInstance().wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public static WebElement waitClickable(WebElement element){
        return getInstance().wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitPresence(By locator){
        return getInstance().wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public static List<WebElement> watElements(By locator){
        return getInstance().wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
    public static Alert waitPresentAlert(){
        return getInstance().wait.until(ExpectedConditions.alertIsPresent());
    }
    public static Boolean waitUnPresentAlert(){
        return getInstance().wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
    }
}
