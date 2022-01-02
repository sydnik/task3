package elements;

import org.openqa.selenium.By;
import utils.LoggerUtil;
import utils.WaitUtil;

public class ProgressBar extends BaseElement {
    public ProgressBar(By uniqueElement, String name) {
        super(uniqueElement, name);
    }
    public boolean waitTextValue(String value,int timeOut){
        try {
            boolean result = WaitUtil.waitToBeText(findElement(),value,timeOut);
            LoggerUtil.info(name,"Waited the desired text");
            return result;
        }catch (Exception e){
            LoggerUtil.error(name,"Didn't wait desired text"+"\n"+e.getMessage());
            throw new RuntimeException();
        }

    }
}
