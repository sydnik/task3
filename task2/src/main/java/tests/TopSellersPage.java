package tests;

import data.Game;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopSellersPage extends Page {
    private final By
            TAG_OS = By.xpath("//span[@data-loc='"+ properties.getDataProperty("tagOS") +"']"),
            LIST_OS = By.xpath("//input[@id='os']//parent::*"),
            HEADER_OS = By.xpath("//div[@data-collapse-name='os']"),
            FIRST_GAME_RESULT = By.xpath("//*[@id='search_resultsRows']/a[1]"),
            TAG_NUMBER_PLAYER = By.xpath("//span[@data-loc='"+ properties.getDataProperty("tagPlayers") +"']/span/span"),
            LIST_NUMBER_PLAYER = By.xpath("//input[@id='category3']//parent::*"),
            HEADER_NUMBER_PLAYER = By.xpath("//div[@data-collapse-name='category3']"),
            TAG = By.xpath("//div[@data-loc='" + properties.getDataProperty("tags") + "']"),
            LIST_TAG = By.xpath("//div[@id='TagFilter_Container']"),
            TEXT_FIELD_TAG = By.id("TagSuggest"),
            HEADER_TAG = By.xpath("//div[@data-collapse-name='tags']"),
            LIST_GAME_RESULT = By.xpath("//*[@id='search_results']/div[1]"),
            FIRST_GAME_NAME = By.xpath("//div[@id='search_resultsRows']//span[contains(@class,'title')]"),
            FIRST_GAME_DATE = By.xpath("//div[@id='search_resultsRows']//div[contains(@class,'search_released')]"),
            FIRST_GAME_PRICE = By.xpath("//div[@id='search_resultsRows']//div[contains(@class,'search_price')]"),
            BUTTON_FIRST_GAME = By.xpath("//div[@id='search_resultsRows']//a");

    private int numberOfGameTags;

    public TopSellersPage() {
        super();
    }

    public void isTopSellersPage(){
        waitVisibility(By.id("search_results"));
    }

    public void selectOS(){
        if(!waitPresence(LIST_OS).isDisplayed()) {
            waitClickable(HEADER_OS).click();
        }
        WebElement refreshList = waitVisibility(FIRST_GAME_RESULT);
        waitClickable(TAG_OS).click();
        waitStalenessOf(refreshList);
    }

    public void selectNumberPayers() {
        if(!waitPresence(LIST_NUMBER_PLAYER).isDisplayed()) {
            waitClickable(HEADER_NUMBER_PLAYER).click();
        }
        waitVisibility(HEADER_NUMBER_PLAYER);
        WebElement refreshList = waitVisibility(FIRST_GAME_RESULT);
        waitClickable(TAG_NUMBER_PLAYER).click();
        waitStalenessOf(refreshList);
    }

    public void selectTags() {
        String tag = properties.getDataProperty("tags");
        if(!waitPresence(LIST_TAG).isDisplayed()) {
            waitClickable(HEADER_TAG).click();
            waitVisibility(LIST_TAG);
        }
        new Actions(webDriver).moveToElement(waitClickable(TEXT_FIELD_TAG)).click().sendKeys(tag).build().perform();
        WebElement selectTag  = waitVisibility(TAG);
        numberOfGameTags = Integer.parseInt(selectTag.getText().replaceAll("[^0-9]",""));
        WebElement elementGame = waitVisibility(FIRST_GAME_RESULT);
        waitClickable(TAG).click();
        waitStalenessOf(elementGame);
    }

    public void checkTags() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(LIST_GAME_RESULT, String.valueOf(numberOfGameTags)));
    }
    public Game getFirstGame(){
        String name = waitPresence(FIRST_GAME_NAME).getText();
        String date = waitPresence(FIRST_GAME_DATE).getText();
        String[] priceList = waitPresence(FIRST_GAME_PRICE).getText().split("\n");
        String price = priceList[priceList.length-1].replace("$","");
        return new Game(name,date,price);
    }
    public void openGamePage(){
        waitClickable(BUTTON_FIRST_GAME).click();
    }

}
