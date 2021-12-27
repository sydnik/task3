package tests;

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

    @AfterTest
    public void endTests(){
        if (DriverUtil.getWebDriver()!=null) {
            DriverUtil.getWebDriver().quit();
        }
    }
}
