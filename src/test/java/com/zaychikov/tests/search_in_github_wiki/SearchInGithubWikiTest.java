package com.zaychikov.tests.search_in_github_wiki;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchInGithubWikiTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        //Тесты падают из-за долгой загрузки страницы, пришлось выставить увеличенный Таймаут
        Configuration.pageLoadTimeout = 600000;
    }

    @AfterAll
    static void afterAll() {
        //Оставляю браузер открытым для проверки введённых значений, т.к. он закрывается автоматически
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void searchJUnitTextInGithubWiki() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-body").shouldHave(text("Soft assertions"));
        $(byText("Soft assertions")).click();
        $(byText("3. Using JUnit5 extend test class:")).scrollTo();
        $("#wiki-body").shouldHave(text("JUnit5"));
    }
}
