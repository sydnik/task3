package pagesAndForms.forms;

import elements.Button;
import elements.JTextField;
import org.openqa.selenium.By;
import pagesAndForms.BasePage;

public class RegistrationForm extends BasePage {
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

    public void sendFirstName(String firstName){
        JTextField jTextField = new JTextField(FILED_FIRST_NAME, "textFieldFirstName");
        jTextField.sendKeys(firstName);
    }
    public void sendLastName(String lastName){
        JTextField jTextField = new JTextField(FILED_LAST_NAME, "textFieldLastName");
        jTextField.sendKeys(lastName);
    }
    public void sendEmail(String email){
        JTextField jTextField = new JTextField(FILED_EMAIL, "textFieldEmail");
        jTextField.sendKeys(email);
    }
    public void sendAge(String age){
        JTextField jTextField = new JTextField(FILED_AGE, "textFieldAge");
        jTextField.sendKeys(age);
    }
    public void sendSalary(String salary){
        JTextField jTextField = new JTextField(FILED_SALARY, "textFieldSalary");
        jTextField.sendKeys(salary);
    }
    public void sendDepartment(String department){
        JTextField jTextField = new JTextField(FILED_DEPARTMENT, "textFieldDepartment");
        jTextField.sendKeys(department);
    }
    public void clickSubmit(){
        Button button = new Button(BUTTON_SUBMIT,"ButtonSubmit");
        button.click();
    }
}
