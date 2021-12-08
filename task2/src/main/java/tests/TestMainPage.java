package tests;

import Instruments.MyProperties;
import Instruments.MyWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TestMainPage {

    private WebElement firstFlag;
    private WebElement secondFlag;
    private WebElement buttonAbout;
    private WebDriver webDriver;
    private MyProperties properties;

    public TestMainPage(){
        webDriver = MyWebDriver.getInstance();
        properties = MyProperties.getInstance();
    }
    public void isMainPage(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(100));
        secondFlag = webDriver.findElement(By.xpath(properties.getData("xPathSecondFlag")));
        wait.until(ExpectedConditions.visibilityOf(secondFlag));
        webDriver.getCurrentUrl().equals(properties.getData("startUrl"));//Проверка что не перебросили на другую страницу
        //пока без логики
    }

    public void openPage(){


//        secondFlag = webDriver.findElement(By.xpath(properties.getData("xPathSecondFlag")));
//        System.out.println(secondFlag.getText());

    }
    public void openAboutPage(){
        buttonAbout = webDriver.findElement(By.xpath(properties.getData("xPathButtonAbout")));
        buttonAbout.click();
    }
}
