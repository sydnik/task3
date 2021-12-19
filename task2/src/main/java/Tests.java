import data.Game;
import formOnPage.SearchOnMarket;
import instruments.MyProperties;
import instruments.MyWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
        Assert.assertTrue(aboutPage.comparePlayer());
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
        GamePage gamePage = new GamePage();
        gamePage.isGamePage();
        Assert.assertEquals(gamePage.getGame(),game);
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
        SearchOnMarket searchOnMarket = new SearchOnMarket();
        searchOnMarket.selectGame();
        searchOnMarket.selectHero();
        searchOnMarket.selectRarity();
        searchOnMarket.sendName();
        searchOnMarket.pushFind();
        Assert.assertTrue(marketPage.checkFilterAndResult());
        marketPage.deleteTagForSearch();
        String nameItem = marketPage.getFirstItemAndOpen();
        ItemPage itemPage = new ItemPage();
        itemPage.isItemPage();
        itemPage.checkFirstItemWithThis(nameItem);
    }

}
