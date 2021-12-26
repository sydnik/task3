package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.DriverUtil;
import utils.LoggerUtil;
import utils.WaitUtil;


public abstract class BaseElement {
    protected String name;
    protected By locator;

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
            throw new RuntimeException();
        }
    }
    public boolean unExist(){
        return WaitUtil.waitInVisibility(locator);
    }
    public String getAttribute(String attribute){
        String result = findElement().getAttribute(attribute);
        return result;
    }
    public String getText(){
        try {
            String result = findElement().getText();
            LoggerUtil.info(name, "got Text");
            return result;
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public void click(){
        try {
            WaitUtil.waitClickable(findElement()).click();
            LoggerUtil.info(name,"Clicked");
        } catch (Exception e){
            LoggerUtil.error(name,"Didn't click element "+e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
    public boolean isVisibility(){
        return findElement().isDisplayed();
    }
    public void scrollToElement(){
//        new Actions(DriverUtil.getInstance().getWebDriver()).moveToElement(findElement()).build().perform();
        JavascriptExecutor js = ((JavascriptExecutor) DriverUtil.getInstance().getWebDriver());
        js.executeScript("arguments[0].scrollIntoView(true);", findElement());
    }

    protected WebElement findElement(){
        try {
            WebElement element = WaitUtil.waitPresence(locator);
            LoggerUtil.info(name,"Element found");
            return element;
        } catch (Exception e){
            LoggerUtil.error(name,"Didn't find element ");
            throw new RuntimeException(e.getMessage());
        }
    }

}
