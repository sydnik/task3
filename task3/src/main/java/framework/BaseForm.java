package framework;

import framework.elements.BaseElement;
import framework.utils.DriverUtil;
import framework.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;

public abstract class BaseForm {
    private String name;
    private BaseElement uniqueElement;
    private String savedWindow;

    public BaseForm(BaseElement uniqueElement, String name) {
        this.uniqueElement = uniqueElement;
        this.name = name;
    }

    public void switchWindow(By locator){
        try {
            DriverUtil.switchToFrame(locator);
            LoggerUtil.info(this.getClass(),"switch frame to this " + locator);
        }catch (NoSuchFrameException e){
            LoggerUtil.error(this.getClass(),"Didn't switch frame to this " + locator + "\n" + e.getMessage());
            throw e;
        }

    }

    public void saveWindowKey(){
        savedWindow = DriverUtil.getCurrentWindow();
        LoggerUtil.info(this.getClass(),"save window key");
    }

    public void saveCurrentWindow(){
        try {
            DriverUtil.switchToWindow(savedWindow);
            LoggerUtil.info(this.getClass(),"save window key");
        }
        catch (NoSuchWindowException e){
            LoggerUtil.error(this.getClass(),"Didn't switch to window " + "\n" + e.getMessage());
            throw e;
        }

    }

    public boolean isPageOpened(){
        try {
            uniqueElement.exist();
                LoggerUtil.info(this.getClass(),name + " is open");
        }catch (Exception e){
            LoggerUtil.error(this.getClass(),name + " isn't open" + "\n" + e.getMessage());
            throw e;
        }
        return true;
    }

    public boolean isPageClosed(){
        try {
            uniqueElement.isInVisibility();
            LoggerUtil.info(this.getClass(),name + " is closed");
        }catch (Exception e){
            LoggerUtil.error(this.getClass(),name + " isn't closed" + "\n" + e.getMessage());
            throw e;
        }
        return true;
    }
}
