import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
    void successfulFillFormTest() {
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

        open("/automation-practice-form");
        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("[id=userNumber]").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbie)).click();
        $("[id=uploadPicture]").uploadFromClasspath(picture);
        $("[id=currentAddress]").setValue(currentAddress);
        $("#state").scrollIntoView(true);
        $("#state").click();
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue(city).pressEnter();

        $("#submit").click();

        $$(".table-responsive tr").findBy(text("Student Name")).shouldHave(text(firstName + " " + lastName));
        $$(".table-responsive tr").findBy(text("Student Email")).shouldHave(text(userEmail));
        $$(".table-responsive tr").findBy(text("Gender")).shouldHave(text(gender));
        $$(".table-responsive tr").findBy(text("Mobile")).shouldHave(text(userNumber));
        $$(".table-responsive tr").findBy(text("Date of Birth")).shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $$(".table-responsive tr").findBy(text("Subjects")).shouldHave(text(subject));
        $$(".table-responsive tr").findBy(text("Hobbies")).shouldHave(text(hobbie));
        $$(".table-responsive tr").findBy(text("Picture")).shouldHave(text(picture));
        $$(".table-responsive tr").findBy(text("Address")).shouldHave(text(currentAddress));
        $$(".table-responsive tr").findBy(text("State and City")).shouldHave(text(state + " " + city));
    }
}
