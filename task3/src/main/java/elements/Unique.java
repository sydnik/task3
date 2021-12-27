package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.LoggerUtil;
import utils.WaitUtil;

public class Unique extends BaseElement{
    public Unique(By locator, String name) {
        super(locator, name);
    }
    public boolean exist(){
        WebElement element = WaitUtil.waitVisibility(findElement());
        if(element!=null) {
            return true;
        } else {
            LoggerUtil.error(name,"there is no element");
            throw new RuntimeException();
        }
    }
}
