import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;


public class Main {
    private static final String PATH_CHROME_DRIVER = "D:\\JAVA\\Driver\\chromedriver.exe";
    private static final String URL_STEAM = "https://store.steampowered.com";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        IsMainPage isMainPage = new IsMainPage(URL_STEAM);
        try {
            driver.get(URL_STEAM);
            driver.get(URL_STEAM);
            driver.get(URL_STEAM);
            System.out.println(isMainPage.isMain(driver));
        }finally {
            driver.quit();
        }
    }
}
