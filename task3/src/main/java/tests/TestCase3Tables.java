package tests;

import data.UserData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pagesAndForms.forms.RegistrationForm;
import pagesAndForms.forms.WebTablesForm;
import pagesAndForms.pages.ElementsPage;
import pagesAndForms.pages.MainPage;
import utils.ConfigUtil;
import utils.DriverUtil;
import utils.LoggerUtil;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TestCase3Tables extends BaseTest{

    @Test(dataProvider = "getDataForTest")
    public void test(String id,String firstName, String lastName, String email, String age, String salary, String department){
        System.out.println(id);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(email);
        System.out.println(age);
        System.out.println(salary);
        System.out.println(department);
        DriverUtil.openURL(ConfigUtil.getDataProperty("mainPageURL"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened());
        mainPage.openElements();
        ElementsPage elementsPage = new ElementsPage();
        elementsPage.openWebTables();
        WebTablesForm webTablesForm = new WebTablesForm();
        Assert.assertTrue(webTablesForm.isPageOpened());
        webTablesForm.clickAdd();
        RegistrationForm registrationForm = new RegistrationForm();
        Assert.assertTrue(registrationForm.isPageOpened());
        UserData userData = new UserData(firstName,lastName,email,age,salary,department);
        registrationForm.sendDataUser(userData);
        registrationForm.clickSubmit();
        Assert.assertTrue(registrationForm.isPageClosed());
        Assert.assertTrue(webTablesForm.contains(userData));
        int amountOfRows = webTablesForm.getAmountOfRows();
        webTablesForm.deleteRow(userData);
        Assert.assertEquals(amountOfRows-1,webTablesForm.getAmountOfRows());
        Assert.assertFalse(webTablesForm.contains(userData));
    }
    @DataProvider
    public Object[][] getDataForTest(){
        Object[][] result;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(ConfigUtil.getDataProperty("dataForTestCase3")), StandardCharsets.UTF_8));
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





