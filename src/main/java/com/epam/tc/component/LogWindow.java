package com.epam.tc.component;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LogWindow extends AbstractComponent {
    public LogWindow(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[contains(@class,'logs')]//li")
    List<WebElement> logList;

    @Step("Check text and position record in Log Window")
    public void checkWebElementInLogWindow(int positionElementInLogWindow, String textElementInLogWindow) {
        Assertions.assertThat(logList.get(positionElementInLogWindow - 1).getText().contains(textElementInLogWindow)).isTrue();
    }

}
