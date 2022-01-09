package forms;

import data.UserData;
import framework.elements.Button;
import framework.elements.Label;
import framework.elements.TextField;
import org.openqa.selenium.By;
import framework.BaseForm;

public class RegistrationForm extends BaseForm {
    private final TextField FIRST_NAME_FIELD = new TextField(By.id("firstName"),"FIELD_FIRST_NAME");
    private final TextField LAST_NAME_FIELD = new TextField(By.id("lastName"),"FIELD_LAST_NAME");
    private final TextField EMAIL_FIELD = new TextField(By.id("userEmail"),"FIELD_EMAIL");
    private final TextField AGE_FIELD = new TextField(By.id("age"),"FIELD_AGE");
    private final TextField SALARY_FIELD = new TextField(By.id("salary"),"FIELD_SALARY");
    private final TextField DEPARTMENT_FIELD = new TextField(By.id("department"),"FIELD_DEPARTMENT");
    private final Button SUBMIT_BUTTON = new Button(By.id("submit"),"ButtonSubmit");

    public RegistrationForm() {
        super(new Label(By.id("registration-form-modal"),"registration-form-modal"), "RegistrationForm");
    }

    public void sendDataUser(UserData user){
        FIRST_NAME_FIELD.sendKeys(user.getFirstName());
        LAST_NAME_FIELD.sendKeys(user.getLastName());
        EMAIL_FIELD.sendKeys(user.getEmail());
        AGE_FIELD.sendKeys(user.getAge());
        SALARY_FIELD.sendKeys(user.getSalary());
        DEPARTMENT_FIELD.sendKeys(user.getDepartment());
    }

    public void clickSubmit(){
        SUBMIT_BUTTON.click();
    }
}
