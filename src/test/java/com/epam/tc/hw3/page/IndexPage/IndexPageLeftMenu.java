package com.epam.tc.hw3.page.IndexPage;

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

    private final List<String> expectedTextLeftMenuList = Arrays.asList(
            "Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

    @FindBy(xpath = "//ul[contains (@class, 'left')]/li/a")
    List<WebElement> leftMenuItemsList;

    public void checkCountItems() {
        Assertions.assertThat(leftMenuItemsList.size()).isEqualTo(5);
    }

    public void checkTextAndDisplayedItems() {
        for (int i = 0; i < leftMenuItemsList.size(); i++) {
            Assertions.assertThat(leftMenuItemsList.get(i).isDisplayed());
            Assertions.assertThat(leftMenuItemsList.get(i).getText()).isEqualTo(expectedTextLeftMenuList.get(i));
        }
    }

}
