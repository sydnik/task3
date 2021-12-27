package pagesAndForms.pages;

import elements.Text;
import org.openqa.selenium.By;
import pagesAndForms.BasePage;

public class SamplePage extends BasePage {
    private final By key = By.id("sampleHeading");
    public SamplePage() {
        super(By.id("sampleHeading"), "SamplePage");
    }
    public String getText(){
        return new Text(key,"textSamplePage").getText();
    }
}
