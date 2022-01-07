package tests;

import forms.LeftMenuForm;
import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DatePickerPage;
import pages.MainPage;
import pages.WidgetsPage;
import framework.utils.ConfigUtil;
import framework.utils.DateUtil;
import framework.utils.DriverUtil;
import framework.utils.LoggerUtil;

import java.time.LocalDateTime;

public class TestCase6DatePicker extends BaseTest {

    @Test
    public void test(){
        LoggerUtil.info("TestCase6DatePicker","Start test");
        DriverUtil.openURL(ConfigUtil.getDataProperty("mainPageURL"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened());
        mainPage.openWidgets();
        new WidgetsPage().isPageOpened();
        new LeftMenuForm().openDatePicker();
        DatePickerPage datePickerPage = new DatePickerPage();
        datePickerPage.isPageOpened();
        Assert.assertEquals(DateUtil.getTimeAndDate(ConfigUtil.getDataProperty("datePattern")),datePickerPage.getDate());
        System.out.println(DateUtil.getTimeAndDate(ConfigUtil.getDataProperty("dateAndTimePattern")));
        System.out.println(datePickerPage.getDateAndTime());
        Assert.assertEquals(DateUtil.getTimeAndDate(ConfigUtil.getDataProperty("dateAndTimePattern")),datePickerPage.getDateAndTime());
        datePickerPage.openFormDate();
        LocalDateTime localDateTime = DateUtil.getNearest29February(LocalDateTime.now());
        datePickerPage.setDate(localDateTime);
        Assert.assertEquals(DateUtil.getTimeAndDate(localDateTime,ConfigUtil.getDataProperty("datePattern")),datePickerPage.getDate());
        LoggerUtil.info("TestCase6DatePicker","Finish test");
    }
}
