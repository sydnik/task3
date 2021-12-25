package pagesAndForms.forms;

import elements.Frame;
import elements.Text;
import org.openqa.selenium.By;
import pagesAndForms.BasePage;

public class FramesForm extends BasePage {
    private final By TOP_FRAME = By.id("frame1");
    private final By TEXT_TOP_FRAME = By.id("sampleHeading");
    private final By BOTTOM_FRAME = By.id("frame2");
    private final By TEXT_BOTTOM_FRAME = By.id("sampleHeading");
    private Frame frame;

    public FramesForm() {
        super(By.xpath("//*[@class='main-header'][text()='Frames']"), "FramesForm");
    }
    //Как мне кажется нужно разделить на методфы включить окно и получить текст. Возможно вклчить окно стоит спрятать в приват.
    //Плюс пока не понимаю как сделать сохранение главное страницы
    public String getTextTopFrame(){
        Text text = new Text(TEXT_TOP_FRAME,"textTopFrame");
        openFrame(TOP_FRAME,"topFrame");
        String result = text.getText();
        openEarlyFrame();
        return result;
    }
    public String getTextBottomFrame(){
        Text text = new Text(TEXT_BOTTOM_FRAME,"textBottomFrame");
        openFrame(BOTTOM_FRAME,"bottomFrame");
        String result = text.getText();
        openEarlyFrame();
        return result;
    }

    private void openFrame(By locator, String name){
        frame = new Frame(locator,name);
        frame.switchFrame();
    }
    private void openEarlyFrame(){
        frame.switchEarlyFrame();
    }
}
