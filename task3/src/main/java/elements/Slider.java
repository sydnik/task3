package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utils.DriverUtil;
import utils.WaitUtil;

public class Slider extends BaseElement{

    public Slider(By locator, String name) {
        super(locator, name);
    }

    public void setArrow(int pixels){
        Actions actions = new Actions(DriverUtil.getWebDriver());
        actions.moveToElement(findElement()).
                clickAndHold().
                moveByOffset(-(getWidth()/2),0).
                moveByOffset(pixels,0).release().build().perform();
    }
    public int getMaxValue(){
        return Integer.parseInt(getAttribute("max"));
    }
    public int getMinValue(){
        return Integer.parseInt(getAttribute("min"));
    }
    public int getValue(){
        return Integer.parseInt(findElement().getAttribute("value"));
    }
    public boolean waitValue(int value){
        return WaitUtil.waitToBeAttributeValue(findElement(),"value", String.valueOf(value));
    }
}
