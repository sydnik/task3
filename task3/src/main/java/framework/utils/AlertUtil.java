package framework.utils;



public class AlertUtil {
    public static boolean isAlert(){
        WaitUtil.waitPresentAlert();
        return true;
    }
    public static void accept(){
        WaitUtil.waitPresentAlert().accept();
    }
    public static String getText(){
        return WaitUtil.waitPresentAlert().getText();

    }
    public static void sendKeys(String line){
        WaitUtil.waitPresentAlert().sendKeys(line);
    }
    public static boolean isAlertClosed(){
        return WaitUtil.waitUnPresentAlert();
    }
}
