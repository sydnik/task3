package pagesAndForms.forms;

import elements.Frame;
import elements.Text;
import org.openqa.selenium.By;
import pagesAndForms.BasePage;

public class NestedFramesForm extends BasePage {
    private final By PARENT_FRAME = By.id("frame1");
    private final By TEXT_PARENT_FRAME = By.xpath("//body");
    private final By CHILD_FRAME = By.xpath("//iframe[contains(@srcdoc,'Child Iframe')]");
    private final By TEXT_CHILD_FRAME = By.xpath("//body");
    public NestedFramesForm() {
        super(By.xpath("//*[@class='main-header'][text()='Nested Frames']"), "NestedFramesForm");
    }
    public String getTextParentFrame(){
        Frame frameParent = new Frame(PARENT_FRAME,"parentFrame");
        Text text = new Text(TEXT_PARENT_FRAME,"textParentFrame");
        frameParent.switchFrame();
        String result = text.getText();
        frameParent.switchEarlyFrame();
        return result;
    }

    public String getTextChildFrame(){
        Frame frameParent = new Frame(PARENT_FRAME,"parentFrame");
        Frame frameChild = new Frame(CHILD_FRAME,"childFrame");
        frameParent.switchFrame();
        Text text = new Text(TEXT_CHILD_FRAME,"textChildFrame");
        frameChild.switchFrame();
        String result = text.getText();
        frameParent.switchEarlyFrame();
        return result;
    }

}
