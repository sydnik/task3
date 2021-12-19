package tests;

import data.Game;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GamePage extends Page {
    private final By
            KEY_PAGE = By.id("game_highlights"),
            NAME = By.id("appHubAppName"),
            PRICE = By.xpath("//*[@itemprop='price']"),
            DATE = By.className("date");

    public GamePage() {
        super();
    }
    public void isGamePage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(KEY_PAGE));
    }
    public Game getGame() {
        String name = waitPresence(NAME).getText();
        String price = waitPresence(PRICE).getAttribute("content");
        String date = waitPresence(DATE).getText();
        return new Game(name,date,price);
    }
}
