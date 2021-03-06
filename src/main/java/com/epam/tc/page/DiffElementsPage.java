package com.epam.tc.page;

import com.epam.tc.component.LeftMenu;
import com.epam.tc.component.LogWindow;
import com.epam.tc.page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiffElementsPage extends BasePage {

    public DiffElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        logWindow = new LogWindow(driver);
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

    @Step("Select Water checkbox")
    public void selectWater() {
        checkBoxWater.click();
    }

    @Step("Select Wind checkbox")
    public void selectWind() {
        checkBoxWind.click();
    }

    @Step("Select Selen radiobutton")
    public void selectSelen() {
        radioButtSelen.click();
    }

    @Step("Select Yellow in dropdown list")
    public void selectYellow() {
        dropdownColors.click();
        yellowColor.click();
    }

}
