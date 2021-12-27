package pagesAndForms.pages;

import elements.Label;
import org.openqa.selenium.By;
import pagesAndForms.BaseForm;
import utils.DriverUtil;

public class NestedFramesPage extends BaseForm {
    private final By PARENT_FRAME = By.id("frame1");
    private final By TEXT_PARENT_FRAME = By.xpath("//body");
    private final By CHILD_FRAME = By.xpath("//iframe[contains(@srcdoc,'Child Iframe')]");
    private final By TEXT_CHILD_FRAME = By.xpath("//body");
    private String savedFrame;

    public NestedFramesPage() {
        super(By.xpath("//*[@class='main-header'][text()='Nested Frames']"), "NestedFramesPage");
    }
    public String getTextParentFrame(){
        switchParentWindow();
        Label label = new Label(TEXT_PARENT_FRAME,"textParentFrame");
        String result = label.getText();
        switchEarlyWindow();
        return result;
    }

    public String getTextChildFrame(){
        switchParentWindow();
        switchChildWindow();
        Label label = new Label(TEXT_CHILD_FRAME,"textChildFrame");
        String result = label.getText();
        switchEarlyWindow();
        return result;
    }
    private void switchParentWindow(){
        savedFrame = DriverUtil.getCurrentWindow();
        DriverUtil.switchToFrame(PARENT_FRAME);
    }
    private void switchChildWindow(){
        DriverUtil.switchToFrame(CHILD_FRAME);
    }
    private void switchEarlyWindow(){
        DriverUtil.switchToFrame(savedFrame);
    }

}
