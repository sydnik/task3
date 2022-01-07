package pages;

import framework.elements.Button;
import framework.elements.Container;
import org.openqa.selenium.By;
import framework.BaseForm;

public class BrowserWindowPage extends BaseForm {
    private final Button NEW_TAB_BUTTON = new Button(By.id("tabButton"),"newTabButton");
    private final Button NEW_WINDOW_BUTTON = new Button(By.id("windowButton"),"newWindowButton");
    private final Button NEW_WINDOW_MESSAGE_BUTTON = new Button(By.id("messageWindowButton"),"newWindowMessageButton");

    public BrowserWindowPage() {
        super(new Container(By.id("browserWindows"),"UniqueElementOfBrowserWindowPage"), "BrowserWindowPage");

    }

    public void clickNewTab(){
        NEW_TAB_BUTTON.click();
    }

    public void clickNewWindow(){
        NEW_WINDOW_BUTTON.click();
    }

    public void clickNewWindowMessage(){
        NEW_WINDOW_MESSAGE_BUTTON.click();
    }
}
