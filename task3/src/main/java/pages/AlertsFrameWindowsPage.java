package pages;

import framework.elements.Label;
import org.openqa.selenium.By;
import framework.BaseForm;


public class AlertsFrameWindowsPage extends BaseForm {
    public AlertsFrameWindowsPage() {
        super(new Label(By.xpath("//div[@class='main-header'][text()='Alerts, Frame & Windows']"),"LabelAlerts, Frame & Windows"),
                "AlertsFrameWindowsPage");
    }
}
