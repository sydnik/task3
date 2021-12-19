package tests;

import org.openqa.selenium.By;

public class AboutPage extends Page {
    private final By
            ONLINE_MEN = By.xpath("//div[contains(@class, 'gamers_online')]//parent::div[@class='online_stat']"),
            GAMERS_IN_ONLINE =By.xpath("//div[contains(@class, 'gamers_in_game')]//parent::div[@class='online_stat']"),
            BUTTON_STORE = By.xpath("//div[@class='supernav_container']//a[@data-tooltip-content='.submenu_store']"),
            KEY_PAGE = By.id("about_greeting");

    public AboutPage(){
        super();
    }

    public void isAboutPage(){
        waitPresence(KEY_PAGE);
    }

    public boolean comparePlayer() {
        String[] line = waitPresence(ONLINE_MEN).getText().split("\n");
        int numberOfOnline = Integer.parseInt(line[1].replaceAll(",",""));

        line = waitPresence(GAMERS_IN_ONLINE).getText().split("\n");
        int numberInGame = Integer.parseInt(line[1].replaceAll(",","")) ;

        return numberOfOnline>numberInGame;
    }

    public void clickShop(){
        waitClickable(BUTTON_STORE).click();
    }
}
