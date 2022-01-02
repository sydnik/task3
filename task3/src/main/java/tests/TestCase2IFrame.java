package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndForms.LeftPanelButtons;
import pagesAndForms.pages.*;
import pagesAndForms.pages.FramesPage;
import utils.ConfigUtil;
import utils.DriverUtil;
import utils.LoggerUtil;

public class TestCase2IFrame extends BaseTest{
    @Test
    public void test(){
        LoggerUtil.info("TestCase2IFrame","Start test");
        DriverUtil.openURL(ConfigUtil.getDataProperty("mainPageURL"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened());
        mainPage.openAlertFrameAndWindow();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.click(LeftPanelButtons.NESTED_FRAMES);
        NestedFramesPage nestedFramesPage = new NestedFramesPage();
        Assert.assertTrue(nestedFramesPage.isPageOpened());
        Assert.assertEquals(ConfigUtil.getDataProperty("textParentFrame"), nestedFramesPage.getTextParentFrame());
        Assert.assertEquals(ConfigUtil.getDataProperty("textChildFrame"), nestedFramesPage.getTextChildFrame());
        alertsFrameWindowsPage.click(LeftPanelButtons.FRAMES);
        FramesPage framesPage = new FramesPage();
        Assert.assertTrue(framesPage.isPageOpened());
        String resultTopFrame = framesPage.getTextTopWindow();
        String resultBottomFrame = framesPage.getTextBottomWindow();
        Assert.assertEquals(resultBottomFrame,resultTopFrame);
        LoggerUtil.info("TestCase2IFrame","Finish test");
    }
}
