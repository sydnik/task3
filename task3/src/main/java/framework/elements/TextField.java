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
            LoggerUtil.info(name,"send text: "+s);
        }catch (Exception e){
            LoggerUtil.error(name,"Didn't sendKeys" +"\n" + e.getMessage());
            throw new RuntimeException();
        }

    }
}
