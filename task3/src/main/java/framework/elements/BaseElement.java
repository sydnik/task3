package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import framework.utils.DriverUtil;
import framework.utils.LoggerUtil;
import framework.utils.WaitUtil;


public abstract class BaseElement {
    protected String name;
    protected By locator;

    public BaseElement(By locator, String name) {
        this.name = name;
        this.locator = locator;
    }

    public boolean isInVisibility(){
        try {
            boolean result = WaitUtil.waitInVisibility(locator);
            LoggerUtil.info(name,"Element is invisible");
            return result;
        }catch (Exception e){
            LoggerUtil.error(name,"Element is visible" + e.getMessage());
            throw new RuntimeException();
        }
    }

    public boolean isVisibilityNow(){
           boolean result = findElement().isDisplayed();
           return result;
    }

    public boolean exist(){
        try {
            WaitUtil.waitVisibility(findElement());
            return true;
        }catch (Exception e){
            LoggerUtil.error(name,"there is no element");
            throw new RuntimeException();
        }
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
            LoggerUtil.error(name,"Didn't get text"+"\n" + e.getMessage());
            throw new RuntimeException();
        }
    }

    public int getWidth(){
        return findElement().getSize().width;
    }

    public int getHeight(){
        return findElement().getSize().height;
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
            LoggerUtil.error(name,"Didn't click element "+"\n" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    protected void scrollToElement(){
        JavascriptExecutor js = ((JavascriptExecutor) DriverUtil.getWebDriver());
        js.executeScript("arguments[0].scrollIntoView(true);", findElement());
    }
    protected WebElement findElement(){
        try {
            WebElement element = WaitUtil.waitPresence(locator);
            LoggerUtil.info(name,"Element found");
            return element;
        } catch (Exception e){
            LoggerUtil.error(name,"Didn't find element " +"\n" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
    protected void scrollAndClickElement(){
        try {
            scrollToElement();
            WaitUtil.waitClickable(findElement()).click();
            LoggerUtil.info(name,"Use scrollAndClickElement successfully");
        } catch (Exception e){
            LoggerUtil.error(name,"Didn't click element after scroll "+"\n" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

}
