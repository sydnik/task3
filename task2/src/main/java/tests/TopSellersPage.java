package tests;

import data.Game;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopSellersPage extends Page {
    private int numberOfGameTags;
    private int foundGame;

    public TopSellersPage() {
        super();
    }

    public void isTopSellersPage(){
        waitVisibility(By.id("search_results"));
        wait.until(ExpectedConditions.urlToBe(properties.getDataString("topSellersURL")));
    }

    public void selectOS(){
        By      xpathTagOS = By.xpath("//span[@data-loc='"+ properties.getDataString("tagOS") +"']"),
                xpathListOS = By.xpath("//input[@id='os']//parent::*"),
                xpathHeaderOS = By.xpath("//div[@data-collapse-name='os']"),
                xpathRefreshList = By.xpath("//*[@id='search_resultsRows']/a[1]");

        if(!waitPresence(xpathListOS).isDisplayed()) {
            waitClickable(xpathHeaderOS).click();
        }
        WebElement refreshList = waitVisibility(xpathRefreshList);
        waitClickable(xpathTagOS).click();
        waitStalenessOf(refreshList);
    }

    public void selectNumberPayers() {
        By      xpathTagNumberOfPlayers = By.xpath("//span[@data-loc='"+ properties.getDataUTF8("tagPlayers") +"']/span/span"),
                xpathListNumberOfPlayers = By.xpath("//input[@id='category3']//parent::*"),
                xpathHeaderNumberOfPlayers = By.xpath("//div[@data-collapse-name='category3']"),
                xpathRefreshList = By.xpath("//*[@id='search_resultsRows']/a[1]");

        if(!waitPresence(xpathListNumberOfPlayers).isDisplayed()) {
            waitClickable(xpathHeaderNumberOfPlayers).click();
        }
        waitVisibility(xpathHeaderNumberOfPlayers);
        WebElement refreshList = waitVisibility(xpathRefreshList);
        waitClickable(xpathTagNumberOfPlayers).click();
        waitStalenessOf(refreshList);
    }

    public void selectTags() {
        String tag = properties.getDataUTF8("tags");
        By      xpathTagsContainer = By.xpath("//div[@id='TagFilter_Container']"),
                xpathTagsTextField = By.id("TagSuggest"),
                xpathSelectTag = By.xpath("//div[@data-loc='" + tag + "']"),
                xpathRefreshList = By.xpath("//*[@id='search_resultsRows']/a[1]"),
                xpathHeaderTag = By.xpath("//div[@data-collapse-name='tags']");

        if(!waitPresence(xpathTagsContainer).isDisplayed()) {
            webDriver.findElement(xpathHeaderTag).click();
            waitVisibility(xpathTagsContainer);
        }
        new Actions(webDriver).moveToElement(waitClickable(xpathTagsTextField)).click().sendKeys(tag).build().perform();
        WebElement webDriverElement  = waitVisibility(xpathSelectTag);
        numberOfGameTags = Integer.parseInt(webDriverElement.getText().replaceAll("[^0-9]",""));
        WebElement elementGame = waitVisibility(xpathRefreshList);
        waitClickable(xpathSelectTag).click();
        waitStalenessOf(elementGame);
    }

    public void checkTags() {
        By xpathResultGame = By.xpath("//*[@id='search_results']/div[1]");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(xpathResultGame, String.valueOf(numberOfGameTags)));
    }
    public Game getFirstGame(){
        By      xpathName = By.xpath("//div[@id='search_resultsRows']//span[contains(@class,'title')]"),
                xpathDateReleased = By.xpath("//div[@id='search_resultsRows']//div[contains(@class,'search_released')]"),
                xpathPrice = By.xpath("//div[@id='search_resultsRows']//div[contains(@class,'search_price')]");

        String name = waitPresence(xpathName).getText();
        String date = waitPresence(xpathDateReleased).getText();
        String[] priceList = waitPresence(xpathPrice).getText().split("\n");
        String price = priceList[priceList.length-1].replace("$","");
        return new Game(name,date,price);
    }
    public void openGamePage(){
        webDriver.findElement(By.xpath("//div[@id='search_resultsRows']//a")).click();
    }
    public void openPage(){
        webDriver.get(properties.getDataString("topSellersURL"));
    }
}
