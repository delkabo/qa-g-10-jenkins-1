package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTestLambdaStep {

    @BeforeAll
    static void setUp(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC",true);
        capabilities.setCapability("enableVideo",true);
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

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
