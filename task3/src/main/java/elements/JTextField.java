package elements;

import org.openqa.selenium.By;

public class JTextField extends BaseElement{
    public JTextField(By locator, String name) {
        super(locator, name);
    }
    public void sendKeys(String s){
        findElement().sendKeys(s);
    }
}
