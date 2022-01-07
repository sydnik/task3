package pages;

import framework.elements.Button;
import framework.elements.Container;
import framework.elements.SelectElement;
import framework.elements.TextField;
import org.openqa.selenium.By;
import framework.BaseForm;

import java.time.LocalDateTime;

public class DatePickerPage extends BaseForm {
    private final TextField DATE_FIELD = new TextField(By.id("datePickerMonthYearInput"),"datePickerMonthYearInput");
    private final TextField DATE_AND_TIME_FIELD = new TextField(By.id("dateAndTimePickerInput"),"dateAndTimePickerInput");
    private final SelectElement YEAR_SELECT = new SelectElement(By.className("react-datepicker__year-select"),"yearSelect");
    private final SelectElement MONTH_SELECT = new SelectElement(By.className("react-datepicker__month-select"),"monthSelect");

    public DatePickerPage() {
        super(new Container(By.id("datePickerContainer"),"datePickerContainer"), "DatePickerPage");
    }

    public String getDate(){
        return DATE_FIELD.getAttribute("value");
    }

    public String getDateAndTime(){
        return DATE_AND_TIME_FIELD.getAttribute("value");
    }

    public void openFormDate(){
        DATE_FIELD.click();
    }

    public void setDate(LocalDateTime localDateTime){
        selectYear(localDateTime.getYear());
        selectMonth(localDateTime.getMonthValue());
        selectDay(localDateTime.getDayOfMonth());
    }
    public void selectYear(int year){
        YEAR_SELECT.selectValue(String.valueOf(year));
    }

    public void selectMonth(int month){
        MONTH_SELECT.selectValue(String.valueOf(month-1));//-1 т.к. на сайте месяц начинается с 0
    }

    public void selectDay(int day){
        By locator = By.xpath("//div[text()='"+day+"' and not(contains(@class,'react-datepicker__day--outside-month'))]");
        new Button((locator),"select day" + day).click();
    }
}
