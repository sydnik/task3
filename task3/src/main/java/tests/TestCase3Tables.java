package tests;

import data.UserData;
import forms.LeftMenuForm;
import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import forms.RegistrationForm;
import pages.MainPage;
import pages.WebTablesPage;
import pages.ElementsPage;
import framework.utils.ConfigUtil;
import framework.utils.DriverUtil;
import framework.utils.LoggerUtil;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TestCase3Tables extends BaseTest {

    @Test(dataProvider = "getDataForTest")
    public void test(String id,String firstName, String lastName, String email, String age, String salary, String department){
        LoggerUtil.info("TestCase3Tables","Start test");
        DriverUtil.openURL(ConfigUtil.getDataProperty("mainPageURL"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened());
        mainPage.openElements();
        new ElementsPage().isPageOpened();
        new LeftMenuForm().openWebTables();
        WebTablesPage webTablesPage = new WebTablesPage();
        Assert.assertTrue(webTablesPage.isPageOpened());
        webTablesPage.clickAdd();
        RegistrationForm registrationForm = new RegistrationForm();
        Assert.assertTrue(registrationForm.isPageOpened());
        UserData userData = new UserData(firstName,lastName,email,age,salary,department);
        registrationForm.sendDataUser(userData);
        registrationForm.clickSubmit();
        Assert.assertTrue(registrationForm.isPageClosed());
        Assert.assertTrue(webTablesPage.getAllUsers().contains(userData));
        int amountOfRows = webTablesPage.getAmountOfRows();
        webTablesPage.deleteRow(userData);
        Assert.assertEquals(amountOfRows-1, webTablesPage.getAmountOfRows());
        Assert.assertFalse(webTablesPage.getAllUsers().contains(userData));
        LoggerUtil.info("TestCase3Tables","Finish test");
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





