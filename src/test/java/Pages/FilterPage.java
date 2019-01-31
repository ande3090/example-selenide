package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;


public class FilterPage extends BasePage {

    private static String BASE_URL = "https://www.semrush.com/keyword_tool/741706";

    public FilterPage() {
        $(".intro-dialog-content").waitUntil(Condition.appear, 10000);
    }

    public FilterPage open() {
        addStep("Opening filter page with url " + BASE_URL);
        open(BASE_URL);
        $(".kwt-loading-indicator-fullsize").waitUntil(Condition.disappear, 10000);
        $("[data-test-id=\"keyword-cell\"]").waitUntil(Condition.appear, 10000);
        $(".kwt-table__count").waitUntil(Condition.appear, 10000);
        return this;
    }

    public FilterPage setFilter(String text) {
        addStep("Setting filter as " + text);
        String currentText = $(".kwt-table__count").getText();
        $(".kwt-filters__short input").sendKeys(text);
        $(".kwt-loading-indicator-fullsize").waitUntil(Condition.disappear, 10000);
        $(".kwt-table__count").waitUntil(Condition.matchesText(currentText), 10000);
        return this;
    }

    public String getFilterText() {
        addStep("Getting filter text");

        return $(".kwt-filters__short input").getAttribute("value");
    }

    public boolean isResultsFound() {
        addStep("Checking if results found after filtration");
        ElementsCollection elements = $$(".kwt-nothing-found");

        return !elements.isEmpty();
    }

    public int getResultCounter() {
        addStep("Getting result counter value");
        String counter = $(".kwt-table__count").getText();
        counter = counter.replaceAll("[^\\d.]", "");
        return Integer.parseInt(counter);
    }

    public int getCellsCount() {
        addStep("Getting found cells count");
        ElementsCollection elements = $$("[data-test-id='keyword-cell']");

        return elements.size();
    }

    public FilterPage clickClearButton() {
        addStep("Clicking Clear Filter button");
        $(".kwt-filters__short .s-input__clear");
        $(".kwt-filters__short .s-input__clear.-visible").waitUntil(Condition.disappear, 10000);
        $(".kwt-loading-indicator-fullsize").waitUntil(Condition.disappear, 10000);

        return this;
    }

    public boolean isFilterClearButtonVisible() {
        addStep("Checking is Filter Clear Button visible");
        ElementsCollection elements = $$(".kwt-filters__short .s-input__clear.-visible");

        return !elements.isEmpty();
    }

    public FilterPage closeTour() {
        addStep("Clicking Close Tour button");
        $(".close-tour").waitUntil(Condition.appear, 10000);
        executeJavaScript("$('.close-tour').click();");

        $(".product-tour-overlay").waitUntil(Condition.disappear, 10000);

        return this;
    }

}
