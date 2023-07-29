package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        open("https://github.com/");

        //ввесте в поле поиска Selenide и нажать enter
        $(by("data-target", "qbsearch-input.inputButtonText")).click();
        $("#query-builder-test").setValue("Selenide").pressEnter();

        //кликнуть на первый репозиторий из списка
        $$(by("data-testid", "results-list")).first().$("a").click();

        //проверить что в заголовке есть текст "selenide / selenide"
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }

    @Test
    void andreiSolntsevShouldBeTheFirstContributor() {
        open("https://github.com/selenide/selenide");
    }
}
