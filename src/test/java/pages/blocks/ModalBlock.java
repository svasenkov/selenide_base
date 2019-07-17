package pages.blocks;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class ModalBlock extends BasePage {
    private SelenideElement mainDiv = $("#modal-root");
    private SelenideElement storyTextbox = $(byName("about"));


    @Step("Click \"Apply now\" button")
    public ModalBlock clickNoExperienceButton() {
       getButtonByText(mainDiv, "I do not have work experience")  // todo add testid
                .shouldBe(visible).click();

        return this;
    }


    @Step("Click \"Later\" button")
    public ModalBlock clickLaterButton() {
        getButtonByText(mainDiv, "Later") // todo add testid
                .shouldBe(visible).click();

        return this;
    }

    @Step("Click \"Next\" button")
    public ModalBlock clickNextButton() {
        getButtonByText(mainDiv, "Next") // todo add testid
                .shouldBe(visible).click();

        return this;
    }

    @Step ("Type \"{value}\" in textarea \"Your story\"")
    public ModalBlock typeStory(String value) {
        storyTextbox.shouldBe(visible).val(value);

        return this;
    }

    @Step ("Select language \"{value}\"")
    public ModalBlock selectLanguage(String value) {
        mainDiv.$$("select").get(0) // todo add testid
                .shouldBe(visible).selectOption(value);

        return this;
    }

    @Step ("Select language level \"{value}\"")
    public ModalBlock selectLanguageLevel(String value) {
        mainDiv.$$("select").get(1) // todo add testid
                .shouldBe(visible).selectOption(value);

        return this;
    }
}
