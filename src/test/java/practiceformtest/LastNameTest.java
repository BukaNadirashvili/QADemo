package practiceformtest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class LastNameTest extends BaseTest {

    public void checkIfUserCanTypeInLastNameField() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.setLastNameField("Doe");
        String field = formsPage.getLastNameField();
        Assert.assertFalse(field.isEmpty(),
                "\n User can't type in Last Name field \n");
    }

    public void checkIfLastNameRequired() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.setLastNameField("Doe");
        formsPage.clickSubmitButton();
        String field = formsPage.getLastNameField();
        Assert.assertFalse(field.isEmpty()
                        && formsPage.checkIfLastNameFieldHasErrorClass(),
                "\n Last Name field is required. \n");
    }

    public void checkIfLastNameHasOnlyLetters() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.setLastNameField("Doe");
        formsPage.clickSubmitButton();
        boolean isAlpha = formsPage.isLastNameAlpha();
        Assert.assertFalse( !isAlpha && formsPage.checkIfLastNameFieldHasErrorClass(),
                "\n Last Name field must contain only letters \n");
    }

    public void checkIfUserCanDeleteLastNameField() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        String text = "Doe";
        formsPage.setLastNameField(text);
        formsPage.deleteLastNameText();
        int fieldLength = formsPage.getLastNameField().length();
        Assert.assertTrue(text.length() > fieldLength,
                "\n User can't delete Last Name field  \n");
    }

    public void checkLastNameMaximumSymbols() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        int maximumCharacters = 15;
        formsPage.setLastNameField("Doe");
        formsPage.clickSubmitButton();
        int fieldLength = formsPage.getLastNameField().length();
        Assert.assertTrue(maximumCharacters >= fieldLength
                        && !formsPage.checkIfLastNameFieldHasErrorClass(),
                "\n Last Name field must be no longer than "
                        + maximumCharacters + " characters \n");
    }

    public void checkLastNameMinimumSymbols() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        int minimumCharacters = 2;
        formsPage.setLastNameField("Doe");
        int fieldLength = formsPage.getLastNameField().length();
        Assert.assertTrue(minimumCharacters <= fieldLength
                        && !formsPage.checkIfLastNameFieldHasErrorClass(),
                "\n Last Name must have at least "
                        + minimumCharacters + " characters \n");
    }

    public void checkLastNameWhiteSpaces() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        String text = "Doe";
        int lengthWithoutWhiteSpaces = text.trim().length();
        formsPage.setLastNameField(text);
        formsPage.clickSubmitButton();
        int fieldLength = formsPage.getLastNameField().length();
        Assert.assertTrue(lengthWithoutWhiteSpaces == fieldLength
                && !formsPage.checkIfLastNameFieldHasErrorClass(),
                "\n Last Name field has extra white spaces \n");
    }

}
