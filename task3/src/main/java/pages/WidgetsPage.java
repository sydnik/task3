package pages;

import framework.elements.Label;
import org.openqa.selenium.By;
import framework.BaseForm;


public class WidgetsPage extends BaseForm {
    public WidgetsPage() {
        super(new Label(By.xpath("//*[@class='main-header'][text()='Widgets']"),"WidgetsLabel"), "WidgetsPage");
    }
}