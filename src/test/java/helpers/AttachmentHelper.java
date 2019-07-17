package helpers;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

import static helpers.EnvHelper.*;
import static helpers.SelenideHelper.getConsoleLogs;
import static utils.FilesUtils.readBytesFromFile;
import static utils.FilesUtils.saveFile;

public class AttachmentHelper {

    static Logger logger = LoggerFactory.getLogger(AttachmentHelper.class);

    public static void attachBrowserConsoleLogs() {
        attachAsText("Browser console logs", getConsoleLogs());
    }

    public static void attachCiInfoToReport() {
       saveFile(getEnvPropertiesForAllure(), ALLURE_ENV_PROPERTIES_LOCATION);
    }

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    @Attachment(value = "{attachName}", type = "application/json")
    public static String attachAsJson(String attachName, String message) {
        return message;
    }

    @Attachment(value = "{attachName}", type = "text/html")
    public static String attachAsHtml(String attachName, String message) {
        return message;
    }

    @Attachment(value = "{attachName}", fileExtension = ".xlsx")
    public static byte[] attachAsXlsxFile(String attachName, String filePath) {
        return readBytesFromFile(filePath);
    }

    @Attachment(value = "{attachName}", fileExtension = ".csv")
    public static byte[] attachAsCsvFile(String attachName, String filePath) {
        return readBytesFromFile(filePath);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String attachVideo(String sessionId) {
        URL url = null;
        try {
            url = new URL(selenoid_video_url + "/video/" + sessionId + ".mp4");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + url
                + "' type='video/mp4'></video></body></html>";
    }
}
