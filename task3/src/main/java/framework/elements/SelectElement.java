package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import framework.utils.LoggerUtil;

public class SelectElement extends BaseElement{
    public SelectElement(By locator, String name) {
        super(locator, name);
    }
    public void selectValue(String value){
        try {
            new Select(findElement()).selectByValue(value);
            LoggerUtil.info(this.getClass(),name + " selected : "+ value);
        } catch (Exception e){
            LoggerUtil.error(this.getClass(),name + "Didn't select : "+ value + "\n" + e.getMessage());
            throw e;
        }

    }
}
