package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch extends TestBase {

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
        //открыть страницу репозитория
        open("https://github.com/selenide/selenide");

        //подвести мышку к первому аватару из блока contributors
        $("div.Layout-sidebar").$(byText("Contributors"))
                .closest(".BorderGrid-cell").$$("ul li").first().hover();

        //проверка: во всплывающем окне есть текст Andrei Solntsev
        $(".Popover").$(".Popover-message").shouldHave(text("Andrei Solntsev"));
    }
}
