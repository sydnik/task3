package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
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

    public boolean isInVisibility(){
        return WaitUtil.waitInVisibility(locator);
    }
    public boolean isVisibility(){
        return findElement().isDisplayed();
    }
    public String getAttribute(String attribute){
        String result = findElement().getAttribute(attribute);
        return result;
    }
    public String getText(){
        try {
            String result = findElement().getText();
            LoggerUtil.info(name, "got Label");
            return result;
        }catch (Exception e) {
            LoggerUtil.error(name,"");
            throw new RuntimeException();
        }
    }
    public void click(){
        try {
            WaitUtil.waitClickable(findElement()).click();
            LoggerUtil.info(name,"Clicked");
        }
        catch (ElementClickInterceptedException e) {
            scrollAndClickElement();
        }
        catch (Exception e){
            LoggerUtil.error(name,"Didn't click element "+e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    protected void scrollToElement(){
//        new Actions(DriverUtil.getInstance().getWebDriver()).moveToElement(findElement()).build().perform();
        JavascriptExecutor js = ((JavascriptExecutor) DriverUtil.getInstance().getWebDriver());
        js.executeScript("arguments[0].scrollIntoView(true);", findElement());
        try {
            Thread.sleep(10);// пока не нашел лучшего способа( Если убрать 10мс то клик очень часто промахивается.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
    protected void scrollAndClickElement(){
        try {
            scrollToElement();
            WaitUtil.waitClickable(findElement()).click();
        } catch (Exception e){
            LoggerUtil.error(name,"Didn't click element after scroll "+e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

}
