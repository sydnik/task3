package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ItemPage extends Page{
    private final By
            KEY_PAGE = By.id("largeiteminfo"),
            NAME_ITEM = By.id("largeiteminfo_item_name"),
            ITEM_TYPE = By.id("largeiteminfo_item_type"),
            NAME_GAME = By.id("largeiteminfo_game_name"),
            HERO = By.xpath("//*[@id='largeiteminfo_item_descriptors']/div[1]");

    public ItemPage() {
        super();
    }

    public void isItemPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(KEY_PAGE));
    }
    public void checkFirstItemWithThis(String nameItem){
        wait.until(ExpectedConditions.textToBe(NAME_ITEM,nameItem));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(ITEM_TYPE,properties.getDataProperty("rarity")));
        wait.until(ExpectedConditions.textToBe(NAME_GAME,properties.getDataProperty("gameSearch")));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(HERO,properties.getDataProperty("hero")));
    }

}
