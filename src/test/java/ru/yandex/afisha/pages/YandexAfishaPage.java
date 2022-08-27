package ru.yandex.afisha.pages;

import com.codeborne.selenide.SelenideElement;
import ru.yandex.afisha.pages.components.RegionList;
import ru.yandex.afisha.pages.components.ModalSwitchRegion;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class YandexAfishaPage {
    public SelenideElement searchInput = $x("//input[@id='Input-sc-1lepych-5']"),
            searchResult = $x("//div[@class='search-page__content']"),
            toggleSwitchRegion = $x("//div/button[@data-component='CityButton']");

    private ModalSwitchRegion modalSwitchRegion = new ModalSwitchRegion();
    private RegionList checkRegionList = new RegionList();

    public YandexAfishaPage openYandexAfishaPage() {
        open("https://afisha.yandex.ru");

        return this;
    }

    public YandexAfishaPage searchProductsPage(String value) {
        searchInput.setValue(value).pressEnter();

        return this;
    }

    public YandexAfishaPage checkSearchResultPage() {
        searchResult.shouldBe(visible);

        return this;
    }

    public YandexAfishaPage setRegion(String regionName) {
        toggleSwitchRegion.click();
        modalSwitchRegion.setRegion(regionName);

        return this;
    }

    public YandexAfishaPage checkRegionList(List<String> regionList) {
        checkRegionList.checkRegionList(regionList);


        return this;
    }

    public YandexAfishaPage openYandexAfishaPageCity(String city) {
        open("https://afisha.yandex.ru/" + city);

        return this;
    }

    public YandexAfishaPage checkNameHeading(String nameHeading) {
        $x("//h1[@data-testid='title-with-more-link__title']").shouldHave(text(nameHeading));

        return this;
    }

}
