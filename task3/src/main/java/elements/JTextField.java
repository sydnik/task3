package elements;

import org.openqa.selenium.By;
import utils.LoggerUtil;

public class JTextField extends BaseElement{
    public JTextField(By locator, String name) {
        super(locator, name);
    }
    public void sendKeys(String s){
        try {
            findElement().sendKeys(s);
        }catch (Exception e){
            LoggerUtil.error(name,"Didn't sendKeys" +e.getMessage());
            throw new RuntimeException();
        }

    }
}
