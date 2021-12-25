package pagesAndForms.pages;

import org.openqa.selenium.By;

public enum LeftPanelButtons {
    ELEMENTS(By.xpath("//*[@class='header-wrapper']//*[text()='Elements']"),"ElementsButton",null),
    LINKS(By.xpath("//*[@class='text'][text()='Links']"),"LinksButton",ELEMENTS);;


    private By locator;
    private String name;
    private LeftPanelButtons parent;

    LeftPanelButtons(By locator, String name, LeftPanelButtons parent) {
        this.locator = locator;
        this.name = name;
        this.parent = parent;
    }

    public By getLocator() {
        return locator;
    }

    public String getName() {
        return name;
    }

    public LeftPanelButtons getParent() {
        return parent;
    }
}
