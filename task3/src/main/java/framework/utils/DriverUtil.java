package framework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class DriverUtil {
    private WebDriver webDriver;
    private static DriverUtil driverUtils;
    private static Set<String> tabAndWindow;

    private DriverUtil(){
    }

    public static WebDriver getWebDriver() {
        return getInstance().webDriver;
    }

    public static DriverUtil getInstance(){
        if(driverUtils!=null) {
            if(driverUtils.webDriver!=null) {
                return driverUtils;
            }
        }
        driverUtils = new DriverUtil();
        driverUtils.webDriver = BrowserFactory.getBrowser(ConfigUtil.getConfProperty("browser"));
        return driverUtils;
    }

    public static String getCurrentUrl(){
        return getInstance().webDriver.getCurrentUrl();
    }
    public static int getNumberOfWindow(){
        return getInstance().webDriver.getWindowHandles().size();
    }
    public static void openURL(String url){
        getInstance().webDriver.get(url);
    }
    public static String getCurrentWindow(){
        return getInstance().webDriver.getWindowHandle();
    }
    public static void switchToFrame(By by){
        getInstance().webDriver.switchTo().frame(WaitUtil.waitPresence(by));
    }
    public static void switchToFrame(String frame){
        getInstance().webDriver.switchTo().window(frame);
    }
    public static void saveCurrentWindows(){
        tabAndWindow = getInstance().webDriver.getWindowHandles();
    }
    public static void openNewWindow(){
        Set<String> tabs =  getInstance().webDriver.getWindowHandles();
        for (String s : tabs) {
            if(!tabAndWindow.contains(s)){
                getInstance().webDriver.switchTo().window(s);
            }
        }
    }
    public static void waitAndOpenNewWindow(){
        WaitUtil.waitNewWindow(tabAndWindow.size()+1);
        Set<String> tabs =  getInstance().webDriver.getWindowHandles();
        for (String s : tabs) {
            if(!tabAndWindow.contains(s)){
                getInstance().webDriver.switchTo().window(s);
            }
        }
    }
    public static void openAvailableWindow(){
        for (String s : getInstance().webDriver.getWindowHandles()){
            getInstance().webDriver.switchTo().window(s);
            break;
        }
    }
    public static void closeTab(){
        getInstance().webDriver.close();
    }
    public static void close(){
        getInstance().webDriver.quit();
        driverUtils=null;
    }

}
