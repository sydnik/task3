package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import framework.utils.DriverUtil;
import framework.utils.LoggerUtil;
import framework.utils.WaitUtil;

public class Slider extends BaseElement{

    public Slider(By locator, String name) {
        super(locator, name);
    }

    public void setArrow(int pixels){
        Actions actions = new Actions(DriverUtil.getWebDriver());
        actions.moveToElement(findElement()).
                clickAndHold().
                moveByOffset(pixels-(getWidth()/2),0).
                release().build().perform();
        LoggerUtil.info(this.getClass(),name + "setArrow on "+ pixels);
    }

    public boolean waitAttributeValue(int value,String attribute){
        LoggerUtil.info(this.getClass(),name + " is waiting for the " + value +" in a certain "+attribute);
        return WaitUtil.waitToBeAttributeValue(findElement(),attribute, String.valueOf(value));
    }
}
