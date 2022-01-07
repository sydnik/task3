package framework.elements;

import org.openqa.selenium.By;
import framework.utils.LoggerUtil;
import framework.utils.WaitUtil;

public class ProgressBar extends BaseElement {
    public ProgressBar(By uniqueElement, String name) {
        super(uniqueElement, name);
    }

    public boolean waitTextValue(String value,int timeOut){
        try {
            boolean result = WaitUtil.waitToBeText(findElement(),value,timeOut);
            LoggerUtil.info(this.getClass(),name + " Waited the desired text");
            return result;
        }catch (Exception e){
            LoggerUtil.error(this.getClass(),name +" didn't wait desired text"+"\n"+e.getMessage());
            throw new RuntimeException();
        }
    }
    public boolean waitTextValues(String[] values,int timeOut){
        try {
            boolean result = WaitUtil.waitToBeTextValues(findElement(),values,timeOut);
            LoggerUtil.info(this.getClass(),name + " waited the desired text");
            return result;
        }catch (Exception e){
            LoggerUtil.error(this.getClass(),name + "didn't wait desired text"+"\n"+e.getMessage());
            throw new RuntimeException();
        }
    }
}
