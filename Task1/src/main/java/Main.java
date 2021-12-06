import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class Main {
    private static final String PATH_CHROME_DRIVER = "D:\\JAVA\\Driver\\chromedriver.exe";
//test git
    public static void main(String[] args) {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,PATH_CHROME_DRIVER);
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://store.steampowered.com");
            System.out.println(driver.getTitle());
        }finally {
            driver.quit();
        }
    }
}
