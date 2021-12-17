package instruments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyWebDriver   {
    private static WebDriver driver;


    private MyWebDriver(){
    }

    public static WebDriver getInstance(){
        if(driver==null) {
            switch (MyProperties.getInstance().getConfProperty("browser")) {
                case "Edge": {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                }
                case "FireFox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
            }
            setSizeWindow();
        }
        return driver;
    }

    private static void setSizeWindow(){
        int width = MyProperties.getInstance().getConfIntProperty("windowWidth");
        int height = MyProperties.getInstance().getConfIntProperty("windowHeight");
        driver.manage().window().setSize(new Dimension(width,height));
    }

}
