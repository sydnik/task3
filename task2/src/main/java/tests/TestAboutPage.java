package tests;

import Instruments.MyProperties;
import Instruments.MyWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestAboutPage {
    private WebDriver webDriver;
    private MyProperties properties;
    public TestAboutPage(){
        webDriver = MyWebDriver.getInstance();
        properties = MyProperties.getInstance();
    }
    public void isAboutPage(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(100));
        WebElement element = webDriver.findElement(By.id(properties.getData("idCounter")));
        wait.until(ExpectedConditions.visibilityOf(element));
        webDriver.getCurrentUrl().equals(properties.getData("aboutUrl"));//Проверка что не перебросили на другую страницу
        //пока без логики
    }
    public void comparePlayer() throws InterruptedException {
        Thread.sleep(1000);
        ////*[contains(@class, 'gamers_online')]//parent::*/text()[2]    в хроме работает, тут нет - no such element
        WebElement online = webDriver.findElement(By.xpath("//div[contains(@class, 'gamers_online')]//parent::div[@class='online_stat']"));
        String[] s = online.getText().split("\n");
        String s1 = s[1].replaceAll(",","");
        int result = Integer.parseInt(s1) ;

        WebElement gamersInGame = webDriver.findElement(By.xpath("//div[contains(@class, 'gamers_in_game')]//parent::div[@class='online_stat']"));
        String[] ss = gamersInGame.getText().split("\n");
        String ss1 = ss[1].replaceAll(",","");
        int result2 = Integer.parseInt(ss1) ;
        if(result>result2){
            System.out.println("Да, игроков онлайн больше чем играют");
        }
    }
    public void clickShop(){
        WebElement element = webDriver.findElement(By.xpath("//div[@class='supernav_container']//a[@data-tooltip-content='.submenu_store']"));
        element.click();
        // нужна проверка на видимость т.к. может быть мобильная версия и там другой код
//        ".submenu_store"
    }
}
