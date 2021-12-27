package pagesAndForms.forms;

import data.UserData;
import elements.Button;
import elements.JTextField;
import org.openqa.selenium.By;
import pagesAndForms.BaseForm;

public class RegistrationForm extends BaseForm {
    private final By FILED_FIRST_NAME = By.id("firstName");
    private final By FILED_LAST_NAME = By.id("lastName");
    private final By FILED_EMAIL = By.id("userEmail");
    private final By FILED_AGE = By.id("age");
    private final By FILED_SALARY= By.id("salary");
    private final By FILED_DEPARTMENT = By.id("department");
    private final By BUTTON_SUBMIT = By.id("submit");

    public RegistrationForm() {
        super(By.id("registration-form-modal"), "RegistrationForm");
    }

    public void sendDataUser(UserData user){
        sendKeys(user.getFirstName(),FILED_FIRST_NAME);
        sendKeys(user.getLastName(),FILED_LAST_NAME);
        sendKeys(user.getEmail(),FILED_EMAIL);
        sendKeys(user.getAge(),FILED_AGE);
        sendKeys(user.getSalary(),FILED_SALARY);
        sendKeys(user.getDepartment(),FILED_DEPARTMENT);
    }

    public void clickSubmit(){
        Button button = new Button(BUTTON_SUBMIT,"ButtonSubmit");
        button.click();
    }

    private void sendKeys(String value, By textFieldLocator){
        JTextField jTextField = new JTextField(textFieldLocator, value);
        jTextField.sendKeys(value);
    }
}
