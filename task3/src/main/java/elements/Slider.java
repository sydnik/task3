package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utils.DriverUtil;
import utils.LoggerUtil;
import utils.WaitUtil;

public class Slider extends BaseElement{

    public Slider(By locator, String name) {
        super(locator, name);
    }

    public void setArrow(int pixels){
        Actions actions = new Actions(DriverUtil.getWebDriver());
        actions.moveToElement(findElement()).
                clickAndHold().
                moveByOffset(pixels-(getWidth()/2),0).release().build().perform();
        LoggerUtil.info(name,"setArrow on value ");
    }

    public boolean waitAttributeValue(int value,String attribute){
        return WaitUtil.waitToBeAttributeValue(findElement(),attribute, String.valueOf(value));
    }
}
