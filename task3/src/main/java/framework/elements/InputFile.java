package framework.elements;

import org.openqa.selenium.By;

public class InputFile extends BaseElement{
    public InputFile(By locator, String name) {
        super(locator, name);
    }
    public void uploadFile(String path){
        findElement().sendKeys(path);
    }
}
