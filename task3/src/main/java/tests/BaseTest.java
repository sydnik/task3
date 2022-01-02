package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import utils.ConfigUtil;
import utils.DriverUtil;

public abstract class BaseTest {
    @BeforeMethod
    public void startTests() {
        ConfigUtil.getInstance();
        DriverUtil.getInstance();
    }

    @AfterMethod
    public void endTests(){
        if (DriverUtil.getWebDriver()!=null) {
            DriverUtil.close();
        }
    }
}
