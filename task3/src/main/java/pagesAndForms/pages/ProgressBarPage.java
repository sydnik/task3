package pagesAndForms.pages;

import elements.Button;
import elements.ProgressBar;
import org.openqa.selenium.By;
import pagesAndForms.BaseForm;


public class ProgressBarPage extends BaseForm {
    private final By START_AND_STOP = By.id("startStopButton");
    private final By PROGRESS_BAR = By.id("progressBar");
    public ProgressBarPage() {
        super(By.id("progressBar"), "ProgressBar");
    }
    public void clickStart(){
        Button button = new Button(START_AND_STOP,"startStopButton");
        button.click();
    }
    public void clickStopOnValue(int value){
        Button button = new Button(START_AND_STOP,"startStopButton");
        ProgressBar progressBar = new ProgressBar(PROGRESS_BAR,"progressBar");
        progressBar.waitTextValue(value+"%",1);
        button.click();
    }
    public int getValue(){
        ProgressBar progressBar = new ProgressBar(PROGRESS_BAR,"progressBar");
        return Integer.parseInt(progressBar.getText().replace("%",""));
    }
}
