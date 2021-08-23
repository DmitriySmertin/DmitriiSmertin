package com.epam.tc.component;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Locale;

public class Header extends AbstractComponent {


    public Header(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Home")
    private WebElement menuHome;

    @FindBy(linkText = "Contact form")
    private WebElement menuCont;

    @FindBy(linkText = "Service")
    private WebElement menuServ;

    @FindBy(linkText = "Metals & Colors")
    private WebElement menuMetCol;

    @FindBy(linkText = "Different elements")
    private WebElement servDiffElements;

    @FindBy(linkText = "User Table")
    private WebElement servUserTable;

    @Step("Check names Header menu items: Home, Contact form, Service, Metals & Colors on header Index Page and displaying their")
    public void checkItemsHeaderMenu() {
        Assertions.assertThat(menuHome.getText().toUpperCase(Locale.ROOT)).isEqualTo("HOME");
        Assertions.assertThat(menuHome.isDisplayed());
        Assertions.assertThat(menuCont.getText().toUpperCase(Locale.ROOT)).isEqualTo("CONTACT FORM");
        Assertions.assertThat(menuCont.isDisplayed());
        Assertions.assertThat(menuServ.getText().toUpperCase(Locale.ROOT)).isEqualTo("SERVICE");
        Assertions.assertThat(menuServ.isDisplayed());
        Assertions.assertThat(menuMetCol.getText().toUpperCase(Locale.ROOT)).isEqualTo("METALS & COLORS");
        Assertions.assertThat(menuMetCol.isDisplayed());
    }

    @Step("Open DiffElements Page")
    public void openDiffElementPage() {
        menuServ.click();
        servDiffElements.click();
    }

    @Step("Open Service menu")
    public void openServiceMenu() {
        menuServ.click();
    }

    @Step("Open User Table")
    public void openUserTable()
    {
        servUserTable.click();
    }


}
