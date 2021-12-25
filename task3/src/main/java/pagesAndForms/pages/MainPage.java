package pagesAndForms.pages;

import elements.Button;
import org.openqa.selenium.By;
import pagesAndForms.BasePage;

public class MainPage extends BasePage {
    private final By BUTTON_ALERT_FRAME_WINDOW = By.xpath("//*[@class='card-body']//*[text()='Alerts, Frame & Windows']//..//..");
    private final By BUTTON_ELEMENTS = By.xpath("//*[@class='card-body']//*[text()='Elements']//..//..");


    public MainPage() {
        super(By.className("home-content"),"MainPage");
    }

    public void openAlertFrameAndWindow(){
        Button alertFrameAndWindow = new Button(BUTTON_ALERT_FRAME_WINDOW,"ButtonAlertFrameAndWindow");
        alertFrameAndWindow.click();
    }
    public void openElements(){
        Button alertFrameAndWindow = new Button(BUTTON_ELEMENTS,"Elements");
        alertFrameAndWindow.click();
    }
}
