package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открывааем главную страницу")
    public WebSteps openGithub() {
        open("https://github.com/");
        return this;
    }

    @Step("Ищем репозиторий {rep}")
    public WebSteps searchForRepository(SelenideElement searchInput, String rep) {
        searchInput.click();
        searchInput.setValue(rep);
        searchInput.pressEnter();
        return this;
    }

    @Step("Переходим в репозиторий {rep}")
    public WebSteps openRepository(String rep) {
        $(By.linkText(rep)).click();
        return this;
    }

    @Step("Открывааем вкладку Issues")
    public WebSteps openIssues() {
        $(By.partialLinkText("Issues")).click();
        return this;
    }

    @Step("Проверяем, что tcnm issue c именем  {issueName}")
    public WebSteps searchIssueByName(String issueName) {
        $("#repo-content-pjax-container").shouldHave(Condition.text(issueName));
        return this;
    }
}
