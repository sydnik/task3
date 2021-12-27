package pagesAndForms.pages;

import org.openqa.selenium.By;
import pagesAndForms.BasePage;
import pagesAndForms.ClickLeftButtons;

public class AlertsFrameWindowsPage extends BasePage implements ClickLeftButtons {
    public AlertsFrameWindowsPage() {
        super(By.xpath("//div[@class='main-header'][text()='Alerts, Frame & Windows']"), "AlertsFrameWindowsPage");
    }
}
