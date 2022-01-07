package pages;

import framework.elements.Button;
import framework.elements.Container;
import org.openqa.selenium.By;
import framework.BaseForm;

public class MainPage extends BaseForm {
    private final Button ALERT_FRAME_WINDOW = new Button(By.xpath("//*[@class='card-body']//*[text()='Alerts, Frame & Windows']"),
            "ButtonAlertFrameAndWindow");
    private final Button ELEMENTS = new Button(By.xpath("//*[@class='card-body']//*[text()='Elements']"), "Elements");
    private final Button WIDGETS = new Button(By.xpath("//*[@class='card-body']//*[text()='Widgets']"),"Widgets");

    public MainPage() {
        super(new Container(By.className("home-banner"),"uniqueElementMainPage"),"MainPage");
    }

    public void openAlertFrameAndWindow(){
        ALERT_FRAME_WINDOW.click();
    }

    public void openElements(){
        ELEMENTS.click();
    }

    public void openWidgets(){
        WIDGETS.click();
    }
}
