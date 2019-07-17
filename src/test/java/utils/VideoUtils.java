package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static helpers.EnvHelper.selenoid_video_url;

public class VideoUtils {

    private static Logger logger = LoggerFactory.getLogger(VideoUtils.class);

    private static HashSet <String> videos = new HashSet<>();

    public static void addVideoToRemove() {
        videos.add(getVideoFilename());
    }

    public static String getVideoFilename(){
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString().replace("selenoid","");
    }

    public static void removeAllVideos(){
        closeWebDriver();
        videos.forEach(video -> {
           while (true) {
               Response response = RestAssured
                       .delete(selenoid_video_url + "/video/" + video + ".mp4")
                       .then()
                       .extract()
                       .response();
               int code = response.getStatusCode();
               if(code == 200){
                   break;
               }
           }
            logger.info("Video deleted " + video);
       });
    }
}
