package tests;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndForms.forms.AlertForm;
import pagesAndForms.pages.AlertsFrameWindowsPage;
import pagesAndForms.pages.MainPage;
import utils.AlertUtil;
import utils.DriverUtil;

public class TestCase1Alerts extends BaseTest{
    @Test
    public void test()  {
        DriverUtil.getInstance().openURL(configUtil.getDataProperty("mainPageURL"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened());
        mainPage.openAlertFrameAndWindow();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.isPageOpened();
        alertsFrameWindowsPage.openAlert();
        AlertForm formAlert = new AlertForm();
        Assert.assertTrue(formAlert.isPageOpened());
        formAlert.clickAlert();
        AlertUtil.isAlert();
        Assert.assertEquals(AlertUtil.getText(), configUtil.getDataProperty("textClickAlert"));
        AlertUtil.accept();
        AlertUtil.isAlertClosed();
        formAlert.clickConfirm();
        AlertUtil.isAlert();
        Assert.assertEquals(AlertUtil.getText(),configUtil.getDataProperty("textClickConfirm"));
        AlertUtil.accept();
        AlertUtil.isAlertClosed();
        Assert.assertEquals(formAlert.getConfirmResult(),configUtil.getDataProperty("resultConfirm"));
        formAlert.clickPrompt();
        AlertUtil.isAlert();
        Assert.assertEquals(AlertUtil.getText(),configUtil.getDataProperty("textClickPrompt"));
        String randomLine = RandomStringUtils.randomAlphabetic((int) (Math.random()*100));
        AlertUtil.sendKeys(randomLine);
        AlertUtil.accept();
        AlertUtil.isAlertClosed();
        Assert.assertEquals(formAlert.getPromptResult(),"You entered " +randomLine);
    }
}
