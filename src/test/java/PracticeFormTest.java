import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 4000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Alexeev");
        $("#userEmail").setValue("alex@egorov.com");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("98762837465");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("July")).click();
        $(".react-datepicker__year-select").$(byText("2024")).click();
        $(".react-datepicker__day--012:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("krasiv.jpg");
        $("#currentAddress").setValue("street 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();
        $("#submit").click();
        $(".table-responsive").shouldHave(text("Alex Alexeev"));
        $(".table-responsive").shouldHave(text("alex@egorov.com"));
        $(".table-responsive").shouldHave(text("Other"));
        $(".table-responsive").shouldHave(text("9876283746"));
        $(".table-responsive").shouldHave(text("12 July,2024"));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text("krasiv.jpg"));
        $(".table-responsive").shouldHave(text("street 1"));
        $(".table-responsive").shouldHave(text("Haryana Panipat"));

    }


}