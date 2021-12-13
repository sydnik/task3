import Instruments.MyProperties;
import Instruments.MyWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import tests.MainPage;
import tests.MarketPage;

public class Test extends Tests {
    private WebDriver webDriver;
    private MyProperties properties;
    @BeforeTest
    public void startTests(){
        webDriver = MyWebDriver.getInstance();
        properties = MyProperties.getInstance();
    }
    @AfterTest
    public void endTests(){
        if (webDriver!=null) {
            webDriver.quit();
        }
    }
    @org.testng.annotations.Test
    public void test() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openPage();
        mainPage.isMainPage();
        mainPage.openMarket();
        MarketPage marketPage = new MarketPage();
        marketPage.isMarketPage();
        marketPage.searchOnMarket();
        Thread.sleep(1000);

    }

}
