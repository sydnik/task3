package utils;



public class AlertUtil {
    public static boolean isAlert(){
        WaitUtil.waitPresentAlert();
        return true;
    }
    public static boolean accept(){
        WaitUtil.waitPresentAlert().accept();
        return true;
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
