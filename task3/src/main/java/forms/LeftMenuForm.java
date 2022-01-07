package forms;

import framework.BaseForm;
import framework.elements.BaseElement;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class LeftMenuForm extends BaseForm {
    private final Button ELEMENTS = new Button(By.xpath("//*[@class='header-wrapper']//*[text()='Elements']"),"Elements");
    private final Button LINKS = new Button(By.xpath("//*[@class='text'][text()='Links']"),"Links");
    private final Button WEB_TABLES = new Button(By.xpath("//*[@class='text'][text()='Web Tables']"),"Web Tables");
    private final Button UPLOAD_AND_DOWNLOAD = new Button(By.xpath("//*[@class='text'][text()='Upload and Download']"),"Upload and Download");

    private final Button ALERTS_FRAME_WINDOWS = new Button(By.xpath("//*[@class='header-wrapper']//*[text()='Alerts, Frame & Windows']"),"Alerts, Frame & Windows");
    private final Button BROWSER_WINDOWS = new Button(By.xpath("//*[@class='text'][text()='Browser Windows']"),"Browser Windows");
    private final Button ALERT = new Button (By.xpath("//*[@class='text'][text()='Alerts']"),"Alerts");
    private final Button FRAMES = new Button(By.xpath("//*[@class='text'][text()='Frames']"),"Frames");
    private final Button NESTED_FRAMES = new Button(By.xpath("//*[@class='text'][text()='Nested Frames']"),"Nested Frames");

    private final Button WIDGETS = new Button(By.xpath("//*[@class='header-wrapper']//*[text()='Widgets']"),"Widgets");
    private final Button SLIDER = new Button(By.xpath("//*[@class='text'][text()='Slider']"),"Slider");
    private final Button PROGRESS_BAR = new Button(By.xpath("//*[@class='text'][text()='Progress Bar']"),"Progress Bar");
    private final Button DATE_PICKER = new Button(By.xpath("//*[@class='text'][text()='Date Picker']"),"Date Picker");


    public LeftMenuForm() {
        super(new Label(By.className("left-pannel"),"leftMenuPanel"), "LeftMenuForm");
    }
    public void openElements(){
        ELEMENTS.click();
    }
    public void openLinks(){
        if(!LINKS.isVisibilityNow()){
            openElements();
        }
        LINKS.click();
    }

    public void openWebTables(){
        if(!WEB_TABLES.isVisibilityNow()){
            openElements();
        }
        WEB_TABLES.click();
    }
    public void openUploadAndDownload(){
        if(!UPLOAD_AND_DOWNLOAD.isVisibilityNow()){
            openElements();
        }
        UPLOAD_AND_DOWNLOAD.click();
    }
    public void openAlertsFrameWindows(){
        ALERTS_FRAME_WINDOWS.click();
    }
    public void openBrowseWindows(){
        if(!BROWSER_WINDOWS.isVisibilityNow()){
            openAlertsFrameWindows();
        }
        BROWSER_WINDOWS.click();
    }
    public void openAlert(){
        if(!ALERT.isVisibilityNow()){
            openAlertsFrameWindows();
        }
        ALERT.click();
    }
    public void openFrames(){
        if(!FRAMES.isVisibilityNow()){
            openAlertsFrameWindows();
        }
        FRAMES.click();
    }
    public void openNestedFrames(){
        if(!NESTED_FRAMES.isVisibilityNow()){
            openAlertsFrameWindows();
        }
        NESTED_FRAMES.click();
    }
    public void openWidgets(){
        WIDGETS.click();
    }
    public void openSlider(){
        if(!SLIDER.isVisibilityNow()){
            openWidgets();
        }
        SLIDER.click();
    }
    public void openProgressBar(){
        if(!PROGRESS_BAR.isVisibilityNow()){
            openWidgets();
        }
        PROGRESS_BAR.click();
    }
    public void openDatePicker(){
        if(!DATE_PICKER.isVisibilityNow()){
            openWidgets();
        }
        DATE_PICKER.click();
    }
}
