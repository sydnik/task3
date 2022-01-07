package forms;

import data.UserData;
import framework.elements.Button;
import framework.elements.Label;
import framework.elements.TextField;
import org.openqa.selenium.By;
import framework.BaseForm;

public class RegistrationForm extends BaseForm {
    private final TextField FIELD_FIRST_NAME = new TextField(By.id("firstName"),"FIELD_FIRST_NAME");
    private final TextField FIELD_LAST_NAME = new TextField(By.id("lastName"),"FIELD_LAST_NAME");
    private final TextField FIELD_EMAIL = new TextField(By.id("userEmail"),"FIELD_EMAIL");
    private final TextField FIELD_AGE = new TextField(By.id("age"),"FIELD_AGE");
    private final TextField FIELD_SALARY = new TextField(By.id("salary"),"FIELD_SALARY");
    private final TextField FIELD_DEPARTMENT = new TextField(By.id("department"),"FIELD_DEPARTMENT");
    private final Button BUTTON_SUBMIT = new Button(By.id("submit"),"ButtonSubmit");

    public RegistrationForm() {
        super(new Label(By.id("registration-form-modal"),"registration-form-modal"), "RegistrationForm");
    }

    public void sendDataUser(UserData user){
        FIELD_FIRST_NAME.sendKeys(user.getFirstName());
        FIELD_LAST_NAME.sendKeys(user.getLastName());
        FIELD_EMAIL.sendKeys(user.getEmail());
        FIELD_AGE.sendKeys(user.getAge());
        FIELD_SALARY.sendKeys(user.getSalary());
        FIELD_DEPARTMENT.sendKeys(user.getDepartment());
    }

    public void clickSubmit(){
        BUTTON_SUBMIT.click();
    }
}
