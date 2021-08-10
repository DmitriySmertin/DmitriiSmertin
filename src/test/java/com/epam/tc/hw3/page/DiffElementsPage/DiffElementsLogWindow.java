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


    public void checkWindCheckBox() {
        Assertions.assertThat(logList.get(2).getText().contains("Wind: condition changed to true")).isTrue();

    }

    public void checkWaterCheckBox(){
        Assertions.assertThat(logList.get(3).getText().contains("Water: condition changed to true")).isTrue();
    }

    public void checkSelenRadioBtn(){
        Assertions.assertThat(logList.get(1).getText().contains("metal: value changed to Selen")).isTrue();
    }

    public void checkYellowColorDropbox(){
        Assertions.assertThat(logList.get(0).getText().contains("value changed to Yellow")).isTrue();
    }

}
