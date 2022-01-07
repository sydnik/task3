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
            LoggerUtil.info(this.getClass(),name + " is invisible");
            return result;
        }catch (Exception e){
            LoggerUtil.error(this.getClass(),name + " is visible\n" + e.getMessage());
            throw e;
        }
    }

    public boolean isVisibilityNow(){
        LoggerUtil.info(this.getClass()," - visibility now" + name);
        return findElement().isDisplayed();
    }

    public boolean exist(){
        try {
            LoggerUtil.error(this.getClass(),"check exist"+ name);
            findElement();
            return true;
        }catch (Exception e){
            LoggerUtil.error(this.getClass(),  "there is no element"+ name);
            throw e;
        }
    }
    public boolean unExist(){
        try {
            LoggerUtil.error(this.getClass(),"check un exist"+ name);

            return WaitUtil.waitUnPresence(locator);
        }catch (Exception e){
            LoggerUtil.error(this.getClass(),  "there is "+ name);
            throw e;
        }
    }

    public String getAttribute(String attribute){
        String result = findElement().getAttribute(attribute);
        return result;
    }

    public String getText(){
        try {
            String result = findElement().getText();
            LoggerUtil.info(this.getClass(),  "got text of the" + name );
            return result;
        }catch (Exception e) {
            LoggerUtil.error(this.getClass(),"Didn't get text of the"+ name + "\n" + e.getMessage());
            throw e;
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
            LoggerUtil.info(this.getClass(),"Clicked"+name);
        }
        catch (ElementClickInterceptedException e) {
            scrollAndClickElement();
        }
        catch (Exception e){
            LoggerUtil.error(this.getClass(),"Didn't click " + name +"\n" + e.getMessage());
            throw e;
        }
    }

    protected void scrollToElement(){
        JavascriptExecutor js = ((JavascriptExecutor) DriverUtil.getWebDriver());
        js.executeScript("arguments[0].scrollIntoView(true);", findElement());
    }
    protected WebElement findElement(){
        try {
            WebElement element = WaitUtil.waitPresence(locator);
            LoggerUtil.info(( this.getClass()),name + "found");
            return element;
        } catch (Exception e){
            LoggerUtil.error(this.getClass(),"Didn't find "+ name +"\n" + e.getMessage());
            throw e;
        }
    }
    protected void scrollAndClickElement(){
        try {
            scrollToElement();
            WaitUtil.waitClickable(findElement()).click();
            LoggerUtil.info(this.getClass(),name + "Used scrollAndClickElement successfully");
        } catch (Exception e){
            LoggerUtil.error(this.getClass(),"Didn't click " + name + " after scroll "+"\n" + e.getMessage());
            throw e;
        }
    }

}
