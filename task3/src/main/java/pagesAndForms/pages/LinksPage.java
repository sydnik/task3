package pagesAndForms.pages;

import elements.Link;
import org.openqa.selenium.By;
import pagesAndForms.BaseForm;
import pagesAndForms.ClickLeftButtons;

public class LinksPage extends BaseForm implements ClickLeftButtons {
    private final By LINK_HOME = By.id("simpleLink");

    public LinksPage() {
        super(By.id("simpleLink"), "LinksPage");
    }

    public void openHomeNewTab(){
        Link link = new Link(LINK_HOME,"LinkHome");
        link.click();
    }
}
