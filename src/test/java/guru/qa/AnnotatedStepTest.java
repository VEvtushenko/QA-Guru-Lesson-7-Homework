package guru.qa;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class AnnotatedStepTest {

    private static final String repository = "VEvtushenko/VEvtushenko-QA-Guru-HelloWorld";
    private static final SelenideElement searchInput = $(".header-search-input");
    private static final String issueName = "My first issue";

    @Test
    public void issueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps seteps = new WebSteps();
        seteps.openGithub()
              .searchForRepository(searchInput, repository)
              .openRepository(repository)
              .openIssues()
              .searchIssueByName(issueName);
    }
}
