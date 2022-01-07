package tests;

import forms.LeftMenuForm;
import framework.BaseTest;
import framework.utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.AlertsFrameWindowsPage;
import pages.MainPage;

public class TestCase1Alerts extends BaseTest {
    @Test
    public void test()  {
        LoggerUtil.info("TestCase1Alerts","Start test");
        DriverUtil.openURL(ConfigUtil.getDataProperty("mainPageURL"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened());
        mainPage.openAlertFrameAndWindow();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.isPageOpened();
        LeftMenuForm leftMenuForm = new LeftMenuForm();
        leftMenuForm.openAlert();
        AlertPage formAlert = new AlertPage();
        Assert.assertTrue(formAlert.isPageOpened());
        formAlert.clickAlert();
        AlertUtil.isAlert();
        Assert.assertEquals(AlertUtil.getText(), ConfigUtil.getDataProperty("textClickAlert"));
        AlertUtil.accept();
        AlertUtil.isAlertClosed();
        formAlert.clickConfirm();
        Assert.assertEquals(AlertUtil.getText(),ConfigUtil.getDataProperty("textClickConfirm"));
        AlertUtil.accept();
        AlertUtil.isAlertClosed();
        Assert.assertEquals(formAlert.getConfirmResult(),ConfigUtil.getDataProperty("resultConfirm"));
        formAlert.clickPrompt();
        Assert.assertEquals(AlertUtil.getText(),ConfigUtil.getDataProperty("textClickPrompt"));
        String randomLine = RandomUtil.randomText();
        AlertUtil.sendKeys(randomLine);
        AlertUtil.accept();
        Assert.assertTrue(AlertUtil.isAlertClosed());
        Assert.assertEquals(formAlert.getPromptResult(),"You entered " +randomLine);
        LoggerUtil.info("TestCase1Alerts","Finish test");
    }
}
