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
//        Unique unique = new Unique(uniqueElement,"isPageOpened " + name);
//        boolean result =unique.exist();
        return true;
    }
    public boolean isPageClosed(){
//        Unique unique = new Unique(uniqueElement,"isPageOpened " + name);
//        boolean result =unique.isInVisibility();
        return true;
    }
}
