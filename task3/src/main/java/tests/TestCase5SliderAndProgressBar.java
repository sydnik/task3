package tests;

import forms.LeftMenuForm;
import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProgressBarPage;
import pages.SliderPage;
import pages.WidgetsPage;
import framework.utils.ConfigUtil;
import framework.utils.DriverUtil;
import framework.utils.LoggerUtil;
import framework.utils.RandomUtil;

public class TestCase5SliderAndProgressBar extends BaseTest {

    @Test
    public void test(){
        LoggerUtil.info("TestCase5SliderAndProgressBar","Start test");
        DriverUtil.openURL(ConfigUtil.getDataProperty("mainPageURL"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened());
        mainPage.openWidgets();
        new WidgetsPage().isPageOpened();
        LeftMenuForm leftMenuForm = new LeftMenuForm();
        leftMenuForm.openSlider();
        SliderPage sliderPage = new SliderPage();
        Assert.assertTrue(sliderPage.isPageOpened());
        int value = RandomUtil.randomNumber(sliderPage.getMinValue(),sliderPage.getMaxValue());
        sliderPage.setSlider(value);
        Assert.assertEquals(value,sliderPage.getValue());
        leftMenuForm.openProgressBar();
        ProgressBarPage progressBarPage = new ProgressBarPage();
        Assert.assertTrue(progressBarPage.isPageOpened());
        progressBarPage.clickStart();
        int ageValue = ConfigUtil.getDataIntProperty("engineerAge");
        progressBarPage.clickStopOnValue(ageValue);
        Assert.assertTrue(((ageValue- ConfigUtil.getDataIntProperty("engineerAgeMarginOfError")) < progressBarPage.getValue())&&
                progressBarPage.getValue()<(ageValue+ConfigUtil.getDataIntProperty("engineerAgeMarginOfError")));
        LoggerUtil.info("TestCase5SliderAndProgressBar","Finish test");
    }
}
