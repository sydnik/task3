package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
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

    public static Boolean waitNewWindow(int numberOfWindow){
        return getInstance().wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindow));
    }

    public static Boolean waitToBeAttributeValue(WebElement element, String attribute, String value){
       return getInstance().wait.until(ExpectedConditions.attributeToBe(element,attribute,value));
    }

    public static Boolean waitToBeText(WebElement element, String value, int timeOut){
        WebDriverWait waitCustom = new WebDriverWait(DriverUtil.getWebDriver(),
                Duration.ofSeconds(ConfigUtil.getConfIntProperty("waitSeconds")),
                Duration.ofMillis(timeOut));
       return waitCustom.until(ExpectedConditions.textToBePresentInElement(element,value));
    }
    public static Boolean waitToBeTextValues(WebElement element, String[] values, int timeOut){
        ExpectedCondition<?>[] array = new ExpectedCondition[values.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = ExpectedConditions.textToBePresentInElement(element,values[i]);
        }
        return new WebDriverWait(DriverUtil.getWebDriver(), Duration.ofSeconds(ConfigUtil.getConfIntProperty("waitSeconds")),Duration.ofMillis(timeOut)).
                until(ExpectedConditions.or(array));
    }
}
