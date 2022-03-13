package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Open home page")
    public void openMainPage() {

        open("https://github.com");
    }

    @Step("Looking for a repository {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Check if the repository is found {repo}")
    public void checkRepository(String repo) {
        $(".repo-list").should(text(repo));
    }

    @Step("Opening the repository {repo}")
    public void openRepository(String repo) {
        $(By.linkText(repo)).click();
    }

    @Step("Checking for tabs Issue")
    public void checkIssueTab() {
        $("#issues-tab").should(text("issues"));
        Allure.addAttachment("page", "text/html", WebDriverRunner.source(), ".html");
    }

}
