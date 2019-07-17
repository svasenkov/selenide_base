package helpers;

import io.qameta.allure.Step;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.sleep;
import static helpers.AttachmentHelper.attachBrowserConsoleLogs;
import static helpers.EnvHelper.loadEnvironment;
import static helpers.SelenideHelper.configureSelenide;
import static helpers.SelenideHelper.getConsoleLogs;
import static org.testng.Assert.assertFalse;

@Listeners(TestsListener.class)
public class TestBase {

    @BeforeSuite
    @Step("Setup test environment for UI tests")
    public void setUp() {
        loadEnvironment();
        configureSelenide();
    }

    @AfterTest(alwaysRun = true)
    @Step("Verify no errors in browser console")
    public void verifyNoConsoleErrors(){
        String consoleText = getConsoleLogs();
        attachBrowserConsoleLogs();
        assertFalse(consoleText.contains("SEVERE"), consoleText);
    }

    @AfterSuite(alwaysRun = true)
    public void closeBrowser(){
        AttachmentHelper.attachCiInfoToReport();
        close();
    }
}



