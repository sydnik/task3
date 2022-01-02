package pagesAndForms.pages;

import elements.Button;
import elements.Label;
import org.openqa.selenium.By;
import pagesAndForms.BaseForm;


public class AlertPage extends BaseForm {
    private final By BUTTON_TO_SEE_ALERT = By.id("alertButton");
    private final By BUTTON_CONFIRM = By.id("confirmButton");
    private final By BUTTON_PROMPT = By.id("promtButton");
    private final By CONFIRM_RESULT = By.id("confirmResult");
    private final By PROMPT_RESULT = By.id("promptResult");

    public AlertPage() {
        super(By.id("alertButton"), "AlertPage");
    }

    public String getConfirmResult(){
        Label label = new Label(CONFIRM_RESULT,"confirmResult");
        return label.getText();
    }
    public String getPromptResult(){
        Label label = new Label(PROMPT_RESULT,"promptResult");
        return label.getText();
    }
    public void clickAlert(){
        Button button = new Button(BUTTON_TO_SEE_ALERT,"alertButton");
        button.click();
    }
    public void clickConfirm(){
        Button button = new Button(BUTTON_CONFIRM,"confirmButton");
        button.click();
    }
    public void clickPrompt(){
        Button button = new Button(BUTTON_PROMPT,"promtButton");
        button.click();

    }
}
