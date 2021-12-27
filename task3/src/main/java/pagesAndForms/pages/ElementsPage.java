package pagesAndForms.pages;

import org.openqa.selenium.By;
import pagesAndForms.BaseForm;
import pagesAndForms.ClickLeftButtons;

public class ElementsPage extends BaseForm implements ClickLeftButtons {
    public ElementsPage() {
        super(By.xpath("//div[@class='main-header'][text()='Elements']"), "ElementsPage");
    }
}
