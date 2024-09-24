package practiceformtest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class EmailTest extends BaseTest {

    public void checkIfEmailRequired() {
        String email = "test@test.com";
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.setEmailField(email);
        String emailFieldValue = formsPage.getEmailField();
        formsPage.clickSubmitButton();

        Assert.assertTrue(!emailFieldValue.isEmpty() &&
                        !formsPage.checkIfEmailFieldHasErrorClass(),
                "\n Email field is required. \n");
    }

    public void checkEmailField() {
        String email = "test@test.com";
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.setEmailField(email);
        formsPage.clickSubmitButton();
        String emailFieldValue = formsPage.getEmailField();
        Assert.assertTrue(formsPage.validateEmail(emailFieldValue)
                && !formsPage.checkIfEmailFieldHasErrorClass(),
                "\n Incorrect email address \n");
    }

}