package tests;

import data.Game;
import Instruments.MyProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class TopSellersPage extends Page {
    private int numberOfGameTags;
    private int foundGame;

    public TopSellersPage() {
        super();
    }

    public void isTopSellersPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_results")));
        Assert.assertEquals(webDriver.getCurrentUrl(),properties.getDataString("topSellersURL"));
    }

    public void selectOS(){
        if(!webDriver.findElement(By.xpath("//input[@id='os']//parent::*")).isDisplayed()) {
            webDriver.findElement(By.xpath("//div[@data-collapse-name='os']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated((By.ByXPath.xpath("//input[@id='os']//parent::*"))));
        }
        String logOS= properties.getDataString("tagOS");
        WebElement elementOS = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-loc='"+ logOS +"']")));
        elementOS.click();
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(elementOS)));
    }

    public void selectNumberPayers() {
        if(!webDriver.findElement(By.xpath("//input[@id='category3']//parent::*")).isDisplayed()) {
            webDriver.findElement(By.xpath("//div[@data-collapse-name='category3']")).click();
        }

        WebElement blockMode = webDriver.findElement(
                with(By.xpath("//div")).above((By.ByXPath.xpath("//input[@id='category3']"))));
        wait.until(ExpectedConditions.visibilityOf(blockMode));
        //работает в хроме но не работает в коде
        //wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//input[@id='category3']//parent::*"))));
        String tagPlayers = properties.getDataUTF8("tagPlayers");
        WebElement element = webDriver.findElement(By.xpath("//span[@data-loc='"+ tagPlayers +"']"));
        element.click();
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));

    }

    public void selectTags() {

        WebElement tagFilterContainer = webDriver.findElement(By.xpath("//div[@id='TagFilter_Container']/div[1]"));
        if(!tagFilterContainer.isDisplayed()) {
            webDriver.findElement(By.xpath("//div[@data-collapse-name='tags']")).click();
            wait.until(ExpectedConditions.visibilityOf(tagFilterContainer));
        }

        String tag = MyProperties.getInstance().getDataUTF8("tags");
        webDriver.findElement(By.id("TagSuggest")).sendKeys(tag);
        try {
            new WebDriverWait(webDriver,Duration.ofSeconds(1)).until(ExpectedConditions.refreshed(
                    ExpectedConditions.visibilityOf(tagFilterContainer)));
        }
        catch (TimeoutException e){}
        new Actions(webDriver).keyDown(Keys.SHIFT).keyUp(Keys.SHIFT).build().perform();

        WebElement webDriverElement = wait.until(ExpectedConditions.refreshed((ExpectedConditions.presenceOfElementLocated((
                By.xpath("//span[@data-loc='"+ tag +"']//span[@class='tab_filter_control_count']"))))));
        numberOfGameTags = Integer.parseInt(webDriverElement.getText().replaceAll("[^0-9]",""));
        WebElement elementGame = webDriverElement.findElement(By.xpath("//*[@id='search_resultsRows']/a[1]"));
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='TagFilter_Container']//span[text()='"+ tag+"']")));
        webElement.click();
        wait.until(ExpectedConditions.stalenessOf(elementGame));

    }
    public void checkTags() {
        int time = properties.getConfigurationInt("waitSeconds")*2;
        boolean equals = false;
        String result = webDriver.findElement(By.xpath("//*[@id='search_results']/div[1]")).getText();
        result = result.substring(result.indexOf(": ")+2,result.indexOf("."));
        foundGame = Integer.parseInt(result.replaceAll("[^0-9]",""));
        for (int i = 0; i <time; i++) {
            if(foundGame==numberOfGameTags){
                equals = true;
                break;
            }else {
                try {
                    Thread.sleep(500);
                    result = webDriver.findElement(By.xpath("//*[@id='search_results']/div[1]")).getText();
                    result = result.substring(result.indexOf(": ")+2,result.indexOf("."));
                    foundGame = Integer.parseInt(result.replaceAll("[^0-9]",""));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Assert.assertTrue(equals);

    }
    public Game getFirstGame(){
        String name = webDriver.findElement(By.xpath("//div[@id='search_resultsRows']//span[contains(@class,'title')]")).getText();
        String date = webDriver.findElement(By.xpath("//div[@id='search_resultsRows']//div[contains(@class,'search_released')]")).getText();
        String[] priceList = webDriver.findElement(By.xpath("//div[@id='search_resultsRows']//div[contains(@class,'search_price')]")).
                getText().split("\n");
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
