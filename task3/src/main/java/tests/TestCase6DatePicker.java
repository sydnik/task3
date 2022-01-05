package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndForms.LeftPanelButtons;
import pagesAndForms.pages.DatePickerPage;
import pagesAndForms.pages.MainPage;
import pagesAndForms.pages.WidgetsPage;
import utils.ConfigUtil;
import utils.DateUtil;
import utils.DriverUtil;
import utils.LoggerUtil;

import java.time.LocalDateTime;

public class TestCase6DatePicker extends BaseTest{

    @Test
    public void test(){
        LoggerUtil.info("TestCase6DatePicker","Start test");
        DriverUtil.openURL(ConfigUtil.getDataProperty("mainPageURL"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened());
        mainPage.openWidgets();
        WidgetsPage widgetsPage = new WidgetsPage();
        widgetsPage.click(LeftPanelButtons.DATE_PICKER);
        DatePickerPage datePickerPage = new DatePickerPage();
        datePickerPage.isPageOpened();
        Assert.assertEquals(DateUtil.getTimeAndDate(ConfigUtil.getDataProperty("datePattern")),datePickerPage.getDate());
        Assert.assertEquals(DateUtil.getTimeAndDate(ConfigUtil.getDataProperty("dateAndTimePattern")),datePickerPage.getDateAndTime());
        datePickerPage.openFormDate();
        LocalDateTime localDateTime = DateUtil.getNearest29February(LocalDateTime.now());
        datePickerPage.setDate(localDateTime);
        Assert.assertEquals(DateUtil.getTimeAndDate(localDateTime,ConfigUtil.getDataProperty("datePattern")),datePickerPage.getDate());
        LoggerUtil.info("TestCase6DatePicker","Finish test");
    }
}
