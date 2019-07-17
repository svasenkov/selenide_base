package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class BasePage {
    public SelenideElement desctopTopbarDiv = $x("//div[contains(@class, 'TopbarDesktopLayout')]"); // todo add testid


    @Step("Verify user is logged in")
    public BasePage verifyIsLoggedIn() {
        desctopTopbarDiv.shouldBe(visible);

        return this;
    }

    @Step("Open url \"{url}\"")
    public static void openUrl(String url) {
        open(url);
    }

    // todo get rid of such awful code, need more testid
    public SelenideElement getButtonByText(SelenideElement parent, String value) {
        return parent.$x(".//div[text()[contains(.,'" + value + "')]]" +
                "/../../div[@data-focusable='true']");
    }
}
