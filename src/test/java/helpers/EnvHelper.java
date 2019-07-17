package helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Boolean.parseBoolean;

public class EnvHelper {
    static Logger logger = LoggerFactory.getLogger(EnvHelper.class);

    public static final String
            ALLURE_ENV_PROPERTIES_LOCATION = "build/allure-results/environment.properties";

    public static String
            url,
            login,
            password,
            language,
            browser,
            selenoid_video_url;

    public static boolean
            isHeadless,
            isSelenoid,
            isVideoOn;
    private static String
            defaultIsHeadless = "false",
            defaultIsSelenoid = "false",
            defaultIsVideo = "false";

    public static void loadEnvironment() {
        url = "https://" + System.getProperty("url");
        login = System.getProperty("login");
        password = System.getProperty("password");
        language = System.getProperty("language");

        browser = System.getProperty("browser");
        isHeadless = parseBoolean(System.getProperty("headless", defaultIsHeadless));
        isSelenoid = parseBoolean(System.getProperty("selenoid", defaultIsSelenoid));
        isVideoOn = parseBoolean(System.getProperty("video", defaultIsVideo));

        // i could copy video to jenkins host and get rid of it, but its bad practice
        selenoid_video_url = "http://" + System.getProperty("selenoid_video_url");
    }

    public static String getEnvPropertiesForAllure() {
        return "URL: " + url + "\n" +
               "login: " + login + "\n" +
               "password: " + password + "\n" +
               "language: " + language;
    }
}
