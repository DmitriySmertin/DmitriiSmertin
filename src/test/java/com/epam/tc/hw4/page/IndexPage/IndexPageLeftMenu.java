package com.epam.tc.hw4.page.IndexPage;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class IndexPageLeftMenu extends IndexPage {
    public IndexPageLeftMenu(WebDriver driver) {
        super(driver);
    }

    private final List<String> TEXT_LEFT_MENU_LIST = Arrays.asList(
            "Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

    @FindBy(css = "div#mCSB_1_container ul.sidebar-menu.left > li")
    List<WebElement> leftMenuItemsList;

    @Step
    public void checkCountLeftMenuItems() {
        Assertions.assertThat(leftMenuItemsList.size()).isEqualTo(5);
    }

    @Step
    public void checkTextAndDisplayedItems() {
        for (int i = 0; i < leftMenuItemsList.size(); i++) {
            Assertions.assertThat(leftMenuItemsList.get(i).isDisplayed());
            Assertions.assertThat(leftMenuItemsList.get(i).getText()).isEqualTo(TEXT_LEFT_MENU_LIST.get(i));
        }
    }

}
