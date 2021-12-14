import instruments.MyProperties;
import instruments.MyWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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
        MarketPage marketPage = new MarketPage();
        marketPage.openPage();
        marketPage.isMarketPage();
        marketPage.searchOnMarket();
        marketPage.checkFilterAndResult();
        marketPage.deleteTagForSearch();
        marketPage.getFirstItemAndOpen();
        Thread.sleep(1000);

    }

}
