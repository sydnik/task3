package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndForms.forms.FramesForm;
import pagesAndForms.forms.NestedFramesForm;
import pagesAndForms.pages.AlertsFrameWindowsPage;
import pagesAndForms.pages.MainPage;
import utils.DriverUtil;

public class TestCase2IFrame extends BaseTest{
    @Test
    public void test(){
        DriverUtil.getInstance().openURL(configUtil.getDataProperty("mainPageURL"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened());
        mainPage.openAlertFrameAndWindow();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        Assert.assertTrue(alertsFrameWindowsPage.isPageOpened());
        alertsFrameWindowsPage.openNestedFrames();
        NestedFramesForm nestedFramesForm = new NestedFramesForm();
        Assert.assertTrue(nestedFramesForm.isPageOpened());
        Assert.assertEquals(configUtil.getDataProperty("textParentFrame"),nestedFramesForm.getTextParentFrame());
        Assert.assertEquals(configUtil.getDataProperty("textChildFrame"),nestedFramesForm.getTextChildFrame());
        alertsFrameWindowsPage.openFrames();
        FramesForm framesForm = new FramesForm();
        Assert.assertTrue(framesForm.isPageOpened());
        String resultTopFrame = framesForm.getTextTopFrame();
        String resultBottomFrame = framesForm.getTextBottomFrame();
        Assert.assertEquals(resultBottomFrame,resultTopFrame);
    }
}
