package pages;

import data.UserData;
import framework.elements.Button;
import framework.elements.Container;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import framework.BaseForm;
import framework.utils.WaitUtil;

import java.util.*;

public class WebTablesPage extends BaseForm {
    private final By ROWS_WITH_VALUE = By.xpath("//*[@role='rowgroup']/div[not(contains(@class,'-padRow'))]");
    private final Label COLUMN_NAMES =  new Label(By.className("rt-tr"),"COLUMN_NAME");
    private final Button BUTTON_ADD = new Button(By.id("addNewRecordButton"),"ButtonAdd");

    public WebTablesPage() {
        super(new Container(By.className("web-tables-wrapper"),"UniqueElement"), "WebTablesPage");
    }

    public void clickAdd(){
        BUTTON_ADD.click();
    }

    public void deleteRow(UserData user){
        new Button(By.id("delete-record-"+getNumberOfRow(user)),"deleteRowsButton").click();
    }

    public List<UserData> getAllUsers(){
        List<UserData> usersList  = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>();
        List<WebElement> list = WaitUtil.watElements(ROWS_WITH_VALUE);
        String[] keys = getColumnNames();
        for (int i = 0; i < list.size(); i++) {
            String[] s = list.get(i).getText().split("\n");
            for (int j = 0; j <s.length ; j++) {
                map.put(keys[j],s[j]);
            }
            usersList.add(new UserData(map.get("First Name"), map.get("Last Name"), map.get("Email"),
                    map.get("Age"), map.get("Salary"), map.get("Department")));
        }
        return usersList;
    }

    public int getAmountOfRows(){
        List<WebElement> list = WaitUtil.watElements(ROWS_WITH_VALUE);
        return list.size();
    }

    private int getNumberOfRow(UserData userData){
        return getAllUsers().indexOf(userData)+1;
    }

    private String[] getColumnNames(){
        return COLUMN_NAMES.getText().split("\n");
    }
}
