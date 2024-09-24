package practiceformtest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class DateOfBirthTest extends BaseTest {

    public void checkUserAge() {
        String month = "September";
        String day = "21";
        String year = "2005";
        int minimumAge = 18;
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickDateOfBirthField();
        formsPage.selectMonth(month);
        formsPage.selectYear(year);
        formsPage.clickDay(day);

        formsPage.clickSubmitButton();
        String date = formsPage.getDateOfBirthField();
        Assert.assertTrue(formsPage.checkMinAge(date, minimumAge),
                "\n User must be at least" + minimumAge + "years old \n");
    }

}