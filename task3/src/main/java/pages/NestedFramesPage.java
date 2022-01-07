package pages;

import framework.elements.Container;
import framework.elements.Label;
import org.openqa.selenium.By;
import framework.BaseForm;

public class NestedFramesPage extends BaseForm {
    private final By PARENT_FRAME = By.id("frame1");
    private final Label PARENT_FRAME_LABEL = new Label(By.xpath("//body"),"textParentFrame");
    private final By CHILD_FRAME = By.xpath("//iframe[contains(@srcdoc,'Child Iframe')]");
    private final Label CHILD_FRAME_LABEL = new Label(By.xpath("//body"),"textChildFrame");

    public NestedFramesPage() {
        super(new Container(By.id("framesWrapper"),"UniqueElement"), "NestedFramesPage");
    }

    public String getTextParentFrame(){
        saveKeyWindow();
        switchWindow(PARENT_FRAME);
        String result = PARENT_FRAME_LABEL.getText();
        switchSavedFrame();
        return result;
    }

    public String getTextChildFrame(){
        saveKeyWindow();
        switchWindow(PARENT_FRAME);
        switchWindow(CHILD_FRAME);
        String result = CHILD_FRAME_LABEL.getText();
        switchSavedFrame();
        return result;
    }
}
