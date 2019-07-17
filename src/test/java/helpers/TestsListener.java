package helpers;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.VideoUtils;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted;
import static helpers.AttachmentHelper.*;
import static helpers.EnvHelper.*;
import static pages.BasePage.openUrl;


public class TestsListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if(hasWebDriverStarted()) {
            attachScreenshot();
            attachBrowserConsoleLogs();
        }

// todo: video record is always enabled for presentation, should be disabled for production
//        if (isSelenoid && isVideoOn) {
//            addVideoToRemove();
//        }

        if (isSelenoid && isVideoOn) {
            attachVideo(VideoUtils.getVideoFilename());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if(hasWebDriverStarted()) {
            attachScreenshot();
            attachBrowserConsoleLogs();
        }

        if (isSelenoid && isVideoOn) {
            attachVideo(VideoUtils.getVideoFilename());
        }

        close();
        openUrl(url);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        attachScreenshot();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {

    }

}
