package elements;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.LoggerUtil;
import utils.WaitUtil;


public abstract class BaseElement {
    private String name;
    private By locator;

    public BaseElement(By locator, String name) {
        this.name = name;
        this.locator = locator;
    }

    public String getAttribute(String attribute){
        return null;
    }
    public void click(){
        WaitUtil.waitClickable(findElement()).click();
        LoggerUtil.log(name,"Clicked");
    }

    private WebElement findElement(){
        try {
            WebElement element = WaitUtil.waitPresence(locator);
            LoggerUtil.log(name,"Element found");
            return element;
        } catch (Exception e){
            LoggerUtil.log(name,"Didn't find element ");
        }
        return null;
    }
}
