package pages;

import framework.elements.Label;
import org.openqa.selenium.By;
import framework.BaseForm;

public class SamplePage extends BaseForm {
    private final Label KEY = new Label(By.id("sampleHeading"),"textSamplePage");

    public SamplePage() {
        super(new Label(By.id("sampleHeading"),"textSamplePage"), "SamplePage");
    }

    public String getText(){
        return KEY.getText();
    }
}
