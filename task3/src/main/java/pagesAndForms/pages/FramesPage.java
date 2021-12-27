package pagesAndForms.pages;

import elements.Label;
import org.openqa.selenium.By;
import pagesAndForms.BaseForm;
import utils.DriverUtil;

public class FramesPage extends BaseForm {
    private final By TOP_FRAME = By.id("frame1");
    private final By TEXT_TOP_FRAME = By.id("sampleHeading");
    private final By BOTTOM_FRAME = By.id("frame2");
    private final By TEXT_BOTTOM_FRAME = By.id("sampleHeading");
    private String savedFrame;


    public FramesPage() {
        super(By.xpath("//*[@class='main-header'][text()='Frames']"), "FramesPage");
    }

    public String getTextTopWindow(){
        switchParentWindow(TOP_FRAME);
        Label label = new Label(TEXT_TOP_FRAME,"textTopFrame");
        String result = label.getText();
        switchEarlyWindow();
        return result;
    }
    public String getTextBottomWindow(){
        switchParentWindow(BOTTOM_FRAME);
        Label label = new Label(TEXT_BOTTOM_FRAME,"textBottomFrame");
        String result = label.getText();
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
