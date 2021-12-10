import Data.Game;
import Instruments.MyProperties;
import Instruments.MyWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.AboutPage;
import tests.GamePage;
import tests.MainPage;
import tests.TopSellersPage;

public class Tests {
    private MyWebDriver webDriver;
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
    public void testCase1() throws InterruptedException {
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
    public void testCase2() throws InterruptedException {
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
//    @Test
    public void betatest() throws InterruptedException {
        for(int i =0;i<3;i++) {
            TopSellersPage sellersPage = new TopSellersPage();
            sellersPage.openPage();
            sellersPage.isTopSellersPage();
            sellersPage.selectOS();
            sellersPage.selectNumberPayers();
            sellersPage.selectTags();
            sellersPage.checkTags();
            sellersPage.openGamePage();
            Thread.sleep(1000);
//            MyWebDriver.closeWebDrive();
//            MyWebDriver.newWebDriver();


        }
    }
}
