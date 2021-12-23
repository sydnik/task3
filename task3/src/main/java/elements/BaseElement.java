package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.DriverUtil;
import utils.LoggerUtil;
import utils.WaitUtil;


public abstract class BaseElement {
    private String name;
    private By locator;

    public BaseElement(By locator, String name) {
        this.name = name;
        this.locator = locator;
    }

    public boolean exist(){
        WebElement element = WaitUtil.waitVisibility(findElement());
        if(element!=null) {
            return true;
        } else {
            LoggerUtil.error(name,"there is no element");
            return false;
        }

    }
    public String getAttribute(String attribute){
        String result = findElement().getAttribute(attribute);
        return null;
    }
    public String getText(){
        try {
            String result = findElement().getText();
            LoggerUtil.info(name, "got Text");
            return result;
        }catch (Exception e) {
            return findElement().getText();
        }
    }
    public void click(){
        try {
            WaitUtil.waitClickable(findElement()).click();
            LoggerUtil.info(name,"Clicked");
        } catch (Exception e){
            LoggerUtil.error(name,"Didn't find element ");
        }
    }
    public void scrollToElement(){
        ((JavascriptExecutor) DriverUtil.getInstance().getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", findElement());
    }

    private WebElement findElement(){
        try {
            WebElement element = WaitUtil.waitPresence(locator);
            LoggerUtil.info(name,"Element found");
            return element;
        } catch (Exception e){
            LoggerUtil.error(name,"Didn't find element ");
            return null;
        }
    }

}
