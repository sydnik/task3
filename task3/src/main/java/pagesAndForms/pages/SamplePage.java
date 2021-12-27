package pagesAndForms.pages;

import elements.Label;
import org.openqa.selenium.By;
import pagesAndForms.BaseForm;

public class SamplePage extends BaseForm {
    private final By key = By.id("sampleHeading");
    public SamplePage() {
        super(By.id("sampleHeading"), "SamplePage");
    }
    public String getText(){
        return new Label(key,"textSamplePage").getText();
    }
}
