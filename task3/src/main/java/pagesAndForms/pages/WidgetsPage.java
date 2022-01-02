package pagesAndForms.pages;

import org.openqa.selenium.By;
import pagesAndForms.BaseForm;
import pagesAndForms.ClickLeftButtons;

public class WidgetsPage extends BaseForm implements ClickLeftButtons {
    public WidgetsPage() {
        super(By.xpath("//*[@class='main-header'][text()='Widgets']"), "WidgetsPage");
    }
}