package pagesAndForms.pages;

import elements.Button;
import elements.SelectElement;
import elements.TextField;
import org.openqa.selenium.By;
import pagesAndForms.BaseForm;

import java.time.LocalDateTime;

public class DatePickerPage extends BaseForm {
    private final By DATE = By.id("datePickerMonthYearInput");
    private final By DATE_AND_TIME = By.id("dateAndTimePickerInput");
    private final By YEAR_FIELD = By.className("react-datepicker__year-select");
    private final By MONTH_FIELD = By.className("react-datepicker__month-select");

    public DatePickerPage() {
        super(By.id("datePickerContainer"), "DatePickerPage");
    }

    public String getDate(){
        TextField textField = new TextField(DATE,"SimplerDate");
        return textField.getAttribute("value");
    }

    public String getDateAndTime(){
        TextField textField = new TextField(DATE_AND_TIME,"SimplerDate");
        return textField.getAttribute("value");
    }

    public void openFormDate(){
        TextField textField = new TextField(DATE,"datePickerMonthYearInput");
        textField.click();
    }

    public void setDate(LocalDateTime localDateTime){
        selectYear(localDateTime.getYear());
        selectMonth(localDateTime.getMonthValue());
        selectDay(localDateTime.getDayOfMonth());
    }
    public void selectYear(int year){
        SelectElement textField1 = new SelectElement(YEAR_FIELD,"select Year" + year );
        textField1.selectValue(String.valueOf(year));
    }

    public void selectMonth(int month){
        SelectElement textField1 = new SelectElement(MONTH_FIELD,"select month" + month );
        textField1.selectValue(String.valueOf(month-1));//-1 т.к. на сайте месяц начинается с 0
    }

    public void selectDay(int day){
        By locator = By.xpath("//div[text()='"+day+"' and not(contains(@class,'react-datepicker__day--outside-month'))]");
        Button button = new Button((locator),"select day" + day);
        button.click();
    }
}
