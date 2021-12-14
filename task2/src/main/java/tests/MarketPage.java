package tests;

import data.ItemDota;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MarketPage extends Page{

    public MarketPage() {
        super();
    }
    public void isMarketPage(){
        Assert.assertEquals(webDriver.getCurrentUrl(),properties.getDataString("marketURL"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='market_header_logo']")));
    }
    public void searchOnMarket(){
        webDriver.findElement(By.id("market_search_advanced_show")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("app_option_0_selected"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='market_advancedsearch_appselect_options']//img[@alt='"
                + properties.getDataString("gameSearch") +"']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='market_advancedsearch_filters']//select[contains(@name,'Hero')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='econ_tag_filter_category']//option[text()='"
                + properties.getDataString("hero") + "']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='market_advancedsearch_filters']//span[text()='"
                + properties.getDataString("rarity") + "']"))).click();
        webDriver.findElement(By.id("advancedSearchBox")).sendKeys(properties.getDataString("nameThing"));
        webDriver.findElement(By.xpath("//*[@class='market_advancedsearch_bottombuttons']/div")).click();

    }
    public void checkFilterAndResult(){
        String line = properties.getDataString("nameThing").toLowerCase();
        for (int i =0;i<5;i++){
            Assert.assertTrue(webDriver.findElement(By.id("result_"+i)).
                    getAttribute("data-hash-name").toLowerCase().contains(line));
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'"
                + properties.getDataString("gameSearch") + "')]]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'"
                + properties.getDataString("hero") + "')]]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'"
                + properties.getDataString("rarity") + "')]]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'"
                + properties.getDataString("nameThing") + "')]]")));
    }
    public void deleteTagForSearch(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("market_searchedForTerm")));
        String deleteTag[] = properties.getDataString("tagMarketToDelete").split("%");
        WebElement element;
        for (int i = 0; i <deleteTag.length; i++) {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'" + deleteTag[i] + "')]]")));
            element.click();
            wait.until(ExpectedConditions.stalenessOf(element));
        }
    }
    public void checkFirstItem(){
        String fullName = webDriver.findElement(By.id("result_1")).getAttribute("data-hash-name");

        String rarity = webDriver.findElement(By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'"
                + properties.getDataString("rarity") + "')]]")).getText();
        String hero = webDriver.findElement(By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'"
                + properties.getDataString("hero") + "')]]")).getText();
        String game = webDriver.findElement(By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'"
                + properties.getDataString("gameSearch") + "')]]")).getText();
        ItemDota itemDota1 = new ItemDota(fullName,rarity,hero,game);
        webDriver.findElement(By.id("result_1")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("largeiteminfo")));

        fullName = webDriver.findElement(By.id("largeiteminfo_item_name")).getText();
        //rarity work only RU site split and String[1]. For EN need use split and String[0]
        rarity = webDriver.findElement(By.id("largeiteminfo_item_type")).getText().split(" ")[1];
        game = webDriver.findElement(By.id("largeiteminfo_game_name")).getText();
        hero = webDriver.findElement(By.xpath("//*[@id='largeiteminfo_item_descriptors']/div[1]")).getText();
        hero = hero.substring(hero.indexOf(": ")+2);
        ItemDota itemDota2 = new ItemDota(fullName,rarity,hero,game);
        Assert.assertEquals(itemDota1,itemDota2);
    }
    public void openPage(){
        webDriver.get(properties.getDataString("marketURL"));
    }

}
