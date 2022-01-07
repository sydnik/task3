package pages;

import framework.elements.Link;
import org.openqa.selenium.By;
import framework.BaseForm;

public class LinksPage extends BaseForm {
    private final Link HOME_LINK = new Link(By.id("simpleLink"),"homeLink");

    public LinksPage() {
        super(new Link(By.id("simpleLink"),"homeLink"), "LinksPage");
    }

    public void openHomeNewTab(){
        HOME_LINK.click();
    }
}
