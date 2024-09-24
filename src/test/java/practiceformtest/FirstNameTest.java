package practiceformtest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class FirstNameTest extends BaseTest {

    public void checkIfUserCanTypeInFirstNameField() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.setFirstNameField("John");
        String field = formsPage.getFirstNameField();
        Assert.assertFalse(field.isEmpty(),
                "\n User can't type in First Name field \n");
    }

    public void checkFirstNameRequired() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.setFirstNameField("John");
        formsPage.clickSubmitButton();
        String field = formsPage.getFirstNameField();
        Assert.assertFalse(field.isEmpty()
                        && formsPage.checkIfFirstNameFieldHasErrorClass(),
                "\n First Name field is required. \n");
    }

    public void checkIfFirstNameHasOnlyLetters() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.setFirstNameField("12345");
        formsPage.clickSubmitButton();
        boolean isAlpha = formsPage.isFirstNameAlpha();
        Assert.assertFalse(!isAlpha && formsPage.checkIfFirstNameFieldHasErrorClass(),
                "\n First Name field must contain only letters \n");
    }

    public void checkIfUserCanDeleteFirstNameField() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        String text = "John";
        formsPage.setFirstNameField(text);
        formsPage.deleteFirstNameText();
        int fieldLength = formsPage.getFirstNameField().length();
        Assert.assertTrue(text.length() > fieldLength,
                "\n User can't delete First Name field  \n");
    }

    public void checkFirstNameMaximumSymbols() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        int maximumCharacters = 15;
        formsPage.setFirstNameField("JohnJohnJohnJoh");
        formsPage.clickSubmitButton();
        int fieldLength = formsPage.getFirstNameField().length();
        Assert.assertTrue(maximumCharacters >= fieldLength
                        && !formsPage.checkIfFirstNameFieldHasErrorClass(),
                "\n First Name field must be no longer than "
                        + maximumCharacters + " characters \n");
    }

    public void checkFirstNameMinimumSymbols() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        int minimumCharacters = 2;
        formsPage.setFirstNameField("John");
        int fieldLength = formsPage.getFirstNameField().length();
        Assert.assertTrue(minimumCharacters <= fieldLength
                        && !formsPage.checkIfFirstNameFieldHasErrorClass(),
                "\n First Name must have at least "
                        + minimumCharacters + " characters \n");
    }

    public void checkFirstNameWhiteSpaces() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        String text = "John";
        int lengthWithoutWhiteSpaces = text.trim().length();
        formsPage.setFirstNameField(text);
        formsPage.clickSubmitButton();
        int fieldLength = formsPage.getFirstNameField().length();
        Assert.assertTrue(lengthWithoutWhiteSpaces == fieldLength
                && !formsPage.checkIfFirstNameFieldHasErrorClass(),
                "\n First Name field has extra white spaces \n");
    }

}