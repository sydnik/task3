package framework.elements;

import framework.utils.LoggerUtil;
import org.openqa.selenium.By;

public class InputFile extends BaseElement{
    public InputFile(By locator, String name) {
        super(locator, name);
    }
    public void uploadFile(String path){
        try {
            findElement().sendKeys(path);
            LoggerUtil.info(this.getClass(),name + " downloaded file: "+path);
        }catch (Exception e){
            LoggerUtil.error(this.getClass(),name + " didn't download" + "\n" + e.getMessage());
            throw e;
        }

    }
}
