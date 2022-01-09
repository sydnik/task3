package framework.elements;

import org.apache.commons.logging.Log;
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
        LoggerUtil.info(this.getClass()," - visibility now " + name);
        return findElement().isDisplayed();
    }

    public boolean exist(){
        try {
            findElement();
            LoggerUtil.error(this.getClass(),"check exist "+ name );
            return true;
        }catch (Exception e){
            LoggerUtil.error(this.getClass(),  "there is no element "+ name + "\n" + e.getMessage());
            throw e;
        }
    }

    public boolean unExist(){
        try {
            LoggerUtil.error(this.getClass(),"check un exist "+ name);
            return WaitUtil.waitUnPresence(locator);
        }catch (Exception e){
            LoggerUtil.error(this.getClass(),  "there is "+ name + "\n" + e.getMessage());
            throw e;
        }
    }

    public String getAttribute(String attribute){
        try {
            String result = findElement().getAttribute(attribute);
            LoggerUtil.info(this.getClass(),name  + "found the" + attribute);
            return result;
        }catch (Exception e){
            LoggerUtil.error(this.getClass(), name+ " didn't find the " + attribute);
            throw  e;
        }
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
        LoggerUtil.info(this.getClass(),"get width element");
        return findElement().getSize().width;
    }

    public int getHeight(){
        LoggerUtil.info(this.getClass(),"get height element");
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
        try {
            JavascriptExecutor js = ((JavascriptExecutor) DriverUtil.getWebDriver());
            js.executeScript("arguments[0].scrollIntoView(true);", findElement());
            LoggerUtil.info(this.getClass(),name + " used js scroll");
        }catch (Exception e){
            LoggerUtil.error(this.getClass(),name+" can't use scroll");
        }

    }
    protected WebElement findElement(){
        try {
            WebElement element = WaitUtil.waitPresence(locator);
            LoggerUtil.info(( this.getClass()),name + " found");
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
