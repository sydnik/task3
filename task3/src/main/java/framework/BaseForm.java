package framework;

import framework.elements.BaseElement;
import framework.elements.Unique;

public abstract class BaseForm {
    private String name;
    private BaseElement uniqueElement;

    public BaseForm(BaseElement uniqueElement, String name) {
        this.uniqueElement = uniqueElement;
        this.name = name;
    }

    public boolean isPageOpened(){
        return uniqueElement.exist();
    }
    public boolean isPageClosed(){
        return uniqueElement.unExist();
    }
}
