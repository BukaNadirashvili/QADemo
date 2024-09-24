package practiceformtest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class AddressTest extends BaseTest {

    public void checkIfUserCanTypeInAddressField() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.setAddressField("Address");
        Assert.assertFalse(formsPage.getAddressField().isEmpty(),
                "\n User can't type in address field \n");
    }

    public void checkAddressMaximumSymbols() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        int maximumCharacters = 15;
        formsPage.setAddressField("Address");
        int fieldLength = formsPage.getAddressField().length();
        Assert.assertTrue(maximumCharacters >= fieldLength,
                "\n Address must be no longer than"
                        + maximumCharacters + " characters \n");
    }

    public void checkAddressMinimumSymbols() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        int minimumCharacters = 2;
        formsPage.setAddressField("Address");
        int fieldLength = formsPage.getAddressField().length();
        Assert.assertTrue(minimumCharacters <= fieldLength,
                "\n Address must have at least "
                + minimumCharacters + " characters \n");

    }

}