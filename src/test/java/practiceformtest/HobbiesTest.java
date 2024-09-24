package practiceformtest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class HobbiesTest extends BaseTest {

    public void checkAllHobbiesCheckboxes() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.checkAllHobbiesCheckboxes();
        Assert.assertTrue(formsPage.areAllHobbiesCheckboxesChecked(),
                "\n User can't check all hobbies checkboxes \n");
    }

    public void uncheckAllHobbiesCheckboxes() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.checkAllHobbiesCheckboxes();
        formsPage.uncheckAllHobbiesCheckboxes();
        Assert.assertTrue(formsPage.areAllHobbiesCheckboxesUnchecked(),
                "\n User can't uncheck all hobbies checkboxes \n");
    }

    public void checkAllHobbiesLabels() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.clickAllHobbiesLabels();
        Assert.assertTrue(formsPage.areAllHobbiesCheckboxesChecked(),
                "\n User can click labels, but hobbies are not selected \n");
    }

}