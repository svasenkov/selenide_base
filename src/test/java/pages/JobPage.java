package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.blocks.ModalBlock;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class JobPage {
    private SelenideElement applyJobButton = $(by("data-testid","apply-button"));


    @Step("Click \"Apply now\" button")
    public ModalBlock clickApplyJobButton() {
        applyJobButton.shouldBe(visible).click();

        return new ModalBlock();
    }

    @Step("Verify page has \"Applied!\"")
    public JobPage verifyJobApplied() {
        $(byText("Applied!")).should(exist); // todo add testid

        return this;
    }
}
