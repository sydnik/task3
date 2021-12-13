package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class MainPage extends Page {

    public MainPage(){
        super();
    }

    public void isMainPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@id,'home_maincap')]")));
        Assert.assertEquals(webDriver.getCurrentUrl(),(properties.getDataString("mainPageURL")));
    }
    public void openAboutPage(){
        WebElement buttonAbout = webDriver.findElement(By.xpath("//div[@class='supernav_container']//a[contains(@href,'about')]"));
        buttonAbout.click();
    }
    public void openLeaderSeller(){
        WebElement element = webDriver.findElement(By.id("noteworthy_tab"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("noteworthy_flyout")));
        webDriver.findElement(By.xpath("//*[@id='noteworthy_flyout']//a[contains(@href,'topseller')]")).click();
    }
    public void openMarket(){
        WebElement subMenu = webDriver.findElement(By.xpath("//*[@id='global_header']//a[contains(@data-tooltip-content,'submenu_community')]"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(subMenu).build().perform();
        WebElement market = webDriver.findElement(By.xpath(("//*[@id='global_header']//div[@class='submenu_community']/a[contains(@href,'market')]")));
        wait.until(ExpectedConditions.elementToBeClickable(market)).click();
    }

    public void openPage(){
        webDriver.get(properties.getDataString("mainPageURL"));
    }
}
