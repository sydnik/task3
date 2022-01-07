package tests;


import forms.LeftMenuForm;
import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsFrameWindowsPage;
import pages.MainPage;
import pages.NestedFramesPage;
import pages.FramesPage;
import framework.utils.ConfigUtil;
import framework.utils.DriverUtil;
import framework.utils.LoggerUtil;

public class TestCase2IFrame extends BaseTest {
    @Test
    public void test(){
        LoggerUtil.info(this.getClass(),"Start test");
        DriverUtil.openURL(ConfigUtil.getDataProperty("mainPageURL"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened());
        mainPage.openAlertFrameAndWindow();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.isPageOpened();
        LeftMenuForm leftMenuForm = new LeftMenuForm();
        leftMenuForm.openNestedFrames();
        NestedFramesPage nestedFramesPage = new NestedFramesPage();
        Assert.assertTrue(nestedFramesPage.isPageOpened());
        Assert.assertEquals(ConfigUtil.getDataProperty("textParentFrame"), nestedFramesPage.getTextParentFrame());
        Assert.assertEquals(ConfigUtil.getDataProperty("textChildFrame"), nestedFramesPage.getTextChildFrame());
        leftMenuForm.openFrames();
        FramesPage framesPage = new FramesPage();
        Assert.assertTrue(framesPage.isPageOpened());
        String resultTopFrame = framesPage.getTextTopWindow();
        String resultBottomFrame = framesPage.getTextBottomWindow();
        Assert.assertEquals(resultBottomFrame,resultTopFrame);
        LoggerUtil.info(this.getClass(),"Finish test");
    }
}
