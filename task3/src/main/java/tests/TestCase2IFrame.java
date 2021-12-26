package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndForms.forms.FramesForm;
import pagesAndForms.forms.NestedFramesForm;
import pagesAndForms.pages.AlertsFrameWindowsPage;
import pagesAndForms.pages.MainPage;
import utils.ConfigUtil;
import utils.DriverUtil;

public class TestCase2IFrame extends BaseTest{
    @Test
    public void test(){
        DriverUtil.openURL(ConfigUtil.getDataProperty("mainPageURL"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened());
        mainPage.openAlertFrameAndWindow();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.openNestedFrames();
        NestedFramesForm nestedFramesForm = new NestedFramesForm();
        Assert.assertTrue(nestedFramesForm.isPageOpened());
        Assert.assertEquals(ConfigUtil.getDataProperty("textParentFrame"),nestedFramesForm.getTextParentFrame());
        Assert.assertEquals(ConfigUtil.getDataProperty("textChildFrame"),nestedFramesForm.getTextChildFrame());
        alertsFrameWindowsPage.openFrames();
        FramesForm framesForm = new FramesForm();
        Assert.assertTrue(framesForm.isPageOpened());
        String resultTopFrame = framesForm.getTextTopFrame();
        String resultBottomFrame = framesForm.getTextBottomFrame();
        Assert.assertEquals(resultBottomFrame,resultTopFrame);
    }
}
