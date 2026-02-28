import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class firstAutotestForForm {

    @BeforeAll
    static void setup() {
        Configuration.holdBrowserOpen = true;  // браузер не закрывается после теста
    }

    @Test
    void successfulFillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Jane");
        $("[id=lastName]").setValue("Austen");
        $("[id=userEmail]").setValue("mrsAusten@icloud.com");
        $("[for='gender-radio-1']").click();
        $("[id=userNumber]").setValue("8999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--015").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("[for='hobbies-checkbox-2']").click();
        $("[id=uploadPicture]").uploadFromClasspath("cat.png");
        $("[id=currentAddress]").setValue("groove street, 33");
        $("#state").scrollIntoView(true);
        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();

        $$(".table-responsive tr").findBy(text("Student Name")).shouldHave(text("Jane Austen"));
        $$(".table-responsive tr").findBy(text("Student Email")).shouldHave(text("mrsAusten@icloud.com"));
        $$(".table-responsive tr").findBy(text("Gender")).shouldHave(text("Male"));
        $$(".table-responsive tr").findBy(text("Mobile")).shouldHave(text("8999999999"));
        $$(".table-responsive tr").findBy(text("Date of Birth")).shouldHave(text("15 May,1995"));
        $$(".table-responsive tr").findBy(text("Subjects")).shouldHave(text("Maths"));
        $$(".table-responsive tr").findBy(text("Hobbies")).shouldHave(text("Reading"));
        $$(".table-responsive tr").findBy(text("Picture")).shouldHave(text("cat.png"));
        $$(".table-responsive tr").findBy(text("Address")).shouldHave(text("groove street, 33"));
        $$(".table-responsive tr").findBy(text("State and City")).shouldHave(text("NCR Delhi"));
    }
}
