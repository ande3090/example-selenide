package Pages;

import Sections.KWTWizard;
import Sections.LoginSection;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPage extends BasePage {

    private static String BASE_URL = "https://www.semrush.com/projects/#no-projects/";

    public ProjectsPage() {

    }

    public ProjectsPage open() {
        addStep("Opening Projects page");
        open(BASE_URL);
        $(".s-dashboard__spinner").waitUntil(Condition.disappear, 10000);
        return this;
    }

    public ProjectsPage clickProjectsTab() {
        addStep("Clicking project tab in left menu");
        $("[data-test='tools']").click();
        $(".js-projects-menu:not([style='display: none'])").waitUntil(Condition.disappear, 10000);
        return this;
    }

    public ProjectsPage clickNewProject() {
        addStep("Clicking New Project button in left menu");
        $(".lm-menu__project-button-section a").click();
        $(".pr-page .js-add-project").waitUntil(Condition.appear, 10000);
        return this;
    }

    public ProjectsPage createNewProject(String title, String url) {
        addStep("Creating new project with modal form");
        $(".pr-page .js-add-project").click();
        $(".pr-dialog-form").waitUntil(Condition.disappear, 10000);
        $(".js-input-domain").sendKeys(url);
        $(".js-input-name").sendKeys(title);
        $(".js-save-pr").click();
        $(".pr-page .js-add-project").waitUntil(Condition.disappear, 10000);
        $(".js-kwt .js-ssa-setup").waitUntil(Condition.appear, 10000);
        return this;
    }

    public ProjectsPage clickTestProject() {
        addStep("Clicking existing test project in left menu");
        $(".js-goto-project").click();
        $(".pr-page__header").waitUntil(Condition.appear, 10000);

        return this;
    }

    public KWTWizard clickSetupWidget() {
        addStep("Clicking setup widget button");
        $(".js-kwt .js-ssa-setup").click();
        $(".kwt-wizard").waitUntil(Condition.appear, 10000);

        return new KWTWizard();
    }

    public boolean isAuthorized() {
        addStep("Checking is user authorized");
        ElementsCollection elements = $$("[data-test='header-menu__user']");

        return !elements.isEmpty();
    }

    public LoginSection loginSection() {
        return new LoginSection();
    }


}
