package tests;

import forms.LeftMenuForm;
import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import framework.utils.ConfigUtil;
import framework.utils.DriverUtil;
import framework.utils.LoggerUtil;

public class TestCase4Handles extends BaseTest {
    @Test
    public void test() {
        LoggerUtil.info("TestCase4Handles","Start test");
        DriverUtil.openURL(ConfigUtil.getDataProperty("mainPageURL"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened());
        mainPage.openAlertFrameAndWindow();
        new AlertsFrameWindowsPage().isPageOpened();
        LeftMenuForm leftMenuForm = new LeftMenuForm();
        leftMenuForm.openBrowseWindows();
        BrowserWindowPage browserWindowPage = new BrowserWindowPage();
        Assert.assertTrue(browserWindowPage.isPageOpened());
        DriverUtil.saveCurrentWindows();
        browserWindowPage.clickNewTab();
        DriverUtil.waitAndOpenNewWindow();
        Assert.assertTrue(DriverUtil.getCurrentUrl().endsWith(ConfigUtil.getDataProperty("newTabURL")));
        SamplePage samplePage = new SamplePage();
        Assert.assertTrue(samplePage.getText().endsWith(ConfigUtil.getDataProperty("textNewTab")));
        DriverUtil.closeTab();
        DriverUtil.openAvailableWindow();
        Assert.assertTrue(browserWindowPage.isPageOpened());
        leftMenuForm.openLinks();
        LinksPage linksPage = new LinksPage();
        Assert.assertTrue(linksPage.isPageOpened());
        DriverUtil.saveCurrentWindows();
        String tab = DriverUtil.getCurrentWindow();
        DriverUtil.saveCurrentWindows();
        linksPage.openHomeNewTab();
        DriverUtil.waitAndOpenNewWindow();
        Assert.assertTrue(mainPage.isPageOpened());
        Assert.assertNotEquals(DriverUtil.getCurrentWindow(),tab);
        DriverUtil.openAvailableWindow();
        Assert.assertTrue(linksPage.isPageOpened());
        LoggerUtil.info("TestCase4Handles","Finish test");
    }
}
