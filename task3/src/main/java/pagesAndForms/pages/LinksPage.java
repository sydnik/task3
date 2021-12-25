package pagesAndForms.pages;

import elements.Link;
import org.openqa.selenium.By;
import pagesAndForms.BasePage;

public class LinksPage extends BasePage implements ClickLeftButtons{
    public LinksPage() {
        super(By.xpath("//div[@class='main-header'][text()='Links']"), "LinksPage");
    }
    public void openHomeNewTab(){
        Link link = new Link(By.xpath("//a[@id='simpleLink']"),"LinkHome");
        link.scrollToElement();
        link.click();
    }
}
