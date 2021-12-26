package pagesAndForms.forms;

import data.UserData;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pagesAndForms.BasePage;
import utils.WaitUtil;

import java.util.*;

public class WebTablesForm extends BasePage {
    private final By BUTTON_ADD = By.id("addNewRecordButton");
    public WebTablesForm() {
        super(By.xpath("//*[@class='main-header'][text()='Web Tables']"), "WebTablesForm");
    }
    public void clickAdd(){
        Button button = new Button(BUTTON_ADD,"ButtonAdd");
        button.click();
    }
    public boolean deleteRow(UserData user){
        Button buttonDelete = new Button(By.id("delete-record-"+getNumberOfRow(user)),"deleteRowsButton");
        buttonDelete.click();
        return true;
    }
    public List<UserData> getAllUsers(){
        List<UserData> usersList  = new ArrayList<>();
        //HashMap нужен чтобы, если столбцы будут менять местами, тест не сломался.
        HashMap<String,String> map = new HashMap<>();
        List<WebElement> list = WaitUtil.watElements(By.xpath("//div[@class='rt-table']//*[not(contains(@class,'-padRow'))and(@role='row')]"));
        String[] keys = list.get(0).getText().split("\n");
        for (int i = 1; i < list.size(); i++) {
            String[] s = list.get(i).getText().split("\n");
            for (int j = 0; j <s.length ; j++) {
                map.put(keys[j],s[j]);
            }
            usersList.add(new UserData(map.get("First Name"), map.get("Last Name"), map.get("Email"), map.get("Age"),
                    map.get("Salary"), map.get("Department")));
        }
        return usersList;
    }
    public int getAmountOfRows(){
        List<WebElement> list = WaitUtil.watElements(By.xpath("//*[@role='rowgroup']/div[not(contains(@class,'-padRow'))]"));
        return list.size();
    }
    Set<String> s  = new HashSet<>();

    public int getNumberOfRow(UserData userData){
        return getAllUsers().indexOf(userData)+1;
    }
    public boolean contains(UserData userData){
        if(getNumberOfRow(userData)==0){
            return false;
        }else {
            return true;
        }
    }
}
