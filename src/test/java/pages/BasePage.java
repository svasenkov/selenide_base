package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class BasePage {
    public SelenideElement circleImage = $(".img-circle");

    @Step("Проверка, что пользователь авторизирован")
    public BasePage verifyIsLoginned() {
        circleImage.shouldBe(visible);

        return this;
    }

    @Step("Open url \"{url}\"")
    public static void openUrl(String url) {
        open(url);
    }
}
