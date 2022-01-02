package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndForms.LeftPanelButtons;
import pagesAndForms.pages.MainPage;
import pagesAndForms.pages.ProgressBarPage;
import pagesAndForms.pages.SliderPage;
import pagesAndForms.pages.WidgetsPage;
import utils.ConfigUtil;
import utils.DriverUtil;
import utils.LoggerUtil;
import utils.RandomUtil;

public class TestCase5SliderAndProgressBar extends BaseTest{

    @Test
    public void test(){
        LoggerUtil.info("TestCase5SliderAndProgressBar","Start test");
        DriverUtil.openURL(ConfigUtil.getDataProperty("mainPageURL"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened());
        mainPage.openWidgets();
        WidgetsPage widgetsPage = new WidgetsPage();
        widgetsPage.click(LeftPanelButtons.SLIDER);
        SliderPage sliderPage = new SliderPage();
        Assert.assertTrue(sliderPage.isPageOpened());
        int value = RandomUtil.randomNumber(sliderPage.getMinValue(),sliderPage.getMaxValue());
        sliderPage.setSlider(value);
        Assert.assertEquals(value,sliderPage.getValue());
        sliderPage.click(LeftPanelButtons.PROGRESS_BAR);
        ProgressBarPage progressBarPage = new ProgressBarPage();
        Assert.assertTrue(progressBarPage.isPageOpened());
        progressBarPage.clickStart();
        int ageValue = ConfigUtil.getDataIntProperty("EngineerAge");
        progressBarPage.clickStopOnValue(ageValue);
        Assert.assertTrue(((ageValue- 2) < progressBarPage.getValue())&&progressBarPage.getValue()<(ageValue+2));
        LoggerUtil.info("TestCase5SliderAndProgressBar","Finish test");
    }
}
