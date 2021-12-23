package pagesAndForms.forms;

import elements.Button;
import elements.Text;
import org.openqa.selenium.By;
import pagesAndForms.BasePage;


public class AlertForm extends BasePage {
    private final By BUTTON_TO_SEE_ALERT = By.id("alertButton");
    private final By BUTTON_CONFIRM = By.id("confirmButton");
    private final By BUTTON_PROMPT = By.id("promtButton");
    private final By CONFIRM_RESULT = By.id("confirmResult");
    private final By PROMPT_RESULT = By.id("promptResult");

    public AlertForm() {
        super(By.xpath("//*[@class='main-header'][text()='Alerts']"), "AlertForm");
    }

    public String getConfirmResult(){
        Text text = new Text(CONFIRM_RESULT,"confirmResult");
        return text.getText();
    }
    public String getPromptResult(){
        Text text = new Text(PROMPT_RESULT,"promptResult");
        return text.getText();
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
