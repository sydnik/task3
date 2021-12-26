package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Set;

public class DriverUtil {
    private WebDriver webDriver;
    private static DriverUtil driverUtils;
    private static Set<String> tabAndWindow;

    private DriverUtil(){
    }

    public WebDriver getWebDriver() {
        return getInstance().webDriver;
    }

    public static DriverUtil getInstance(){
        if(driverUtils!=null) {
            return driverUtils;
        }
        driverUtils = new DriverUtil();
        switch (ConfigUtil.getConfProperty("browser")) {
            case "FireFox": {
                driverUtils.startFireFox();
                break;
            }
            case "Chrome": {
                driverUtils.startChrome();
                break;
            } default: {
                LoggerUtil.fatal(ConfigUtil.getConfProperty("browser"), " - invalid browser name");
                throw new IllegalArgumentException();
            }
        }
        return driverUtils;
    }

    public static void openURL(String url){
        getInstance().webDriver.get(url);
    }
    public static String getCurrentWidnow(){
        return getInstance().webDriver.getWindowHandle();
    }
    public static void switchToFrame(WebElement element){
        getInstance().webDriver.switchTo().frame(element);
    }
    public static void switchToFrame(String frame){
        getInstance().webDriver.switchTo().window(frame);
    }
    public static void saveCurrentWidnows(){
        tabAndWindow = getInstance().getWebDriver().getWindowHandles();
    }
    public static void openNewWindow(){
        Set<String> tabs =  getInstance().getWebDriver().getWindowHandles();
        for (String s : tabs) {
            if(!tabAndWindow.contains(s)){
                getInstance().getWebDriver().switchTo().window(s);
            }
        }
    }
    public static void openAvailableWindow(){
        for (String s : getInstance().getWebDriver().getWindowHandles()){
            getInstance().getWebDriver().switchTo().window(s);
            break;
        }
    }

    private void startChrome(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=" +
                ConfigUtil.getInstance().getConfProperty("windowWidth") +","+
                ConfigUtil.getInstance().getConfProperty("windowHeight"));
        options.addArguments("--lang="+ ConfigUtil.getInstance().getConfProperty("language"));
        webDriver = new ChromeDriver(options);
    }
    private void startFireFox(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        //Тут вопрсики, Я вижу только маленький кусок страницы, а все остальное за рамками монитора, Я задаю размеры в пикселях или еще в чемто?
        //Плюс добавить язык!!!
        firefoxOptions.addArguments("--width="+ ConfigUtil.getInstance().getConfProperty("windowWidth"));
        firefoxOptions.addArguments("--height="+ ConfigUtil.getInstance().getConfProperty("windowHeight"));
        webDriver = new FirefoxDriver(firefoxOptions);
    }
}
