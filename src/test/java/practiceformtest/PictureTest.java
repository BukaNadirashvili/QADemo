package practiceformtest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

@Test
public class PictureTest extends BaseTest {

    public void checkFileType() {
        var formsPage = homePage.goToForms().clickPracticeForm();
        File uploadFile = new File("resources/files/nature.jpg");
        formsPage.uploadPicture(uploadFile);
        formsPage.clickSubmitButton();
        Assert.assertTrue(formsPage.isFileImageType(),
                "\n File must be image \n");
    }

}
