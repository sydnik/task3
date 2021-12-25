package pagesAndForms.pages;

import elements.Button;
import org.openqa.selenium.By;
import pagesAndForms.BasePage;

public class AlertsFrameWindowsPage extends BasePage {
    private final By BUTTON_ALERT = By.xpath("//*[@class='text'][text()='Alerts']");
    private final By BUTTON_NESTED_FRAMES = By.xpath("//*[@class='text'][text()='Nested Frames']");
    private final By BUTTON_FRAMES = By.xpath("//*[@class='text'][text()='Frames']");
    private final By BUTTON_BROWSER_WINDOW = By.xpath("//*[@class='text'][text()='Browser Windows']");


    public AlertsFrameWindowsPage() {
        super(By.xpath("//div[@class='main-header'][text()='Alerts, Frame & Windows']"), "AlertsFrameWindowsPage");
    }
    public void openAlert(){
        Button alert = new Button(BUTTON_ALERT,"ButtonAlert");
        alert.click();
    }
    public void openNestedFrames(){
        Button nestedFrames = new Button(BUTTON_NESTED_FRAMES,"NestedFramesForm");
        nestedFrames.scrollToElement();
        nestedFrames.click();
    }
    public void openFrames(){
        Button nestedFrames = new Button(BUTTON_FRAMES,"FramesForm");
        nestedFrames.scrollToElement();
        nestedFrames.click();
    }
    public void openBrowserWindow(){
        Button nestedFrames = new Button(BUTTON_BROWSER_WINDOW,"BrowserWindow");
        nestedFrames.click();
    }
}
