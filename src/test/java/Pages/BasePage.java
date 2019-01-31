package Pages;

import Framework.SEMRushLogger;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.commons.logging.LogFactory;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class BasePage {

    public static SEMRushLogger logger = new SEMRushLogger();

    public BasePage() {
        logger.addStep("Logger created");
    }

    public BasePage open(String url) {
        logger.addStep("Opening url [" + url + "]");
        Selenide.open(url);
        return this;
    }

    public BasePage addStep(String description) {
        logger.addStep(description);
        return this;
    }

    public BasePage setCookie(String name, String value) {
        logger.addStep("Setting cookie " + name + " with value " + value);
        executeJavaScript("document.cookie='" + name + "=" + value + ";domain=.semrush.com;path=/;';");
        return this;
    }

    public String getPageTitle() {
        return WebDriverRunner.getWebDriver().getTitle();
    }

}
