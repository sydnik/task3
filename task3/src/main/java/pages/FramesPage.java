package pages;

import framework.elements.Container;
import framework.elements.Label;
import org.openqa.selenium.By;
import framework.BaseForm;

public class FramesPage extends BaseForm {
    private final By TOP_FRAME = By.id("frame1");
    private final Label TEXT_TOP_FRAME = new Label(By.id("sampleHeading"),"textTopFrame");
    private final By BOTTOM_FRAME = By.id("frame2");
    private final Label TEXT_BOTTOM_FRAME = new Label(By.id("sampleHeading"),"textBottomFrame");


    public FramesPage() {
        super(new Container(By.id("framesWrapper"),"UniqueElementFramesPage"), "FramesPage");
    }

    public String getTextTopWindow(){
        saveWindowKey();
        switchWindow(TOP_FRAME);
        String result = TEXT_TOP_FRAME.getText();
        saveCurrentWindow();
        return result;
    }

    public String getTextBottomWindow(){
        saveWindowKey();
        switchWindow(BOTTOM_FRAME);
        String result = TEXT_BOTTOM_FRAME.getText();
        saveCurrentWindow();
        return result;
    }
}
