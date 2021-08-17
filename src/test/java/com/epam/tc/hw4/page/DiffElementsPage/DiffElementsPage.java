package com.epam.tc.hw4.page.DiffElementsPage;

import com.epam.tc.hw3.page.BasePage;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiffElementsPage extends BasePage {

    public DiffElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//label[text()[contains(.,'Water')]]/input")
    private WebElement checkBoxWater;

    @FindBy(xpath = "//label[text()[contains(.,'Wind')]]/input")
    private WebElement checkBoxWind;

    @FindBy(xpath = "//label[text()[contains(.,'Selen')]]/input")
    private WebElement radioButtSelen;

    @FindBy(css = "select.uui-form-element")
    private WebElement dropdownColors;

    @FindBy(xpath = "//option[text()='Yellow']")
    private WebElement yellowColor;

    public void selectWater() {
        checkBoxWater.click();
    }

    public void selectWind() {
        checkBoxWind.click();
    }

    public void selectSelen() {
        radioButtSelen.click();
    }

    public void selectYellow() {
        dropdownColors.click();
        yellowColor.click();
    }


}
