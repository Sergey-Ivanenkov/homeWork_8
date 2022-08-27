package ru.yandex.afisha.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

public class WebTest extends TestBase {

    @ValueSource(strings = {"Рок", "Флейта"})
    @ParameterizedTest(name = "Результаты поиска не пустые для запроса {0}")
    void webTest(String product) {
        yandexAfishaPage.openYandexAfishaPage()
                .searchProductsPage(product)
                .checkSearchResultPage()
        ;
    }

    static Stream<Arguments> dataProviderForSelenideSiteMenuTest() {
        return Stream.of(
                Arguments.of("Мос", List.of("Мосальск", "Мостовской")),
                Arguments.of("Сал", List.of("Салават", "Салехард", "Сальск"))
        );
    }


    @MethodSource("dataProviderForSelenideSiteMenuTest")
    @ParameterizedTest(name = "Поиск по значению \"{0}\", в результате отображается {1}")
    void switchRegionTest(String regionName, List<String> regionList) {

        yandexAfishaPage.openYandexAfishaPage()
                .setRegion(regionName)
                .checkRegionList(regionList);

        System.out.println();

    }

    @CsvSource(value = {
            "moscow, Афиша событий в Москве",
            "saint-petersburg, Афиша событий в Санкт-Петербурге",
    })
    @ParameterizedTest(name = "Перейти по ссылке \"https://afisha.yandex.ru/{0}\" проверить наличие заголовка \"{1}\"")
    void test(String city, String nameHeading) {
        yandexAfishaPage.openYandexAfishaPageCity(city)
                .checkNameHeading(nameHeading);
    }
}
