package tests;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndForms.pages.AlertPage;
import pagesAndForms.pages.AlertsFrameWindowsPage;
import pagesAndForms.LeftPanelButtons;
import pagesAndForms.pages.MainPage;
import utils.AlertUtil;
import utils.ConfigUtil;
import utils.DriverUtil;

public class TestCase1Alerts extends BaseTest{
    @Test
    public void test()  {
        DriverUtil.openURL(ConfigUtil.getDataProperty("mainPageURL"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened());
        mainPage.openAlertFrameAndWindow();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.click(LeftPanelButtons.ALERT);
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
        String randomLine = RandomStringUtils.randomAlphabetic((int) (Math.random()*100));
        AlertUtil.sendKeys(randomLine);
        AlertUtil.accept();
        Assert.assertTrue(AlertUtil.isAlertClosed());
        Assert.assertEquals(formAlert.getPromptResult(),"You entered " +randomLine);
    }
}
