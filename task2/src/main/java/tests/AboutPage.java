package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AboutPage extends Page {

    public AboutPage(){
        super();
    }

    public void isAboutPage(){
        waitPresence(By.id("about_greeting"));
        wait.until(ExpectedConditions.urlToBe(properties.getDataProperty("aboutURL")));
    }

    public void comparePlayer() {
        ////*[contains(@class, 'gamers_online')]//parent::*/text()[2]    в хроме работает, тут нет - no such element
        By      xpathOnline = By.xpath("//div[contains(@class, 'gamers_online')]//parent::div[@class='online_stat']"),
                xpathGamerInGame =By.xpath("//div[contains(@class, 'gamers_in_game')]//parent::div[@class='online_stat']");

        String[] line = waitPresence(xpathOnline).getText().split("\n");
        int numberOfOnline = Integer.parseInt(line[1].replaceAll(",",""));

        line = waitPresence(xpathGamerInGame).getText().split("\n");
        int numberInGame = Integer.parseInt(line[1].replaceAll(",","")) ;

        Assert.assertTrue(numberOfOnline>numberInGame);
    }

    public void clickShop(){
        waitClickable(By.xpath("//div[@class='supernav_container']//a[@data-tooltip-content='.submenu_store']")).click();
    }
    public void openPage(){
        webDriver.get(properties.getDataProperty("aboutURL"));
    }
}
