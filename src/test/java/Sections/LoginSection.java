package Sections;

import Pages.BasePage;
import Pages.ProjectsPage;
import com.codeborne.selenide.Condition;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class LoginSection extends BasePage {

    private String loginButton = "[data-test=\"auth-popup__btn-login\"]";
    private String formLayout = ".sso-base-popup-form";

    private String emailInput = "[data-test='auth-popup__email']";
    private String passwordInput = "[data-test='auth-popup__password']";
    private String submitInput = "[data-test='auth-popup__submit']";

    private String spinner = ".s-dashboard__spinner";
    private String headerUserButton = "[data-test='header-menu__user']";

    public LoginSection() {

    }

    public LoginSection clickLoginButton() {
        addStep("Clicking logging button to open Login popup");
        $(loginButton).click();
        $(formLayout).waitUntil(Condition.appear, 10000);
        return this;
    }

    public LoginSection fillForm(Map<String, String> user) {
        addStep("Filling form with " + user.toString());
        $(emailInput).sendKeys(user.get("login"));
        $(passwordInput).sendKeys(user.get("password"));
        return this;
    }

    public ProjectsPage clickSubmit() {
        addStep("Clicking submit button for authentication");
        $(submitInput).click();
        $(headerUserButton).waitUntil(Condition.appear, 10000);
        $(formLayout).waitUntil(Condition.disappear, 10000);
        $(spinner).waitUntil(Condition.disappear, 10000);
        return new ProjectsPage();
    }

}
