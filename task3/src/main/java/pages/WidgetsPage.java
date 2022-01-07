package pages;

import framework.elements.Label;
import org.openqa.selenium.By;
import framework.BaseForm;
import pagesAndForms.ClickLeftButtons;

public class WidgetsPage extends BaseForm implements ClickLeftButtons {
    public WidgetsPage() {
        super(new Label(By.xpath("//*[@class='main-header'][text()='Widgets']"),"WidgetsLabel"), "WidgetsPage");
    }
}