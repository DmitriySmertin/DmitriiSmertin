package com.epam.tc.hw3.page.DiffElementsPage;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DiffElementsLogWindow extends DiffElementsPage {


    public DiffElementsLogWindow(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[contains(@class,'logs')]//li")
    List<WebElement> logList;


    public void checkWindCheckBox(int positionInLogWindow, String text) {
        Assertions.assertThat(logList.get(positionInLogWindow).getText().contains(text)).isTrue();

    }

    public void checkWaterCheckBox(int positionInLogWindow, String text) {
        Assertions.assertThat(logList.get(positionInLogWindow).getText().contains(text)).isTrue();
    }

    public void checkSelenRadioBtn(int positionInLogWindow, String text) {
        Assertions.assertThat(logList.get(positionInLogWindow).getText().contains(text)).isTrue();
    }

    public void checkYellowColorDropbox(int positionInLogWindow, String text) {
        Assertions.assertThat(logList.get(positionInLogWindow).getText().contains(text)).isTrue();
    }

}
