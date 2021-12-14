package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends Page {

    public MainPage(){
        super();
    }

    public void isMainPage(){
        waitPresence(By.xpath("//div[contains(@id,'home_maincap')]"));
        wait.until(ExpectedConditions.urlToBe(properties.getDataString("mainPageURL")));
    }
    public void openAboutPage(){
        WebElement buttonAbout = webDriver.findElement(By.xpath("//div[@class='supernav_container']//a[contains(@href,'about')]"));
        buttonAbout.click();
    }
    public void openLeaderSeller(){
        By      xpathButtonNew = By.id("noteworthy_tab"),
                xpathTopSeller = By.xpath("//*[@id='noteworthy_flyout']//a[contains(@href,'topseller')]");

        new Actions(webDriver).moveToElement(waitClickable(xpathButtonNew)).build().perform();
        waitClickable(xpathTopSeller).click();
    }
    public void openMarket(){
        By      xpathButtonCommunity = By.xpath("//*[@id='global_header']//a[contains(@data-tooltip-content,'submenu_community')]"),
                xpathButtonMarket = By.xpath("//*[@id='global_header']//div[@class='submenu_community']/a[contains(@href,'market')]");

        new Actions(webDriver).moveToElement(waitVisibility(xpathButtonCommunity)).build().perform();
        waitClickable(xpathButtonMarket).click();
    }

    public void openPage(){
        webDriver.get(properties.getDataString("mainPageURL"));
    }
}
