package pagesAndForms.pages;

import data.UserData;
import elements.Button;
import elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pagesAndForms.BaseForm;
import utils.WaitUtil;

import java.util.*;

public class WebTablesPage extends BaseForm {
    private final By ROWS_WITH_VALUE = By.xpath("//*[@role='rowgroup']/div[not(contains(@class,'-padRow'))]");
    private final By COLUMN_NAMES = By.className("rt-tr");
    private final By BUTTON_ADD = By.id("addNewRecordButton");

    public WebTablesPage() {
        super(By.className("web-tables-wrapper"), "WebTablesPage");
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
        //Можно сделать просто по позициям, но мне кажется в больших проектах так будет лучше.
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
        Label label = new Label(COLUMN_NAMES,"COLUMN_NAME");
        String[] names = label.getText().split("\n");
        return names;
    }
}
