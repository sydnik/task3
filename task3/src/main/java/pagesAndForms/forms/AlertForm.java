package pagesAndForms.forms;

import elements.Button;
import org.openqa.selenium.By;
import pagesAndForms.BasePage;
import utils.DriverUtil;


public class AlertForm extends BasePage {
    private final By BUTTON_TO_SEE_ALERT = By.id("alertButton");
    private final By BUTTON_CONFIRM = By.id("confirmButton");
    private final By BUTTON_PROMPT = By.id("promtButton");
    public AlertForm() {
        super(By.xpath("//*[@class='main-header'][text()='Alerts']"), "AlertForm");
    }

    public String getConfirmResult(){
        return DriverUtil.getInstance().getWebDriver().findElement(By.id("confirmResult")).getText();
    }
    public String getPromptBoxWillAppear(){
       return DriverUtil.getInstance().getWebDriver().findElement(By.id("promptResult")).getText();
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
    public void click(){

    }

}
