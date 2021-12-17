package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MarketPage extends Page{

    public MarketPage() {
        super();
    }
    public void isMarketPage(){
        wait.until(ExpectedConditions.urlToBe(properties.getDataProperty("marketURL")));
        waitVisibility(By.xpath("//div[@class='market_header_logo']"));
    }
    public void searchOnMarket(){
        By      xpathButtonSearch = By.id("market_search_advanced_show"),
                xpathSelectGame = By.id("app_option_0_selected"),
                xpathGame = By.xpath("//div[@id='market_advancedsearch_appselect_options']//img[@alt='" + properties.getDataProperty("gameSearch") +"']"),
                xpathSelectHero = By.xpath("//div[@id='market_advancedsearch_filters']//select[contains(@name,'Hero')]"),
                xpathHero = By.xpath("//div[@class='econ_tag_filter_category']//option[text()='" + properties.getDataProperty("hero") + "']"),
                xpathRarity = By.xpath("//div[@id='market_advancedsearch_filters']//span[text()='" + properties.getDataProperty("rarity") + "']"),
                xpathTextField = By.id("advancedSearchBox"),
                xpathButtonFind = By.xpath("//*[@class='market_advancedsearch_bottombuttons']/div");

        waitClickable(xpathButtonSearch).click();
        waitClickable(xpathSelectGame).click();
        waitClickable(xpathGame).click();
        waitClickable(xpathSelectHero).click();
        waitClickable(xpathHero).click();
        waitClickable(xpathRarity).click();
        waitClickable(xpathTextField).sendKeys(properties.getDataProperty("nameThing"));
        waitClickable(xpathButtonFind).click();

    }
    public void checkFilterAndResult(){
        By      xpathTagGame = By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'" + properties.getDataProperty("gameSearch") + "')]]"),
                xpathTagHero = By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'" + properties.getDataProperty("hero") + "')]]"),
                xpathTagRarity = By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'" + properties.getDataProperty("rarity") + "')]]"),
                xpathTagNameThing = By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'" + properties.getDataProperty("nameThing") + "')]]");
        String line = properties.getDataProperty("nameThing").toLowerCase();

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
        String deleteTag[] = properties.getDataProperty("tagMarketToDelete").split("%");
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
    public String getFirstItemAndOpen(){
        By      xpathFirstItem = By.id("result_0");

        String fullName = waitPresence(xpathFirstItem).getAttribute("data-hash-name");
        waitClickable(xpathFirstItem).click();
        return fullName;
    }
    public void openPage(){
        webDriver.get(properties.getDataProperty("marketURL"));
    }

}
