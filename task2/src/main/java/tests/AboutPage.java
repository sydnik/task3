package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AboutPage extends Page {

    public AboutPage(){
        super();
    }

    public void isAboutPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("about_greeting")));
        Assert.assertEquals(webDriver.getCurrentUrl(), (properties.getDataString("aboutURL")));
    }

    public void comparePlayer() {
        ////*[contains(@class, 'gamers_online')]//parent::*/text()[2]    в хроме работает, тут нет - no such element

        WebElement online = webDriver.findElement(
                By.xpath("//div[contains(@class, 'gamers_online')]//parent::div[@class='online_stat']"));
        String[] line = online.getText().split("\n");
        int numberOfOnline = Integer.parseInt(line[1].replaceAll(",",""));

        WebElement gamersInGame = webDriver.findElement(By.xpath(
                "//div[contains(@class, 'gamers_in_game')]//parent::div[@class='online_stat']"));
        line = gamersInGame.getText().split("\n");
        int numberInGame = Integer.parseInt(line[1].replaceAll(",","")) ;

        Assert.assertTrue(numberOfOnline>numberInGame);
    }

    public void clickShop(){
        WebElement element = webDriver.findElement(By.xpath(
                "//div[@class='supernav_container']//a[@data-tooltip-content='.submenu_store']"));
        element.click();
    }
    public void openPage(){
        webDriver.get(properties.getDataString("aboutURL"));
    }
}
