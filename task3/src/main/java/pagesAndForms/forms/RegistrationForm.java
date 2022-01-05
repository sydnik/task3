package pagesAndForms.forms;

import data.UserData;
import elements.Button;
import elements.TextField;
import org.openqa.selenium.By;
import pagesAndForms.BaseForm;

public class RegistrationForm extends BaseForm {
    private final TextField FIELD_FIRST_NAME = new TextField(By.id("firstName"),"FIELD_FIRST_NAME");
    private final TextField FIELD_LAST_NAME = new TextField(By.id("lastName"),"FIELD_LAST_NAME");
    private final TextField FIELD_EMAIL = new TextField(By.id("userEmail"),"FIELD_EMAIL");
    private final TextField FIELD_AGE = new TextField(By.id("age"),"FIELD_AGE");
    private final TextField FIELD_SALARY = new TextField(By.id("salary"),"FIELD_SALARY");
    private final TextField FIELD_DEPARTMENT = new TextField(By.id("department"),"FIELD_DEPARTMENT");
    private final Button BUTTON_SUBMIT = new Button(By.id("submit"),"ButtonSubmit");

    public RegistrationForm() {
        super(By.id("registration-form-modal"), "RegistrationForm");
    }

    public void sendDataUser(UserData user){
//        sendKeys(user.getFirstName(), FIELD_FIRST_NAME);
//        sendKeys(user.getLastName(), FIELD_LAST_NAME);
//        sendKeys(user.getEmail(), FIELD_EMAIL);
//        sendKeys(user.getAge(), FIELD_AGE);
//        sendKeys(user.getSalary(), FIELD_SALARY);
//        sendKeys(user.getDepartment(), FIELD_DEPARTMENT);
    }

    public void clickSubmit(){
//        Button button = new Button(BUTTON_SUBMIT,"ButtonSubmit");
//        button.click();
    }

    private void sendKeys(String value, By textFieldLocator){
        TextField textField = new TextField(textFieldLocator, value);
        textField.sendKeys(value);
    }
}
