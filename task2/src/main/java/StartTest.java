import Instruments.MyProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Instruments.MyWebDriver;
import tests.TestAboutPage;
import tests.TestMainPage;

public class StartTest {
    private WebDriver webDriver;
    private MyProperties properties;

    @BeforeTest
    public void startTests(){
        webDriver = MyWebDriver.getInstance();
        properties = MyProperties.getInstance();
    }
    @AfterTest
    public void endTests(){
        if (webDriver!=null) {
            webDriver.quit();
            MyProperties.getInstance().close();
        }
    }

    @Test
    public void test1() throws InterruptedException {
        webDriver.get(properties.getData("startUrl"));
        TestMainPage test = new TestMainPage();
        test.isMainPage();
        test.openAboutPage();
        TestAboutPage test2 = new TestAboutPage();
        test2.isAboutPage();
        test2.comparePlayer();
        test2.clickShop();
        Thread.sleep(10000);
    }
    @Test
    public void test2(){
        new TestMainPage().openPage();
    }
}
