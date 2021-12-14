import data.Game;
import data.ItemDota;
import instruments.MyProperties;
import instruments.MyWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.*;

public class Tests {
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

    @Test
    public void testCase1() {
        MainPage mainPage = new MainPage();
        mainPage.openPage();
        mainPage.isMainPage();
        mainPage.openAboutPage();
        AboutPage aboutPage = new AboutPage();
        aboutPage.isAboutPage();
        aboutPage.comparePlayer();
        aboutPage.clickShop();
        mainPage.isMainPage();
    }
    @Test
    public void testCase2() {
        MainPage mainPage = new MainPage();
        mainPage.openPage();
        mainPage.isMainPage();
        mainPage.openLeaderSeller();
        TopSellersPage sellersPage = new TopSellersPage();
        sellersPage.isTopSellersPage();
        sellersPage.selectOS();
        sellersPage.selectNumberPayers();
        sellersPage.selectTags();
        sellersPage.checkTags();
        Game game = sellersPage.getFirstGame();
        sellersPage.openGamePage();
        GamePage gamePage = new GamePage(game);
        gamePage.isGamePage();
        gamePage.assertData();
    }
    @Test
    public void testCase3() {
        MainPage mainPage = new MainPage();
        mainPage.openPage();
        mainPage.isMainPage();
        mainPage.openMarket();
        MarketPage marketPage = new MarketPage();
        marketPage.isMarketPage();
        marketPage.searchOnMarket();
        marketPage.checkFilterAndResult();
        marketPage.deleteTagForSearch();
        ItemDota item = marketPage.getFirstItemAndOpen();
        ItemPage itemPage = new ItemPage(item);
        itemPage.isItemPage();
        itemPage.checkFirstItemWithThis();
    }

}
