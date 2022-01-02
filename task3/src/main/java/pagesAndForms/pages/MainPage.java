package pagesAndForms.pages;

import elements.Button;
import org.openqa.selenium.By;
import pagesAndForms.BaseForm;

public class MainPage extends BaseForm {
    private final By BUTTON_ALERT_FRAME_WINDOW = By.xpath("//*[@class='card-body']//*[text()='Alerts, Frame & Windows']");
    private final By BUTTON_ELEMENTS = By.xpath("//*[@class='card-body']//*[text()='Elements']");
    private final By BUTTON_WIDGETS = By.xpath("//*[@class='card-body']//*[text()='Widgets']");

    public MainPage() {
        super(By.className("home-content"),"MainPage");
    }

    public void openAlertFrameAndWindow(){
        new Button(BUTTON_ALERT_FRAME_WINDOW,"ButtonAlertFrameAndWindow").click();
    }

    public void openElements(){
        new Button(BUTTON_ELEMENTS,"Elements").click();
    }

    public void openWidgets(){
        new Button(BUTTON_WIDGETS,"Widgets").click();
    }
}
