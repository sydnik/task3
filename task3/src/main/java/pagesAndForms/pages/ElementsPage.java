package pagesAndForms.pages;

import org.openqa.selenium.By;
import pagesAndForms.BasePage;
import pagesAndForms.ClickLeftButtons;

public class ElementsPage extends BasePage implements ClickLeftButtons {
    public ElementsPage() {
        super(By.xpath("//div[@class='main-header'][text()='Elements']"), "ElementsPage");
    }
}
