package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndForms.forms.BrowserWindowForm;
import pagesAndForms.pages.AlertsFrameWindowsPage;
import pagesAndForms.pages.LeftPanelButtons;
import pagesAndForms.pages.LinksPage;
import pagesAndForms.pages.MainPage;
import utils.ConfigUtil;
import utils.DriverUtil;

public class TestCase4Handles extends BaseTest{
    @Test
    public void test() {
        DriverUtil.openURL(ConfigUtil.getDataProperty("mainPageURL"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened());
        mainPage.openAlertFrameAndWindow();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.openBrowserWindow();
        BrowserWindowForm browserWindowForm = new BrowserWindowForm();
        Assert.assertTrue(browserWindowForm.isPageOpened());
        DriverUtil.saveCurrentWidnows();
        browserWindowForm.clickNewTab();
        DriverUtil.openNewWindow();
        Assert.assertTrue(DriverUtil.getInstance().getWebDriver().getCurrentUrl().endsWith(ConfigUtil.getDataProperty("newTabURL")));
        Assert.assertTrue(DriverUtil.getInstance().getWebDriver().findElement(By.id("sampleHeading")).getText().endsWith(ConfigUtil.getDataProperty("textNewTab")));
        DriverUtil.getInstance().getWebDriver().close();
        DriverUtil.openAvailableWindow();
        Assert.assertTrue(browserWindowForm.isPageOpened());
        browserWindowForm.open(LeftPanelButtons.LINKS);
        LinksPage linksPage = new LinksPage();
        Assert.assertTrue(linksPage.isPageOpened());
        DriverUtil.saveCurrentWidnows();
        String tab = DriverUtil.getCurrentWidnow();
        linksPage.openHomeNewTab();
        DriverUtil.openNewWindow();
        Assert.assertTrue(mainPage.isPageOpened());
        Assert.assertNotEquals(DriverUtil.getCurrentWidnow(),tab);
        DriverUtil.openAvailableWindow();
        Assert.assertTrue(linksPage.isPageOpened());
    }
}
