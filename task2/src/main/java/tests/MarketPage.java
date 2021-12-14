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
        wait.until(ExpectedConditions.urlToBe(properties.getDataString("marketURL")));
        waitVisibility(By.xpath("//div[@class='market_header_logo']"));
    }
    public void searchOnMarket(){
        By      xpathButtonSearch = By.id("market_search_advanced_show"),
                xpathSelectGame = By.id("app_option_0_selected"),
                xpathGame = By.xpath("//div[@id='market_advancedsearch_appselect_options']//img[@alt='" + properties.getDataString("gameSearch") +"']"),
                xpathSelectHero = By.xpath("//div[@id='market_advancedsearch_filters']//select[contains(@name,'Hero')]"),
                xpathHero = By.xpath("//div[@class='econ_tag_filter_category']//option[text()='" + properties.getDataString("hero") + "']"),
                xpathRarity = By.xpath("//div[@id='market_advancedsearch_filters']//span[text()='" + properties.getDataString("rarity") + "']"),
                xpathTextField = By.id("advancedSearchBox"),
                xpathButtonFind = By.xpath("//*[@class='market_advancedsearch_bottombuttons']/div");

        waitClickable(xpathButtonSearch).click();
        waitClickable(xpathSelectGame).click();
        waitClickable(xpathGame).click();
        waitClickable(xpathSelectHero).click();
        waitClickable(xpathHero).click();
        waitClickable(xpathRarity).click();
        waitClickable(xpathTextField).sendKeys(properties.getDataString("nameThing"));
        waitClickable(xpathButtonFind).click();

    }
    public void checkFilterAndResult(){
        By      xpathTagGame = By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'" + properties.getDataString("gameSearch") + "')]]"),
                xpathTagHero = By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'" + properties.getDataString("hero") + "')]]"),
                xpathTagRarity = By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'" + properties.getDataString("rarity") + "')]]"),
                xpathTagNameThing = By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'" + properties.getDataString("nameThing") + "')]]");
        String line = properties.getDataString("nameThing").toLowerCase();

        for (int i =0;i<5;i++){
            Assert.assertTrue(waitVisibility(By.id("result_"+i)).
                    getAttribute("data-hash-name").toLowerCase().contains(line));
        }
        waitVisibility(xpathTagGame);
        waitVisibility(xpathTagHero);
        waitVisibility(xpathTagRarity);
        waitVisibility(xpathTagNameThing);
    }
    public void deleteTagForSearch(){
        WebElement removeTag;
        String deleteTag[] = properties.getDataString("tagMarketToDelete").split("%");
        By[] xpathForDeletion = new By[deleteTag.length];
        for (int i = 0; i <deleteTag.length; i++) {
            xpathForDeletion[i] = By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'" + deleteTag[i] + "')]]");
        }

        for (int i = 0; i <xpathForDeletion.length; i++) {
            removeTag = waitClickable(xpathForDeletion[i]);
            removeTag.click();
            waitStalenessOf(removeTag);
        }
    }
    public ItemDota getFirstItemAndOpen(){
        String fullName,rarity,hero,game;
        By      xpathFirstItem = By.id("result_0"),
                xpathRarity = By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'" + properties.getDataString("rarity") + "')]]"),
                xpathHero = By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'" + properties.getDataString("hero") + "')]]"),
                xpathGame = By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'" + properties.getDataString("gameSearch") + "')]]");

        fullName = waitPresence(xpathFirstItem).getAttribute("data-hash-name");
        rarity = waitPresence(xpathRarity).getText();
        hero = waitPresence(xpathHero).getText();
        game = waitPresence(xpathGame).getText();
        waitClickable(xpathFirstItem).click();
        return new ItemDota(fullName,rarity,hero,game);
    }
    public void openPage(){
        webDriver.get(properties.getDataString("marketURL"));
    }

}
