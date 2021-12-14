package tests;

import data.ItemDota;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ItemPage extends Page{
    private ItemDota itemDota;

    public ItemPage(ItemDota itemDota) {
        super();
        this.itemDota = itemDota;
    }

    public void isItemPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("largeiteminfo")));
    }
    public void checkFirstItemWithThis(){
        String fullName,rarity,hero,game;
        fullName = waitPresence(By.id("largeiteminfo_item_name")).getText();
        //rarity work only RU site split and String[1]. For EN need use split and String[0]
        rarity = waitPresence(By.id("largeiteminfo_item_type")).getText().split(" ")[1];
        game = waitPresence(By.id("largeiteminfo_game_name")).getText();
        hero = waitPresence(By.xpath("//*[@id='largeiteminfo_item_descriptors']/div[1]")).getText();
        hero = hero.substring(hero.indexOf(": ")+2);
        Assert.assertEquals(itemDota,new ItemDota(fullName,rarity,hero,game));
    }

}
