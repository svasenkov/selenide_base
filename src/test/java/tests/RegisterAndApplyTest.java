package tests;

import helpers.TestBase;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.RegisterPage;

import static pages.BasePage.openUrl;
import static utils.RandomUtils.getRamdomEmail;
import static utils.RandomUtils.getRandomString;


@Story("Register user and apply job (GUI)")
public class RegisterAndApplyTest extends TestBase {


    @Test( description = "Registration")
    public void test00_registerUser() {
        openUrl("/app/auth/registration");
        new RegisterPage()
                .typeFirstName(getRandomString(10))
                .typeLastName(getRandomString(10))
                .typeEmail(getRamdomEmail())
                .typePassword(getRandomString(10))
                .clickRegisterButton();
    }

//    @Test( description = "Успешная авторизация",
//            dependsOnMethods = {"test00_openLoginPage"})
//    public void test01_succeedAuthorization() {
//        new RegisterPage().typeLogin(login)
//                .typePassword(password)
//                .clickLoginButton()
//                .verifyIsLoginned();
//    }
//
//    @Test( description = "Успешный логаут",
//            dependsOnMethods = {"test01_succeedAuthorization"})
//    public void test02_succeedLogout() {
//        openUrl(url + "/profile");
//
//        new MenuBlock().logout()
//                .verifyIsNotLoginned();
//    }
//
//    @Test( description = "Неуспешная авторизация")
//    public void test03_wrongAuthorization() {
//        new RegisterPage().typeLogin(login)
//                .typePassword(password + "1")
//                .clickLoginButton();
//
//        new RegisterPage().verifyWrongAuthorization();
//    }

//    Coding
//    Need to write automation tests for wep app to cover next cases:
//    Go to https://staging.jobtoday.com/app/auth/registration  (basic auth: jobtoday / jobtoday)
//    Go to https://jobtoday:jobtoday@staging.jobtoday.com/app/auth/registration  (basic auth: jobtoday / jobtoday)
//    Fill the “First Name”, “Last Name”, “Email” and “Password” fields
//    Click “Create an account” button
//    Navigate to https://staging.jobtoday.com/gb/job/fitness-instructor-JvDzE4
//    Click “Apply now” button
//    Click “I do not have work experience” button
//    Put some random text to “Your story” field
//    Click “Next” button
//    Choose “language” and “level”
//    Click “next” button
//    Click “later” button on “Ready to upload your photo” step
//
//    Please send link to github project as an answer

}
