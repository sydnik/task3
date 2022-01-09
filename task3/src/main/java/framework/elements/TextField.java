package framework.elements;

import org.openqa.selenium.By;
import framework.utils.LoggerUtil;

public class TextField extends BaseElement{
    public TextField(By locator, String name) {
        super(locator, name);
    }

    public void sendKeys(String s){
        try {
            findElement().sendKeys(s);
            LoggerUtil.info(this.getClass(),name + " write text: "+s);
        }catch (Exception e){
            LoggerUtil.error(this.getClass(),name + " Didn't sendKeys" + "\n" + e.getMessage());
            throw e;
        }

    }
}
