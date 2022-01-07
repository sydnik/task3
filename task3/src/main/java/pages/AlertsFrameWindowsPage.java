package pages;

import framework.elements.Label;
import org.openqa.selenium.By;
import framework.BaseForm;
import pagesAndForms.ClickLeftButtons;

public class AlertsFrameWindowsPage extends BaseForm implements ClickLeftButtons {
    public AlertsFrameWindowsPage() {
        super(new Label(By.xpath("//div[@class='main-header'][text()='Alerts, Frame & Windows']"),"LabelAlerts, Frame & Windows"),
                "AlertsFrameWindowsPage");
    }
}
