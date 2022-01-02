package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndForms.pages.*;
import pagesAndForms.LeftPanelButtons;
import utils.ConfigUtil;
import utils.DriverUtil;
import utils.WaitUtil;

public class TestCase4Handles extends BaseTest{
    @Test
    public void test() {
        DriverUtil.openURL(ConfigUtil.getDataProperty("mainPageURL"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened());
        mainPage.openAlertFrameAndWindow();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.click(LeftPanelButtons.BROWSER_WINDOWS);
        BrowserWindowPage browserWindowPage = new BrowserWindowPage();
        Assert.assertTrue(browserWindowPage.isPageOpened());
        DriverUtil.saveCurrentWindows();
        browserWindowPage.clickNewTab();
        DriverUtil.openNewWindow();
        Assert.assertTrue(DriverUtil.getCurrentUrl().endsWith(ConfigUtil.getDataProperty("newTabURL")));
        SamplePage samplePage = new SamplePage();
        Assert.assertTrue(samplePage.getText().endsWith(ConfigUtil.getDataProperty("textNewTab")));
        DriverUtil.closeTab();
        DriverUtil.openAvailableWindow();
        Assert.assertTrue(browserWindowPage.isPageOpened());
        browserWindowPage.click(LeftPanelButtons.LINKS);
        LinksPage linksPage = new LinksPage();
        Assert.assertTrue(linksPage.isPageOpened());
        DriverUtil.saveCurrentWindows();
        String tab = DriverUtil.getCurrentWindow();
        int numberOfWindow =DriverUtil.getNumberOfWindow()+1;
        linksPage.openHomeNewTab();
        WaitUtil.waitNewWindow(numberOfWindow);
        DriverUtil.openNewWindow();
        Assert.assertTrue(mainPage.isPageOpened());
        Assert.assertNotEquals(DriverUtil.getCurrentWindow(),tab);
        DriverUtil.openAvailableWindow();
        Assert.assertTrue(linksPage.isPageOpened());
    }
}
