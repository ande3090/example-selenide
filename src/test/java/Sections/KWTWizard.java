package Sections;

import Pages.BasePage;
import Pages.FilterPage;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class KWTWizard extends BasePage {

    public KWTWizard() {
    }

    public KWTWizard chooseManual() {
        addStep("Choose Manual keywords adding");
        $("[data-test-id='btn-manual']").click();
        $(".kwt-manual__textarea").waitUntil(Condition.appear, 10000);
        return this;
    }


    public KWTWizard addKeywords(String[] arr) {
        addStep("Adding keywords");
        for (String value : arr) {
            $(".s-textarea").sendKeys(value);
            $("[data-test-id='kwt-tbx-add']").click();
        }
        return this;
    }

    public int getKeywordsCount() {
        addStep("Getting keywords count");
        return Integer.parseInt($(".count").getText());
    }

    public KWTWizard chooseLocationTab() {
        addStep("Choosing location tab");
        $(".kwt-dialog-tab:last-child").click();
        $(".kwt-submit-form__inputs").waitUntil(Condition.appear, 10000);
        return this;
    }

    public KWTWizard setOverlayScreenCookie() {
        addStep("Setting overlay screen cookie");
        setCookie("actionButtonIntroTooltipClosed", "1");
        return this;
    }

    public KWTWizard chooseCountry() {
        addStep("Choosing first available country");
        $(".kwt-flagged-select").click();
        $(".flag-option").waitUntil(Condition.appear, 10000);
        $(".flag-option").click();
        return this;
    }

    public FilterPage clickSubmit() {
        addStep("Clicking submit button");
        $(".kwt-dialog__ok-button").click();
        return new FilterPage();
    }

}
