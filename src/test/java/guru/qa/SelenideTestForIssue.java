package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTestForIssue {

    @Test
    public void selenideTestForIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        SelenideElement searchInput = $(".header-search-input");
        String repository = "VEvtushenko/VEvtushenko-QA-Guru-HelloWorld";
        String issueName = "My first issue";

        open("https://github.com/");
        searchInput.click();
        searchInput.setValue(repository);
        searchInput.pressEnter();

        $(linkText(repository)).click();
        $(partialLinkText("Issues")).click();
        $("#repo-content-pjax-container").shouldHave(text(issueName));
    }
}
