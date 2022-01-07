package pages;

import framework.elements.Container;
import framework.elements.Label;
import org.openqa.selenium.By;
import framework.BaseForm;
import framework.utils.DriverUtil;

public class FramesPage extends BaseForm {
    private final By TOP_FRAME = By.id("frame1");
    private final Label TEXT_TOP_FRAME = new Label(By.id("sampleHeading"),"textTopFrame");
    private final By BOTTOM_FRAME = By.id("frame2");
    private final Label TEXT_BOTTOM_FRAME = new Label(By.id("sampleHeading"),"textBottomFrame");
    private String savedFrame;

    public FramesPage() {
        super(new Container(By.id("framesWrapper"),"UniqueElementFramesPage"), "FramesPage");
    }

    public String getTextTopWindow(){
        switchParentWindow(TOP_FRAME);
        String result = TEXT_TOP_FRAME.getText();
        switchEarlyWindow();
        return result;
    }

    public String getTextBottomWindow(){
        switchParentWindow(BOTTOM_FRAME);
        String result = TEXT_BOTTOM_FRAME.getText();
        switchEarlyWindow();
        return result;
    }

    private void switchEarlyWindow(){
        DriverUtil.switchToFrame(savedFrame);
    }

    private void switchParentWindow(By locator){
        savedFrame = DriverUtil.getCurrentWindow();
        DriverUtil.switchToFrame(locator);
    }
}