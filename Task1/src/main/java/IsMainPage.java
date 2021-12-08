
import org.openqa.selenium.WebDriver;

public class IsMainPage {
    String mainPage;

    public IsMainPage(String mainPage) {
        this.mainPage = deleteLastSlash(mainPage);
    }
    public boolean isMain(WebDriver driver){
        String curUrl = deleteLastSlash(driver.getCurrentUrl());
        if (curUrl.equals(mainPage)){
            return true;
        }
        return false;
    }
    private String deleteLastSlash(String s){
        if(s.endsWith("/")){
            s = s.substring(0,s.length()-1);
        }
        return s;
    }
}
