package formOnPage;

import org.openqa.selenium.By;
import tests.Page;

public class SearchOnMarket extends Page {
    private final By
            SELECT_GAME = By.id("app_option_0_selected"),
            GAME = By.xpath("//div[@id='market_advancedsearch_appselect_options']//img[@alt='" + properties.getDataProperty("gameSearch") +"']"),
            SELECT_HERO = By.xpath("//div[@id='market_advancedsearch_filters']//select[contains(@name,'Hero')]"),
            HERO = By.xpath("//div[@class='econ_tag_filter_category']//option[text()='" + properties.getDataProperty("hero") + "']"),
            RARITY = By.xpath("//div[@id='market_advancedsearch_filters']//span[text()='" + properties.getDataProperty("rarity") + "']"),
            TEXT_FIELD = By.id("advancedSearchBox"),
            BUTTON_SEARCH = By.xpath("//*[@class='market_advancedsearch_bottombuttons']/div");

    public SearchOnMarket(){
        super();
    }
    public void selectGame (){
        waitClickable(SELECT_GAME).click();
        waitClickable(GAME).click();
    }
    public void selectHero(){
        waitClickable(SELECT_HERO).click();
        waitClickable(HERO).click();
    }
    public void sendName(){
        waitClickable(TEXT_FIELD).sendKeys(properties.getDataProperty("nameThing"));
    }
    public void selectRarity(){
        waitClickable(RARITY).click();
    }
    public void pushFind(){
        waitClickable(BUTTON_SEARCH).click();
    }
}
