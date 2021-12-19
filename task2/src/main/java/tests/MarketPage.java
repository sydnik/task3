package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MarketPage extends Page{
    private final By
            KEY_MARKET = By.xpath("//div[@class='market_header_logo']"),
            FIRST_ITEM = By.id("result_0"),
            GAME = By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'" + properties.getDataProperty("gameSearch") + "')]]"),
            HERO = By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'" + properties.getDataProperty("hero") + "')]]"),
            RARITY = By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'" + properties.getDataProperty("rarity") + "')]]"),
            NAME_ITEM = By.xpath("//*[@class='market_search_results_header']//*[text()[contains(.,'" + properties.getDataProperty("nameThing") + "')]]"),
            BUTTON_SEARCH = By.id("market_search_advanced_show");

    public MarketPage() {
        super();
    }
    public void isMarketPage(){
        waitVisibility(KEY_MARKET);
    }
    public void searchOnMarket(){
        waitClickable(BUTTON_SEARCH).click();
    }
    public boolean checkFilterAndResult(){
        String line = properties.getDataProperty("nameThing").toLowerCase();
        for (int i =0;i<5;i++){
            if (!waitVisibility(By.id("result_" + i)).getAttribute("data-hash-name").toLowerCase().contains(line)) {
                return false;
            }
        }
        waitVisibility(GAME);
        waitVisibility(HERO);
        waitVisibility(RARITY);
        waitVisibility(NAME_ITEM);
        return true;
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
        String fullName = waitPresence(FIRST_ITEM).getAttribute("data-hash-name");
        waitClickable(FIRST_ITEM).click();
        return fullName;
    }

}
