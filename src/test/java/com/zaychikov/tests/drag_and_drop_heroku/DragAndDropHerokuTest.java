package com.zaychikov.tests.drag_and_drop_heroku;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropHerokuTest {

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
    void dragAndDropInHeroku() {

        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        //Проверяем
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));
    }
}
