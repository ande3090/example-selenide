package Pages;

import Sections.LoginSection;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;


public class IndexPage extends BasePage {

    private static String BASE_URL = "https://www.semrush.com/";

    public IndexPage open() {
        addStep("Opening Index Page");
        open(BASE_URL);

        return this;
    }

    public boolean isAuthorized() {
        addStep("Checking if user authorized");
        ElementsCollection elements = $$("[data-test='header-menu__user']");

        return !elements.isEmpty();
    }

    public LoginSection loginSection() {
        return new LoginSection();
    }

}
