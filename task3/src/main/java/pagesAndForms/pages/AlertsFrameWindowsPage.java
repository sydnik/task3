package pagesAndForms.pages;

import elements.Button;
import org.openqa.selenium.By;
import pagesAndForms.BasePage;

public class AlertsFrameWindowsPage extends BasePage {
    private final By BUTTON_ALERT = By.xpath("//*[@class='text'][text()='Alerts']");

    public AlertsFrameWindowsPage() {
        super(By.xpath("//div[@class='main-header'][text()='Alerts, Frame & Windows']"), "AlertsFrameWindowsPage");
    }
    public void openAlert(){
        Button alert = new Button(BUTTON_ALERT,"ButtonAlert");
        alert.click();
    }
}
