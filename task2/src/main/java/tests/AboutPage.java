package tests;

import org.openqa.selenium.By;

public class AboutPage extends Page {

    public AboutPage(){
        super();
    }

    public void isAboutPage(){
        waitPresence(By.id("about_greeting"));
    }

    public boolean comparePlayer() {
        By      xpathOnline = By.xpath("//div[contains(@class, 'gamers_online')]//parent::div[@class='online_stat']"),
                xpathGamerInGame =By.xpath("//div[contains(@class, 'gamers_in_game')]//parent::div[@class='online_stat']");

        String[] line = waitPresence(xpathOnline).getText().split("\n");
        int numberOfOnline = Integer.parseInt(line[1].replaceAll(",",""));

        line = waitPresence(xpathGamerInGame).getText().split("\n");
        int numberInGame = Integer.parseInt(line[1].replaceAll(",","")) ;

        return numberOfOnline>numberInGame;
    }

    public void clickShop(){
        waitClickable(By.xpath("//div[@class='supernav_container']//a[@data-tooltip-content='.submenu_store']")).click();
    }
}
