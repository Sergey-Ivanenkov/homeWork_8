package ru.yandex.afisha.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import ru.yandex.afisha.pages.YandexAfishaPage;

public class TestBase {
    YandexAfishaPage yandexAfishaPage = new YandexAfishaPage();

    @BeforeAll
    static void configure() {
//        Configuration.baseUrl = "";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "firefox";
        Configuration.timeout = 10000;
    }
}
