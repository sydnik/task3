package pagesAndForms;

import org.openqa.selenium.By;

public abstract class BasePage {
    private String name;
    private By uniqueElement;

    public BasePage(By uniqueElement,String name) {
        this.uniqueElement = uniqueElement;
        this.name = name;
    }

    public boolean isPageOpened(){
        return true;
    }
}
