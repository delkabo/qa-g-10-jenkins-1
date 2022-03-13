package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class BaseTestLambdaStep {

    private static final String REPO = "delkabo/qa-g-6-Junit-1";

    @Test
    void baseTestLambdaStep() {

        step("Открыть Гитхаб", () -> open("https://github.com/"));

        step("Ввести в поиск название страницы " + REPO, () ->
                $(".header-search-input").setValue(REPO).submit());

        step("Проверка, что искомый репозиторий есть на странице", () -> {
            $(".repo-list").should(text(REPO));
            $(By.linkText("delkabo/qa-g-6-Junit-1")).click();
        });

        step("Проверить наличие поля Issue", () ->
                $("#issues-tab").should(text("issues")));
    }
}
