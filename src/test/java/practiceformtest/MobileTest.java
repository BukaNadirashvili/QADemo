package practiceformtest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class MobileTest extends BaseTest {

    public void checkIfEmptyMobileAllowed() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.setMobileNumberField("0123456789");
        formsPage.clickSubmitButton();
        Assert.assertFalse(formsPage.checkIfMobileNumberFieldHasErrorClass(),
                "\n Mobile field is required. \n");
    }

    public void checkMobileNumberLength() {
        String mobileNumber = "0123456789";
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.setMobileNumberField(mobileNumber);
        formsPage.clickSubmitButton();
        int fieldLength = formsPage.getMobileNumberField().length();
        Assert.assertTrue(!(fieldLength < 10)
                && !formsPage.checkIfMobileNumberFieldHasErrorClass(),
                "\n Mobile field must have at least 10 digits \n");
    }

    public void checkIfMobileNumberHasOnlyDigits() {
        String mobileNumber = "1111111111";
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.setMobileNumberField(mobileNumber);
        formsPage.clickSubmitButton();
        Assert.assertTrue(formsPage.isMobileContainsOnlyDigits()
                && !formsPage.checkIfMobileNumberFieldHasErrorClass(),
                "\n Mobile number must have only digits \n");
    }

}
