package pages;

import framework.elements.Button;
import framework.elements.ProgressBar;
import org.openqa.selenium.By;
import framework.BaseForm;


public class ProgressBarPage extends BaseForm {
    private final Button START_AND_STOP_BUTTON = new Button(By.id("startStopButton"),"startStopButton");
    private final ProgressBar PROGRESS_BAR = new ProgressBar(By.id("progressBar"),"progressBar");

    public ProgressBarPage() {
        super(new ProgressBar(By.id("progressBar"),"progressBar"), "ProgressBarPage");
    }

    public void clickStart(){
        START_AND_STOP_BUTTON.click();
    }

    public void clickStopOnValue(int value){
        PROGRESS_BAR.waitTextValue(value+"%",1);
        START_AND_STOP_BUTTON.click();
    }
    //не знаю какой правильно) Выше ищет конкретное значение, ниже код ищет с погрешность
    public void clickStopOnValueWithAnError(int value,int errorRate){
        String[] values = new String[errorRate*2+1];
        for (int i = -errorRate; i <=errorRate ; i++) {
            values[i+errorRate]= (value-i)+"%";
        }
        PROGRESS_BAR.waitTextValues(values,1);
        START_AND_STOP_BUTTON.click();
    }

    public int getValue(){
        return Integer.parseInt(PROGRESS_BAR.getText().replace("%",""));
    }
}
