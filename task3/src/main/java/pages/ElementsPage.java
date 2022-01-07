package pages;

import framework.elements.Label;
import org.openqa.selenium.By;
import framework.BaseForm;

public class ElementsPage extends BaseForm {
    public ElementsPage() {
        super(new Label(By.xpath("//div[@class='main-header'][text()='Elements']"),"elementsLabel"), "elementsPage");
    }
}
