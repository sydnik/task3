package elements;

import org.openqa.selenium.By;
import utils.LoggerUtil;
import utils.WaitUtil;

public class Unique extends BaseElement{
    public Unique(By locator, String name) {
        super(locator, name);
    }
    public boolean exist(){
        try {
            WaitUtil.waitVisibility(findElement());
            return true;
        }catch (Exception e){
            LoggerUtil.error(name,"there is no element");
            throw new RuntimeException();
        }
    }
}
