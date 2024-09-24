package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtility extends Utility {

    private static Select findDropDown(By locator) {
        return new Select(driver.findElement(locator));
    }

    public static void selectByVisibleText(By locator, String text) {
        findDropDown(locator).selectByVisibleText(text);
    }

}
