package practiceformtest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class SubjectsTest extends BaseTest {

    public void checkIfSubjectSelected() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.setSubject("History");
        formsPage.clickSubmitButton();
        Assert.assertTrue(formsPage.checkSubjectIsSelected(),
                "\n Subject is required field \n");
    }

    public void checkUserCantSelectSubjectTwice() {
        String subject = "History";
        var formsPage = homePage.goToForms().clickPracticeForm();
        formsPage.setSubject(subject);
        formsPage.setSubject(subject);
        Assert.assertTrue(formsPage.checkOnlyOneSubjectSelected(subject),
                "\n User can select one subject only once \n");
    }

}