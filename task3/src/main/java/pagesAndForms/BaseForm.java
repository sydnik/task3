package pagesAndForms;

import elements.Unique;
import org.openqa.selenium.By;

public abstract class BaseForm {
    private String name;
    private By uniqueElement;

    public BaseForm(By uniqueElement, String name) {
        this.uniqueElement = uniqueElement;
        this.name = name;
    }

    public boolean isPageOpened(){
            Unique unique = new Unique(uniqueElement,"isPageOpened " + name);
            boolean result =unique.exist();
            return result;
    }
    public boolean isPageClosed(){
        Unique unique = new Unique(uniqueElement,"isPageOpened " + name);
        boolean result =unique.isInVisibility();
        return result;
    }
}
