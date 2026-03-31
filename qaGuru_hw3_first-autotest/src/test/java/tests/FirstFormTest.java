package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.SuccessfulFillFormPage;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstFormTest {

    String firstName;
    String lastName;
    String userEmail;
    String gender;
    String userNumber;
    String dayOfBirth;
    String monthOfBirth;
    String yearOfBirth;
    String subject;
    String hobbie;
    String picture;
    String currentAddress;
    String state;
    String city;

    @BeforeAll
    static void setUpConfig() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successfulFillFormTest_dsl() {
        firstName = "Jane";
        lastName = "Austen";
        userEmail = "mrsAusten@icloud.com";
        gender = "Male";
        userNumber = "8999999999";
        dayOfBirth = "15";
        monthOfBirth = "May";
        yearOfBirth = "1995";
        subject = "Maths";
        hobbie = "Reading";
        picture = "cat.png";
        currentAddress = "groove street, 33";
        state = "NCR";
        city = "Delhi";

        SuccessfulFillFormPage successfulFillFormPage = new SuccessfulFillFormPage();

        successfulFillFormPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .setGender(gender)
                .typeUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .setHobby(hobbie)
                .uploadPicture(picture)
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submitForm();

        successfulFillFormPage
                .checkField("Student Name", firstName + " " + lastName)
                .checkField("Student Email", userEmail)
                .checkField("Gender", gender)
                .checkField("Mobile", userNumber)
                .checkField("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkField("Subjects", subject)
                .checkField("Hobbies", hobbie)
                .checkField("Picture", picture)
                .checkField("Address", currentAddress)
                .checkField("State and City", state + " " + city);
    }
}
