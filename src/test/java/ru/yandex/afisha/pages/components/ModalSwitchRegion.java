package ru.yandex.afisha.pages.components;

import static com.codeborne.selenide.Selenide.$x;

public class ModalSwitchRegion {
    public ModalSwitchRegion setRegion(String regionName) {
        $x("//input[@id='Input-sc-1lepych-5' and contains (@data-testid, 'city-popup-input')]").setValue(regionName).pressEnter();

        return this;
    }
}
