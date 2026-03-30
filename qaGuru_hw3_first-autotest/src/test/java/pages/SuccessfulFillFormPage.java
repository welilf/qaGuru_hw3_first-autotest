package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SuccessfulFillFormPage {

    CalendarComponent calendar = new CalendarComponent();

    // Elements
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmail = $("#userEmail");
    private SelenideElement genderContainer = $("#genterWrapper");
    private SelenideElement userNumber = $("#userNumber");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement dateOfBirth = $("#dateOfBirthInput");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private SelenideElement uploadPicture = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement stateDropdown = $("#state");
    private SelenideElement cityDropdown = $("#city");

    private SelenideElement outputResults = $(".table-responsive");    // Actions

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
        outputResults.
                $$("tr").
                findBy(text(key)).
                shouldHave(text(value));
        return this;
    }
}
