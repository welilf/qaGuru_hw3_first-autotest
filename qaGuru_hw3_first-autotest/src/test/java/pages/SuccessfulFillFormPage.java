package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SuccessfulFillFormPage {

    CalendarComponent calendar = new CalendarComponent();
    ResultTableComponent resultsTable = new ResultTableComponent();

    // Elements
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmail = $("#userEmail");
    private final SelenideElement genderContainer = $("#genterWrapper");
    private final SelenideElement userNumber = $("#userNumber");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement dateOfBirth = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateDropdown = $("#state");
    private final SelenideElement cityDropdown = $("#city");

    // Actions

    public SuccessfulFillFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public SuccessfulFillFormPage typeFirstName (String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public SuccessfulFillFormPage typeLastName (String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public SuccessfulFillFormPage typeUserEmail (String value) {
        userEmail.setValue(value);
        return this;
    }

    public SuccessfulFillFormPage setGender (String value) {
        genderContainer.$(byText(value)).click();
        return this;
    }

    public SuccessfulFillFormPage typeUserNumber (String value) {
        userNumber.setValue(value);
        return this;
    }

    public SuccessfulFillFormPage setDateOfBirth (String day, String month, String year) {
        dateOfBirth.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public SuccessfulFillFormPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public SuccessfulFillFormPage setHobby(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public SuccessfulFillFormPage uploadPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    public SuccessfulFillFormPage setAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public SuccessfulFillFormPage setState(String value) {
        stateDropdown.scrollIntoView(true).click();
        $("#react-select-3-input").setValue(value).pressEnter();
        return this;
    }

    public SuccessfulFillFormPage setCity(String value) {
        cityDropdown.click();
        $("#react-select-4-input").setValue(value).pressEnter();
        return this;
    }

    public SuccessfulFillFormPage submitForm() {
        submitButton.click();
        return this;
    }

    public SuccessfulFillFormPage checkField (String key, String value) {
        resultsTable.checkField(key, value);
        return this;
    }
}
