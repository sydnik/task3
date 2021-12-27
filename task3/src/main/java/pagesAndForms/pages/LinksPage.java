package pagesAndForms.pages;

import elements.Link;
import org.openqa.selenium.By;
import pagesAndForms.BaseForm;
import pagesAndForms.ClickLeftButtons;

public class LinksPage extends BaseForm implements ClickLeftButtons {
    private final By LINK_HOME = By.xpath("//a[@id='simpleLink']");
    public LinksPage() {
        super(By.xpath("//div[@class='main-header'][text()='Links']"), "LinksPage");
    }
    public void openHomeNewTab(){
        Link link = new Link(LINK_HOME,"LinkHome");
        link.click();
    }
}
