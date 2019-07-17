package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class RegisterPage {
//    private SelenideElement facebookButton = $(by("data-testid","facebook-button"));
    private SelenideElement fnameInput = $(byName("firstName"));
    private SelenideElement lnameInput = $(byName("lastName"));
    private SelenideElement emailInput = $(byName("email"));
    private SelenideElement passwordInput = $(byName("password"));
    private SelenideElement registerButton = $x("//button[@type='submit']");


    @Step ("Type First name \"{value}\"")
    public RegisterPage typeFirstName(String value) {
        fnameInput.shouldBe(visible).val(value);

        return this;
    }

    @Step ("Type Last name \"{value}\"")
    public RegisterPage typeLastName(String value) {
        lnameInput.shouldBe(visible).val(value);

        return this;
    }

    @Step ("Type email \"{value}\"")
    public RegisterPage typeEmail(String value) {
        emailInput.shouldBe(visible).val(value);

        return this;
    }

    @Step ("Type password \"{value}\"")
    public RegisterPage typePassword(String value) {
        passwordInput.shouldBe(visible).val(value);

        return this;
    }

    @Step("Click \"Create an account\" button")
    public BasePage clickRegisterButton() {
        registerButton.shouldBe(visible).click();

        return new BasePage();
    }
}
