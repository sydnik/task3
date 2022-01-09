package framework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import framework.utils.ConfigUtil;
import framework.utils.DriverUtil;
import framework.utils.LoggerUtil;

public abstract class BaseTest {
    private long time;

    @BeforeTest
    public void startTest(){

    }

    @AfterTest
    public void finishTest(){

    }

    @BeforeMethod
    public void startMethod() {
        time=System.currentTimeMillis();
        ConfigUtil.getInstance();
        DriverUtil.getInstance();

    }

    @AfterMethod
    public void endMethod(){
        if (DriverUtil.getWebDriver()!=null) {
            DriverUtil.close();
        }
        LoggerUtil.info(this.getClass(),"Tests completed:" + (System.currentTimeMillis()-time) + "ms");
    }
}
