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

    public static WebDriver getWebDriver() {
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

    public static String getCurrentUrl(){
        return getInstance().webDriver.getCurrentUrl();
    }
    public static void openURL(String url){
        getInstance().webDriver.get(url);
    }
    public static String getCurrentWindow(){
        return getInstance().webDriver.getWindowHandle();
    }
    public static void switchToFrame(WebElement element){
        getInstance().webDriver.switchTo().frame(element);
    }
    public static void switchToFrame(String frame){
        getInstance().webDriver.switchTo().window(frame);
    }
    public static void saveCurrentWindows(){
        tabAndWindow = getInstance().webDriver.getWindowHandles();
    }
    public static void openNewWindow(){
        Set<String> tabs =  getInstance().webDriver.getWindowHandles();
        for (String s : tabs) {
            if(!tabAndWindow.contains(s)){
                getInstance().webDriver.switchTo().window(s);
            }
        }
    }
    public static void openAvailableWindow(){
        for (String s : getInstance().webDriver.getWindowHandles()){
            getInstance().webDriver.switchTo().window(s);
            break;
        }
    }
    public static void close(){
        getInstance().webDriver.close();
    }

    private void startChrome(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=" +
                ConfigUtil.getConfProperty("windowWidth") +","+
                ConfigUtil.getConfProperty("windowHeight"));
        options.addArguments("--lang="+ ConfigUtil.getConfProperty("language"));
        webDriver = new ChromeDriver(options);
    }
    private void startFireFox(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        //Тут вопрсики, Я вижу только маленький кусок страницы, а все остальное за рамками монитора, Я задаю размеры в пикселях или еще в чемто?
        //Плюс добавить язык!!!
//        firefoxOptions.addArguments("--width="+ ConfigUtil.getConfProperty("windowWidth"));
//        firefoxOptions.addArguments("--height="+ ConfigUtil.getConfProperty("windowHeight"));
        webDriver = new FirefoxDriver(firefoxOptions);
    }
}
