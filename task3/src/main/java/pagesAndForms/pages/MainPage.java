package pagesAndForms.pages;

import elements.Button;
import org.openqa.selenium.By;
import pagesAndForms.BasePage;

public class MainPage extends BasePage {
    public MainPage() {
        super(By.className("home-content"),"MainPage");
    }
    public void openAlertFrameAndWindow(){
        //ЧТО ТУТ ДЕЛАТ??? АААААААААААААААААААААААААА
        Button alertFrameAndWindow = new Button(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[3]/div/div[2]"),"ButtonAlertFrameAndWindow");
        alertFrameAndWindow.click();
    }
}
