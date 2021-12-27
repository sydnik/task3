package elements;

import org.openqa.selenium.By;
import utils.DriverUtil;


public class Frame extends BaseElement{
    private String savedFrame;
    public Frame(By locator, String name) {
        super(locator, name);
    }
    public void switchFrame(){
        savedFrame = DriverUtil.getCurrentWindow();
        DriverUtil.switchToFrame(findElement());
    }
    public void switchEarlyFrame(){
        DriverUtil.switchToFrame(savedFrame);
    }

}
