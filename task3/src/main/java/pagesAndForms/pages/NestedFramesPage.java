package pagesAndForms.pages;

import elements.Frame;
import elements.Text;
import org.openqa.selenium.By;
import pagesAndForms.BasePage;

public class NestedFramesPage extends BasePage {
    private final By PARENT_FRAME = By.id("frame1");
    private final By TEXT_PARENT_FRAME = By.xpath("//body");
    private final By CHILD_FRAME = By.xpath("//iframe[contains(@srcdoc,'Child Iframe')]");
    private final By TEXT_CHILD_FRAME = By.xpath("//body");
    private Frame frameParent;
    private Frame frameChild;

    public NestedFramesPage() {
        super(By.xpath("//*[@class='main-header'][text()='Nested Frames']"), "NestedFramesPage");
    }
    public String getTextParentFrame(){
        switchParentWindow();
        Text text = new Text(TEXT_PARENT_FRAME,"textParentFrame");
        String result = text.getText();
        switchEarlyWindow(frameParent);
        return result;
    }

    public String getTextChildFrame(){
        switchParentWindow();
        switchChildWindow();
        Text text = new Text(TEXT_CHILD_FRAME,"textChildFrame");
        String result = text.getText();
        switchEarlyWindow(frameParent);
        return result;
    }
    private void switchParentWindow(){
        frameParent = new Frame(PARENT_FRAME,"parentFrame");
        frameParent.switchFrame();
    }
    private void switchChildWindow(){
        frameChild = new Frame(CHILD_FRAME,"childFrame");
        frameChild.switchFrame();
    }
    private void switchEarlyWindow(Frame frame){
        frame.switchEarlyFrame();
    }

}
