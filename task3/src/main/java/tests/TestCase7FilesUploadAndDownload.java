package tests;

import forms.LeftMenuForm;
import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.MainPage;
import framework.utils.ConfigUtil;
import framework.utils.DriverUtil;
import framework.utils.LoggerUtil;

public class TestCase7FilesUploadAndDownload extends BaseTest {
    @Test
    public void test(){
        LoggerUtil.info("TestCase7FilesUploadAndDownload","Start test");
        DriverUtil.openURL(ConfigUtil.getDataProperty("mainPageURL"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened());
        mainPage.openElements();
        new ElementsPage().isPageOpened();
        new LeftMenuForm().openUploadAndDownload();


        LoggerUtil.info("TestCase7FilesUploadAndDownload","End test");
    }
}
