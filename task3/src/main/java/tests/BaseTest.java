package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.ConfigUtil;
import utils.DriverUtil;
import utils.LoggerUtil;

public abstract class BaseTest {
    private long time;
    @BeforeTest
    public void startTest(){
        time=System.currentTimeMillis();
    }
    @AfterTest
    public void finishTest(){
        System.out.println("Tests completed:" + (System.currentTimeMillis()-time) + "ms");
        LoggerUtil.info("FinishData","Tests completed:" + (System.currentTimeMillis()-time) + "ms");
    }
    @BeforeMethod
    public void startMethod() {
        ConfigUtil.getInstance();
        DriverUtil.getInstance();
    }

    @AfterMethod
    public void endMethod(){
        if (DriverUtil.getWebDriver()!=null) {
            DriverUtil.close();
        }
    }
}
