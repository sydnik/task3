package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverUtil {
    private WebDriver webDriver;
    private static DriverUtil driverUtils;

    private DriverUtil(){
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public static DriverUtil getInstance(){
        if(driverUtils!=null) {
            return driverUtils;
        }
        driverUtils = new DriverUtil();
        switch (ConfigUtil.getInstance().getConfProperty("browser")) {
            case "FireFox": {
                driverUtils.startFireFox();
                break;
            }
            case "Chrome": {
                driverUtils.startChrome();
                break;
            } default: {
                throw new IllegalArgumentException(ConfigUtil.getInstance().getConfProperty("browser") + " - invalid browser name");
            }
        }
        return driverUtils;
    }

    public void openURL(String url){
        webDriver.get(url);
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
        firefoxOptions.addArguments("--width="+ ConfigUtil.getInstance().getConfProperty("windowWidth"));
        firefoxOptions.addArguments("--height="+ ConfigUtil.getInstance().getConfProperty("windowHeight"));
        webDriver = new FirefoxDriver(firefoxOptions);
    }
}
