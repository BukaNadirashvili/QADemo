package utilities;

import com.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class Utility {

    public static WebDriver driver;

    public static void setUtilityDriver() {
        driver = BasePage.driver;
    }

    public static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public static boolean containsOnlyDigits(String number) {
        return number.matches("[0-9]+");
    }

    public static boolean isFileImage(String fileName) {
        String fileExtension = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            fileExtension = fileName.substring(i + 1);
        }
        String[] imageExtensions = {"jpg", "jpeg", "png"};
        for(String extension : imageExtensions) {
            if(fileExtension.equals(extension)) {
                return true;
            }
        }
        return false;
    }

}