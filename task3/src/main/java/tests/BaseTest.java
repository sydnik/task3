package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import utils.ConfigUtil;
import utils.DriverUtil;

public abstract class BaseTest {
    protected ConfigUtil configUtil;
    @BeforeMethod
    public void startTests() {
        if( ConfigUtil.getInstance()==null){
            throw new RuntimeException();
        }
        configUtil= ConfigUtil.getInstance();
    }

    @AfterTest
    public void endTests(){
        if (DriverUtil.getInstance().getWebDriver()!=null) {
            DriverUtil.getInstance().getWebDriver().quit();
        }
    }
}
