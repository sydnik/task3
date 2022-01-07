package pagesAndForms;

import org.openqa.selenium.By;

public enum LeftPanelButtons {
    ELEMENTS(By.xpath("//*[@class='header-wrapper']//*[text()='Elements']"),null);
//    LINKS(By.xpath("//*[@class='text'][text()='Links']"),ELEMENTS),
//    WEB_TABLES(By.xpath("//*[@class='text'][text()='Web Tables']"),ELEMENTS),
//    UPLOAD_AND_DOWNLOAD(By.xpath("//*[@class='text'][text()='Upload and Download']"),ELEMENTS),
//
//    ALERTS_FRAME_WINDOWS(By.xpath("//*[@class='header-wrapper']//*[text()='Alerts, Frame & Windows']"),null),
//    BROWSER_WINDOWS(By.xpath("//*[@class='text'][text()='Browser Windows']"),ALERTS_FRAME_WINDOWS),
//    ALERT(By.xpath("//*[@class='text'][text()='Alerts']"),ALERTS_FRAME_WINDOWS),
//    FRAMES(By.xpath("//*[@class='text'][text()='Frames']"),ALERTS_FRAME_WINDOWS),
//    NESTED_FRAMES(By.xpath("//*[@class='text'][text()='Nested Frames']"),ALERTS_FRAME_WINDOWS),
//
//    WIDGETS(By.xpath("//*[@class='header-wrapper']//*[text()='Widgets']"),null),
//    SLIDER(By.xpath("//*[@class='text'][text()='Slider']"),WIDGETS),
//    PROGRESS_BAR(By.xpath("//*[@class='text'][text()='Progress Bar']"),WIDGETS),
//    DATE_PICKER(By.xpath("//*[@class='text'][text()='Date Picker']"),WIDGETS);


    private By locator;
    private LeftPanelButtons parent;

    LeftPanelButtons(By locator, LeftPanelButtons parent) {
        this.locator = locator;
        this.parent = parent;
    }

    public By getLocator() {
        return locator;
    }

    public String getName() {
        return this.getClass().getSimpleName()+": "+name();
    }

    public LeftPanelButtons getParent() {
        return parent;
    }


}
