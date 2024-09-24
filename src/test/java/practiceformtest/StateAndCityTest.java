package practiceformtest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class StateAndCityTest extends BaseTest {

    public void checkIfCityDisabled() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        Assert.assertTrue(formsPage.checkIfCityFieldDisabled(),
                "\n If state isn't selected city must be disabled field \n");
    }

    public void checkExpectedCities() throws InterruptedException {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.setStateField("NCR");
        Thread.sleep(2000);
        formsPage.clickCityField();
        String[] expectedCities = {
                "Delhi",
                "Gurgaon",
                "Noida"
        };
        Assert.assertTrue(formsPage.checkCities(expectedCities),
                "\n Cities must be according to the state field \n");
    }

}