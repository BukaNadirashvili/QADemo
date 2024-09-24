package com.pages.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static utilities.DropDownUtility.selectByVisibleText;
import static utilities.JavaScriptUtility.*;

public class PracticeFormPage extends FormsPage {

    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("userEmail");
    private By maleRadioButton = By.id("gender-radio-1");
    private By femaleRadioButton = By.id("gender-radio-2");
    private By femaleRadioButtonLabel = By.xpath("//label[@for='gender-radio-2'][text()='Female']");
    private By genderRadioButtonInputs = By.xpath("//input[@type='radio'][@name='gender']");
    private By mobileNumberField = By.id("userNumber");
    private By dateOfBirthField = By.id("dateOfBirthInput");
    private By monthDropDown = By.className("react-datepicker__month-select");
    private By yearDropDown = By.className("react-datepicker__year-select");
    private By selectedSubjects = By.className("subjects-auto-complete__multi-value");
    private By hobbiesCheckboxes = By.xpath("//input[starts-with(@id, 'hobbies-checkbox-')]");
    private By hobbiesLabels = By.xpath("//label[starts-with(@for, 'hobbies-checkbox-')]");
    private By pictureInput = By.id("uploadPicture");
    private By subjectsInput = By.id("subjectsInput");
    private By addressField = By.id("currentAddress");
    private By stateInputField = By.id("react-select-3-input");
    private By cityInputField = By.id("react-select-4-input");
    private By listOfCities = By.xpath("//div[starts-with(@id, 'react-select-4-option-')]");

    private By submitButton = By.id("submit");

    //region FirstName

    public void setFirstNameField(String text) {
        setText(firstNameField, text);
    }

    public String getFirstNameField() {
        return getInputText(firstNameField);
    }

    public void deleteFirstNameText() {
        find(firstNameField).sendKeys(Keys.BACK_SPACE);
    }

    public boolean checkIfFirstNameFieldHasErrorClass() {
        return !driver.findElements(By.cssSelector("#firstName.form-control:invalid"))
                .isEmpty();
    }

    public boolean isFirstNameAlpha() {
        return isAlpha(getFirstNameField());
    }

    //endregion

    //region LastName

    public void setLastNameField(String text) {
        setText(lastNameField, text);
    }

    public String getLastNameField() {
        return getInputText(lastNameField);
    }

    public void deleteLastNameText() {
        find(lastNameField).sendKeys(Keys.BACK_SPACE);
    }

    public boolean checkIfLastNameFieldHasErrorClass() {
        return !driver.findElements(By.cssSelector("#lastName.form-control:invalid"))
                .isEmpty();
    }

    public boolean isLastNameAlpha() {
        return isAlpha(getLastNameField());
    }

    //endregion

    //region Email

    public void setEmailField(String email) {
        setText(emailField, email);
    }

    public String getEmailField() {
        return getInputText(emailField);
    }

    public boolean checkIfEmailFieldHasErrorClass() {
        return !driver.findElements(By.cssSelector("#userEmail.form-control:invalid"))
                .isEmpty();
    }

    public boolean validateEmail(String email) {
        Matcher matcher = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE).matcher(email);
        return matcher.matches();
    }

    //endregion

    //region Gender

    public boolean checkIfGenderRadioButtonsHasErrorClass() {
        List<WebElement> radioButtonLabels = findWebElements(genderRadioButtonInputs);

        for (WebElement label : radioButtonLabels) {
            if(driver.findElements(By.cssSelector("#" + label.getAttribute("id") + ".custom-control-input:invalid"))
                    .isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public void clickMaleRadioButton() {
        scrollToElementJS(maleRadioButton);
        clickJS(maleRadioButton);
    }

    public void clickFemaleRadioButton() {
        scrollToElementJS(femaleRadioButton);
        clickJS(femaleRadioButton);
    }
    public void clickFemaleRadioButtonLabel() {
        scrollToElementJS(femaleRadioButtonLabel);
        clickJS(femaleRadioButtonLabel);
    }

    public boolean isFemaleSelected() {
        return find(femaleRadioButton).isSelected();
    }

    //endregion

    //region MobileNumber

    public void setMobileNumberField(String mobileNumber) {
        setText(mobileNumberField, mobileNumber);
    }

    public String getMobileNumberField() {
        return getInputText(mobileNumberField);
    }

    public boolean checkIfMobileNumberFieldHasErrorClass() {
        return !driver.findElements(By.cssSelector("#userNumber.form-control:invalid"))
                .isEmpty();
    }

    public boolean isMobileContainsOnlyDigits() {
        return containsOnlyDigits(getMobileNumberField());
    }

    //endregion

    //region DateOfBirth

    public String getDateOfBirthField() {
        return getInputText(dateOfBirthField);
    }

    public void clickDateOfBirthField() {
        click(dateOfBirthField);
    }

    public void selectMonth(String month) {
        selectByVisibleText(monthDropDown, month);
    }

    public void selectYear(String year) {
        selectByVisibleText(yearDropDown, year);
    }

    private By dayValue(String day) {
        return By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day--')][text()='"+ day +"']");
    }

    public void clickDay(String day) {
        clickJS(dayValue(day));
    }

    public boolean checkMinAge(String date, int minAge) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy");
        LocalDate newDate = LocalDate.parse(date, formatter);
        int years = Period.between(newDate, LocalDate.now()).getYears();
        return years >= minAge;
    }

    //endregion

    //region Subjects

    public void setSubject(String text) {
        setText(subjectsInput, text);
        delay(2000);
        find(subjectsInput).sendKeys(Keys.ENTER);
    }

    public boolean checkSubjectIsSelected() {
        return !findWebElements(selectedSubjects).isEmpty();
    }

    public boolean checkOnlyOneSubjectSelected(String subject) {
        return findWebElements(
                By.xpath("//div[@id='subjectsContainer']//div[contains(@class, 'label')" +
                        "and text() ='" + subject + "']")
        ).size() == 1;
    }

    //endregion

    //region Hobbies

    public void checkAllHobbiesCheckboxes() {
        List<WebElement> listOfHobbiesCheckboxes = findWebElements(hobbiesCheckboxes);

        for(WebElement hobbieCheckbox : listOfHobbiesCheckboxes) {
            clickJS(hobbieCheckbox);
        }
    }

    public void clickAllHobbiesLabels() {
        List<WebElement> listOfHobbieLabels = findWebElements(hobbiesLabels);

        for(WebElement hobbieLabel : listOfHobbieLabels) {
            clickJS(hobbieLabel);
        }

    }

    public void uncheckAllHobbiesCheckboxes() {
        List<WebElement> listOfHobbiesCheckboxes = findWebElements(hobbiesCheckboxes);

        for(WebElement hobbieCheckbox : listOfHobbiesCheckboxes) {
            if(hobbieCheckbox.isSelected()) {
                clickJS(hobbieCheckbox);
            }
        }

    }

    public boolean areAllHobbiesCheckboxesChecked() {
        List<WebElement> listOfHobbiesCheckboxes = findWebElements(hobbiesCheckboxes);

        for(WebElement hobbieCheckbox : listOfHobbiesCheckboxes) {
            if(!hobbieCheckbox.isSelected()) {
                return false;
            }
        }

        return true;
    }

    public boolean areAllHobbiesCheckboxesUnchecked() {
        List<WebElement> listOfHobbiesCheckboxes = findWebElements(hobbiesCheckboxes);

        for(WebElement hobbieCheckbox : listOfHobbiesCheckboxes) {
            if(hobbieCheckbox.isSelected()) {
                return false;
            }
        }

        return true;
    }

    //endregion

    //region Picture

    public void uploadPicture(File uploadFile) {
        WebElement fileInput = driver.findElement(pictureInput);
        fileInput.sendKeys(uploadFile.getAbsolutePath());
    }

    public String getPictureName() {
        scrollToElementJS(pictureInput);
        return getFileInputExtension("uploadPicture");
    }

    public boolean isFileImageType() {
        return isFileImage(getPictureName());
    }

    //endregion

    //region Address

    public void setAddressField(String address) {
        scrollToElementJS(addressField);
        setText(addressField, address);
    }

    public String getAddressField() {
        return getInputText(addressField);
    }

    //endregion

    //region StateAndCity

    public void setStateField(String text) {
        scrollToElementJS(stateInputField);
        setText(stateInputField, text);
        find(stateInputField).sendKeys(Keys.ENTER);
    }

    public String getStateField() {
        return getInputText(stateInputField);
    }

    public void clickCityField() {
        find(By.id("city")).click();
    }

    public boolean checkIfCityFieldDisabled() {
        return getStateField().isEmpty()
                && !find(cityInputField).getAttribute("disabled").isEmpty();
    }

    public boolean checkCities(String[] expectedCities) {
        List<WebElement> cities = findWebElements(listOfCities);

        for(String expectedCity : expectedCities) {
            if(cities.stream().noneMatch(city -> city.getText().equals(expectedCity))) {
                return false;
            }
        }

        return true;
    }

    //endregion

    public void clickSubmitButton() {
        clickJS(submitButton);
    }

}