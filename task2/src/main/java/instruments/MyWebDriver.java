package instruments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class MyWebDriver   {
    private static WebDriver driver;


    private MyWebDriver(){
    }

    public static WebDriver getInstance(){
        if(driver!=null) {
            return driver;
        }
        switch (MyProperties.getInstance().getConfProperty("browser")) {
            case "Edge": {
                startEdge();
                break;
            }
            case "FireFox": {
                startFireFox();
                break;
            }
            case "Chrome": {
                startChrome();
                break;
            } default: {
                throw new IllegalArgumentException(driver + " - invalid browser name");
            }
        }
        return driver;
    }

    private static void startChrome(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=" +
                MyProperties.getInstance().getConfProperty("windowWidth") +","+
                MyProperties.getInstance().getConfProperty("windowHeight"));
        driver = new ChromeDriver(options);

    }
    private static void startFireFox(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--width="+MyProperties.getInstance().getConfProperty("windowWidth"));
        firefoxOptions.addArguments("--height="+MyProperties.getInstance().getConfProperty("windowHeight"));
        driver = new FirefoxDriver();
    }
    private static void startEdge(){
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--window-size=" +
                MyProperties.getInstance().getConfProperty("windowWidth") +","+
                MyProperties.getInstance().getConfProperty("windowHeight"));
        driver = new EdgeDriver(edgeOptions);
    }

}
