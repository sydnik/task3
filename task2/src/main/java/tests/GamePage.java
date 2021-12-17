package tests;

import data.Game;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GamePage extends Page {

    public GamePage() {
        super();
    }
    public void isGamePage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("game_highlights")));
    }
    public Game getGame() {
        String name = waitPresence(By.id("appHubAppName")).getText();
        String price = waitPresence(By.xpath("//*[@itemprop='price']")).getAttribute("content");
        String date = waitPresence(By.className("date")).getText();
        return new Game(name,date,price);
    }
}
