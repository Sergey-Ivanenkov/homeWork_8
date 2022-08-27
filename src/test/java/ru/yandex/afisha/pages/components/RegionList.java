package ru.yandex.afisha.pages.components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;


public class RegionList {
    ElementsCollection cities = $$x("//div[@data-testid='city-popup__list']//span");

    public RegionList checkRegionList(List<String> regonList) {

        cities.shouldHave(CollectionCondition.texts(regonList));

        return this;
    }
}
