package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaTestForIssue {

    private static final String repository = "VEvtushenko/VEvtushenko-QA-Guru-HelloWorld";
    private static final SelenideElement searchInput = $(".header-search-input");
    private static final String issueName = "My first issue";

    @Test
    public void testForIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открывааем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий " + repository, () -> {
            searchInput.click();
            searchInput.setValue(repository);
            searchInput.pressEnter();
                });

        step("Переходим в репозиторий " + repository, () -> {
            $(By.linkText(repository)).click();
                });
        step("Открывааем вкладку Issues", () -> {
            $(By.partialLinkText("Issues")).click();
                });
        step("Проверяем, что tcnm issue c именем " + issueName, () -> {
            $("#repo-content-pjax-container").shouldHave(Condition.text(issueName));
        });
    }
}
