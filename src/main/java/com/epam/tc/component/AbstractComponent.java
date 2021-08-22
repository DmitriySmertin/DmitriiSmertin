package com.epam.tc.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    protected AbstractComponent(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10L);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }
}
