package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class MainPage extends Page {
    private final By
            KEY_PAGE = By.xpath("//div[contains(@id,'home_maincap')]"),
            BUTTON_ABOUT = By.xpath("//div[@class='supernav_container']//a[contains(@href,'about')]"),
            NOTEWORTHY_TAB = By.id("noteworthy_tab"),
            BUTTON_TOP_SELLER = By.xpath("//*[@id='noteworthy_flyout']//a[contains(@href,'topseller')]"),
            COMMUNITY_TAB = By.xpath("//*[@id='global_header']//a[contains(@data-tooltip-content,'submenu_community')]"),
            BUTTON_MARKET = By.xpath("//*[@id='global_header']//div[@class='submenu_community']/a[contains(@href,'market')]");

    public MainPage(){
        super();
    }

    public void isMainPage(){
        waitPresence(KEY_PAGE);
    }
    public void openAboutPage(){
        WebElement buttonAbout = waitClickable(BUTTON_ABOUT);
        buttonAbout.click();
    }
    public void openLeaderSeller(){
        new Actions(webDriver).moveToElement(waitClickable(NOTEWORTHY_TAB)).build().perform();
        waitClickable(BUTTON_TOP_SELLER).click();
    }
    public void openMarket(){
        new Actions(webDriver).moveToElement(waitVisibility(COMMUNITY_TAB)).build().perform();
        waitClickable(BUTTON_MARKET).click();
    }

    public void openPage(){
        webDriver.get(properties.getDataProperty("mainPageURL"));
    }
}
