package com.epam.tc.hw4.page.DiffElementsPage;

import com.epam.tc.hw4.page.BasePage;
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

    @Step
    public void checkTitle() {
        Assertions.assertThat(driver.getTitle()).isEqualTo("Different Elements");
    }

    @Step
    public void selectWater() {
        checkBoxWater.click();
    }

    @Step
    public void selectWind() {
        checkBoxWind.click();
    }

    @Step
    public void selectSelen() {
        radioButtSelen.click();
    }

    @Step
    public void selectYellow() {
        dropdownColors.click();
        yellowColor.click();
    }


}
