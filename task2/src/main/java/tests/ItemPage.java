package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ItemPage extends Page{
    private String itemDota;

    public ItemPage(String itemDota) {
        super();
        this.itemDota = itemDota;
    }

    public void isItemPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("largeiteminfo")));
    }
    public void checkFirstItemWithThis(){
        wait.until(ExpectedConditions.textToBe(By.id("largeiteminfo_item_name"),itemDota));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("largeiteminfo_item_type"),properties.getDataProperty("rarity")));
        wait.until(ExpectedConditions.textToBe(By.id("largeiteminfo_game_name"),properties.getDataProperty("gameSearch")));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='largeiteminfo_item_descriptors']/div[1]"),properties.getDataProperty("hero")));
    }

}
