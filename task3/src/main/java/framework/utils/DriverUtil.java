package framework.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

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
            if(driverUtils.webDriver!=null) {
                return driverUtils;
            }
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
    public static int getNumberOfWindow(){
        System.out.println(getInstance().webDriver.getWindowHandles().size()+"qwewqe");
        return getInstance().webDriver.getWindowHandles().size();
    }
    public static void openURL(String url){
        getInstance().webDriver.get(url);
    }
    public static String getCurrentWindow(){
        return getInstance().webDriver.getWindowHandle();
    }
    public static void switchToFrame(By by){
        getInstance().webDriver.switchTo().frame(WaitUtil.waitPresence(by));
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
    public static void waitAndOpenNewWindow(){
        WaitUtil.waitNewWindow(tabAndWindow.size()+1);
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
    public static void closeTab(){
        getInstance().webDriver.close();
    }
    public static void close(){
        getInstance().webDriver.quit();
        driverUtils=null;
    }

    private void startChrome(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=" +
                ConfigUtil.getConfProperty("windowWidth") +","+
                ConfigUtil.getConfProperty("windowHeight"));
        options.addArguments("--"+ConfigUtil.getConfProperty("smoothScrollChrome")+"-smooth-scrolling");
        options.addArguments("--lang="+ ConfigUtil.getConfProperty("language"));
        webDriver = new ChromeDriver(options);
    }
    private void startFireFox(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("intl.accept_languages", ConfigUtil.getConfProperty("language"));
        profile.setPreference("general. smoothScroll",ConfigUtil.getConfProperty("smoothScrollFireFox"));
        FirefoxOptions options = new FirefoxOptions();
        firefoxOptions.addArguments("--width=" + ConfigUtil.getConfIntProperty("windowWidth"));
        firefoxOptions.addArguments("--height=" + ConfigUtil.getConfIntProperty("windowHeight"));
        options.setProfile(profile);
        webDriver = new FirefoxDriver(firefoxOptions);
    }
}
