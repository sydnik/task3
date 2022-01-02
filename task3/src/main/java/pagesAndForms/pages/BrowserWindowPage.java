package pagesAndForms.pages;

import elements.Button;
import org.openqa.selenium.By;
import pagesAndForms.BaseForm;
import pagesAndForms.ClickLeftButtons;

public class BrowserWindowPage extends BaseForm implements ClickLeftButtons {
    private final By BUTTON_NEW_TAB = By.id("tabButton");
    private final By BUTTON_NEW_WINDOW = By.id("windowButton");
    private final By BUTTON_NEW_WINDOW_MESSAGE = By.id("messageWindowButton");

    public BrowserWindowPage() {
        super(By.id("browserWindows"), "BrowserWindowPage");

    }

    public void clickNewTab(){
        Button button = new Button(BUTTON_NEW_TAB,"newTab");
        button.click();
    }
    public void clickNewWindow(){
        Button button = new Button(BUTTON_NEW_WINDOW,"newWindow");
        button.click();
    }
    public void clickNewWindowMessage(){
        Button button = new Button(BUTTON_NEW_WINDOW_MESSAGE,"newWindowMessage");
        button.click();
    }
}
