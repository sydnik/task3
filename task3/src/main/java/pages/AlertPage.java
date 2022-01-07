package pages;

import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;
import framework.BaseForm;


public class AlertPage extends BaseForm {
    private final Button TO_SEE_ALERT_BUTTON = new Button(By.id("alertButton"),"alertButton");
    private final Button CONFIRM_BUTTON = new Button(By.id("confirmButton"),"confirmButton");
    private final Button PROMPT_BUTTON = new Button(By.id("promtButton"),"promptButton");
    private final Label CONFIRM_RESULT = new Label(By.id("confirmResult"),"confirmResult");
    private final Label PROMPT_RESULT = new Label(By.id("promptResult"),"promptResult");

    public AlertPage() {
        super(new Button(By.id("alertButton"),"wd"), "AlertPage");
    }

    public String getConfirmResult(){
        return CONFIRM_RESULT.getText();
    }

    public String getPromptResult(){
        return PROMPT_RESULT.getText();
    }

    public void clickAlert(){
        TO_SEE_ALERT_BUTTON.click();
    }

    public void clickConfirm(){
        CONFIRM_BUTTON.click();
    }

    public void clickPrompt(){
        PROMPT_BUTTON.click();

    }
}
