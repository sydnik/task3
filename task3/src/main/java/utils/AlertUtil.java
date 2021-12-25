package utils;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertUtil {
    public static boolean isAlert(){
        (new WebDriverWait(DriverUtil.getWebDriver(), Duration.ofSeconds(ConfigUtil.getInstance().getConfIntProperty("waitSeconds"))))
                .until(ExpectedConditions.alertIsPresent());
        return true;
    }
    public static boolean accept(){
        (new WebDriverWait(DriverUtil.getWebDriver(), Duration.ofSeconds(ConfigUtil.getInstance().getConfIntProperty("waitSeconds"))))
                .until(ExpectedConditions.alertIsPresent()).accept();
        return true;
    }
    public static String getText(){
        return (new WebDriverWait(DriverUtil.getWebDriver(), Duration.ofSeconds(ConfigUtil.getInstance().getConfIntProperty("waitSeconds"))))
                .until(ExpectedConditions.alertIsPresent()).getText();

    }
    public static void sendKeys(String line){
        (new WebDriverWait(DriverUtil.getWebDriver(), Duration.ofSeconds(ConfigUtil.getInstance().getConfIntProperty("waitSeconds"))))
                .until(ExpectedConditions.alertIsPresent()).sendKeys(line);
    }
    public static boolean isAlertClosed(){
        try {
            DriverUtil.getWebDriver().switchTo().alert();
        }
        catch (NoAlertPresentException e){
            return true;
        }
        return false;
    }
}
