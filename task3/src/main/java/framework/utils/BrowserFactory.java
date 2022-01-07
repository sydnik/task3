package framework.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class BrowserFactory {
    public static WebDriver getBrowser (String browserName){
        switch (browserName) {
            case "FireFox": {
                return startFireFox();
            }
            case "Chrome": {
                return startChrome();
            } default: {
                LoggerUtil.fatal(BrowserFactory.class, browserName + " - invalid browser name");
                throw new IllegalArgumentException(browserName + " - invalid browser name");
            }
        }
    }
    private static WebDriver startChrome(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=" +
                ConfigUtil.getConfProperty("windowWidth") +","+
                ConfigUtil.getConfProperty("windowHeight"));
        options.addArguments("--"+ConfigUtil.getConfProperty("smoothScrollChrome")+"-smooth-scrolling");
        options.addArguments("--lang="+ ConfigUtil.getConfProperty("language"));
        return new ChromeDriver(options);
    }
    private static WebDriver startFireFox(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("intl.accept_languages", ConfigUtil.getConfProperty("language"));
        profile.setPreference("general. smoothScroll",ConfigUtil.getConfProperty("smoothScrollFireFox"));
        FirefoxOptions options = new FirefoxOptions();
        firefoxOptions.addArguments("--width=" + ConfigUtil.getConfIntProperty("windowWidth"));
        firefoxOptions.addArguments("--height=" + ConfigUtil.getConfIntProperty("windowHeight"));
        options.setProfile(profile);
        return  new FirefoxDriver(firefoxOptions);
    }
}
