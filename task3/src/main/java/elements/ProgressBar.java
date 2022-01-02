package elements;

import org.openqa.selenium.By;
import utils.WaitUtil;

public class ProgressBar extends BaseElement {
    public ProgressBar(By uniqueElement, String name) {
        super(uniqueElement, name);
    }
    public boolean waitTextValue(String value,int timeOut){
        return WaitUtil.waitToBeText(findElement(),value,timeOut);
    }
}
