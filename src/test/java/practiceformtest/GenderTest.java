package practiceformtest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class GenderTest extends BaseTest {

    public void checkOnlyOneRadioButtonChecked() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickFemaleRadioButton();
        formsPage.clickMaleRadioButton();
        Assert.assertFalse(formsPage.isFemaleSelected(),
                "\n User can check more than one radio button \n");
    }

    public void checkRadioButtonRequired() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickMaleRadioButton();
        formsPage.clickSubmitButton();
        Assert.assertFalse(formsPage.checkIfGenderRadioButtonsHasErrorClass(),
                "\n Gender radio button must be checked \n");
    }

    public void checkRadioButtonLabel() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickFemaleRadioButtonLabel();
        Assert.assertTrue(formsPage.isFemaleSelected(),
                "\n User can click on label, but gender option isn't selected \n");
    }

}