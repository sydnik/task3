package pagesAndForms.pages;

import elements.Button;
import elements.ProgressBar;
import org.openqa.selenium.By;
import pagesAndForms.BaseForm;


public class ProgressBarPage extends BaseForm {
    private final By START_AND_STOP_BUTTON = By.id("startStopButton");
    private final By PROGRESS_BAR = By.id("progressBar");

    public ProgressBarPage() {
        super(By.id("progressBar"), "ProgressBar");
    }

    public void clickStart(){
        Button button = new Button(START_AND_STOP_BUTTON,"startStopButton");
        button.click();
    }

    public void clickStopOnValue(int value){
        Button button = new Button(START_AND_STOP_BUTTON,"startStopButton");
        ProgressBar progressBar = new ProgressBar(PROGRESS_BAR,"progressBar");
        progressBar.waitTextValue(value+"%",1);
        button.click();
    }
    //не знаю какой правильно) Выше ищет конкретное значение, ниже код ищет с погрешность
    public void clickStopOnValueWithAnError(int value,int errorRate){
        Button button = new Button(START_AND_STOP_BUTTON,"startStopButton");
        ProgressBar progressBar = new ProgressBar(PROGRESS_BAR,"progressBar");
        String[] values = new String[errorRate*2+1];
        for (int i = -errorRate; i <=errorRate ; i++) {
            values[i+errorRate]= (value-i)+"%";
        }
        progressBar.waitTextValues(values,1);
        button.click();
    }

    public int getValue(){
        ProgressBar progressBar = new ProgressBar(PROGRESS_BAR,"progressBar");
        return Integer.parseInt(progressBar.getText().replace("%",""));
    }
}
