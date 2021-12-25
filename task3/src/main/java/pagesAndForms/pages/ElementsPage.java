package pagesAndForms.pages;

import elements.Button;
import org.openqa.selenium.By;
import pagesAndForms.BasePage;

public class ElementsPage extends BasePage {
    private final By BUTTON_WEB_TABLES = By.xpath("//*[@class='text'][text()='Web Tables']");
    public ElementsPage() {
        super(By.xpath("//div[@class='main-header'][text()='Elements']"), "ElementsPage");
    }
    public void openWebTables(){
        Button alert = new Button(BUTTON_WEB_TABLES,"ButtonAlert");
        alert.click();
    }

}
