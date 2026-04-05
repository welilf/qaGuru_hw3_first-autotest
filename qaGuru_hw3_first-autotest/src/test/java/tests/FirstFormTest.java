package tests;

import com.codeborne.selenide.Configuration;
import data.TestData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.SuccessfulFillFormPage;

public class FirstFormTest {

    @BeforeAll
    static void setUpConfig() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successfulFillFormTest_dsl() {

        SuccessfulFillFormPage successfulFillFormPage = new SuccessfulFillFormPage();
        TestData data = new TestData();

        successfulFillFormPage
                .openPage()
                .typeFirstName(data.firstName)
                .typeLastName(data.lastName)
                .typeUserEmail(data.userEmail)
                .setGender(data.gender)
                .typeUserNumber(data.userNumber)
                .setDateOfBirth(data.dayOfBirth, data.monthOfBirth, data.yearOfBirth)
                .setSubject(data.subject)
                .setHobby(data.hobbie)
                .uploadPicture(data.picture)
                .setAddress(data.currentAddress)
                .setState(data.state)
                .setCity(data.city)
                .submitForm();

        successfulFillFormPage
                .checkField("Student Name", data.firstName + " " + data.lastName)
                .checkField("Student Email", data.userEmail)
                .checkField("Gender", data.gender)
                .checkField("Mobile", data.userNumber)
                .checkField("Date of Birth", data.dayOfBirth + " " + data.monthOfBirth + "," + data.yearOfBirth)
                .checkField("Subjects", data.subject)
                .checkField("Hobbies", data.hobbie)
                .checkField("Picture", data.picture)
                .checkField("Address", data.currentAddress)
                .checkField("State and City", data.state + " " + data.city);
    }
}
