package tests;

import Data.Game;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class GamePage extends Page {
    private Game game;

    public GamePage(Game game) {
        super();
        this.game = game;
    }
    public void isGamePage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("game_highlights")));
        Assert.assertEquals(game.getName(),webDriver.findElement(By.id("appHubAppName")).getText());
    }
    public void assertData() throws InterruptedException {
        String name = webDriver.findElement(By.id("appHubAppName")).getText();
        String price = webDriver.findElement(By.xpath("//*[@itemprop='price']")).getAttribute("content");
        String date = webDriver.findElement(By.className("date")).getText();
        Game game = new Game(name,date,price);
        Assert.assertEquals(this.game,game);
    }
    public void openPage(){
        webDriver.get(properties.getDataString("gameURL"));
    }



}
