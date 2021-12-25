package tests;

import data.UserData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pagesAndForms.forms.RegistrationForm;
import pagesAndForms.forms.WebTablesForm;
import pagesAndForms.pages.ElementsPage;
import pagesAndForms.pages.MainPage;
import utils.DriverUtil;
import utils.LoggerUtil;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class TestCase3Tables extends BaseTest{
    private final String TEST_DATA_FILE_PATH = "src/main/resources/dataTestCase3Tables.dat";

    @Test(dataProvider = "getDataForTest")
    public void test(String id,String firstName, String lastName, String email, String age, String salary, String department){
        DriverUtil.getInstance().openURL(configUtil.getDataProperty("mainPageURL"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened());
        mainPage.openElements();
        ElementsPage elementsPage = new ElementsPage();
        elementsPage.isPageOpened();
        elementsPage.openWebTables();
        WebTablesForm webTablesForm = new WebTablesForm();
        webTablesForm.isPageOpened();
        webTablesForm.clickAdd();
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.isPageOpened();
        UserData userData = new UserData(firstName,lastName,email,age,salary,department);
        registrationForm.sendDataUser(userData);
        registrationForm.clickSubmit();
        Assert.assertTrue(registrationForm.isPageClosed());
        int amountOfRows = webTablesForm.getAmountOfRows();
        webTablesForm.deleteRow(userData);
        Assert.assertEquals(amountOfRows-1,webTablesForm.getAmountOfRows());
        List<UserData> list = webTablesForm.getAllUsers();
        Assert.assertFalse(list.contains(userData));
    }
    @DataProvider
    public Object[][] getDataForTest(){
        Object[][] result;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(TEST_DATA_FILE_PATH), StandardCharsets.UTF_8));
            String line = null;
            List<Object[]> list = new ArrayList<>();
            while (reader.ready()){
                line = reader.readLine();
                list.add(line.split("\t"));
            }
            result = list.toArray(new Object[0][]);
        }  catch (IOException e) {
            LoggerUtil.fatal("DataForTest3",e.getMessage());
            throw new RuntimeException();
        }
        return result;
    }
}





