package pagesAndForms.pages;

import elements.Button;
import org.openqa.selenium.By;
import pagesAndForms.BasePage;

public class AlertsFrameWindowsPage extends BasePage {
    public AlertsFrameWindowsPage() {
        super(By.xpath("//div[@class='main-header'][text()='Alerts, Frame & Windows']"), "AlertsFrameWindowsPage");
    }
    public void openAlert(){
        Button alert = new Button(By.xpath("//*[@class='text'][text()='Alerts']"),"ButtonAlert");
        alert.click();
    }
}
