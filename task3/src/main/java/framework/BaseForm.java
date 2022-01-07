package framework;

import framework.elements.BaseElement;
import framework.utils.DriverUtil;
import org.openqa.selenium.By;

public abstract class BaseForm {
    private String name;
    private BaseElement uniqueElement;
    private String savedFrame;

    public BaseForm(BaseElement uniqueElement, String name) {
        this.uniqueElement = uniqueElement;
        this.name = name;
    }

    public void switchWindow(By locator){
        DriverUtil.switchToFrame(locator);
    }
    public void saveKeyWindow(){
        savedFrame = DriverUtil.getCurrentWindow();
    }
    public void switchSavedFrame(){
        DriverUtil.switchToFrame(savedFrame);
    }
    public boolean isPageOpened(){
        return uniqueElement.exist();
    }
    public boolean isPageClosed(){
        return uniqueElement.isInVisibility();
    }
}
