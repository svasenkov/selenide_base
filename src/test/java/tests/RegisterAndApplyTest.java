package tests;

import helpers.TestBase;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.JobPage;
import pages.RegisterPage;

import static pages.BasePage.openUrl;
import static utils.RandomUtils.*;


@Story("Register user and apply job (GUI)")
public class RegisterAndApplyTest extends TestBase {

    @Test( description = "Registration step")
    public void test00_registerUser() {
        openUrl("/app/auth/registration");
        new RegisterPage()
                .typeFirstName(getRandomString(10))
                .typeLastName(getRandomString(10))
                .typeEmail(getRamdomEmail())
                .typePassword(getRandomString(10))
                .clickRegisterButton()
        .verifyIsLoggedIn();
    }

    @Test( description = "Apply job test",
            dependsOnMethods = {"test00_registerUser"})
    public void test01_applyJob() {
        openUrl("/gb/job/fitness-instructor-JvDzE4");
        new JobPage().clickApplyJobButton()
                .clickNoExperienceButton()
                .typeStory(getRandomMessage(10, 20))
                .clickNextButton()
                .selectLanguage("English")
                .selectLanguageLevel("Native")
                .clickNextButton()
                .clickLaterButton();

        new JobPage().verifyJobApplied();
    }
}
