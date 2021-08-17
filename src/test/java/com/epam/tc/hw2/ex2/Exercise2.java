package com.epam.tc.hw2.ex2;


import com.epam.tc.hw2.BaseExerciseClass;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise2 extends BaseExerciseClass {

    @Test
    public void seleniumHw2Exercise2Test() {
        //1. Open test site by URL
        driver.navigate().to(getIndexUrl());
        //2. Assert Browser title
        Assertions.assertThat(driver.getTitle()).isEqualTo(getExpectedBrowserTitle());
        //3. Perform login
        driver.findElement(By.className("profile-photo")).click();
        driver.findElement(By.id("name")).sendKeys(getUserName());
        driver.findElement(By.id("password")).sendKeys(getUserPass());
        driver.findElement(By.id("login-button")).click();
        //4. Assert Username is loggined
        Assertions.assertThat(driver.findElement(By.id("user-name")).getText()).isEqualTo(getExpectedUserLogin());
        Assertions.assertThat(driver.findElement(By.id("user-name")).isDisplayed());
        //5. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.linkText("Service")).click();
        driver.findElement(By.linkText("Different elements")).click();
        Assertions.assertThat(driver.getTitle()).isEqualTo("Different Elements");
        //6. Select checkboxes
        driver.findElement(By.xpath("//label[text()[contains(.,'Water')]]/input")).click();
        driver.findElement(By.xpath("//label[text()[contains(.,'Wind')]]/input")).click();
        //7. Select radio
        driver.findElement(By.xpath("//label[text()[contains(.,'Selen')]]/input")).click();
        //8. Select in dropdown
        driver.findElement(By.cssSelector("select.uui-form-element")).click();
        driver.findElement(By.xpath("//option[text()='Yellow']")).click();
        //* 9. Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox;
        List<WebElement> logList = driver.findElements(By.xpath("//ul[contains(@class,'logs')]//li"));

        Assertions.assertThat(logList.get(2).getText().contains("Wind: condition changed to true")).isTrue();
        Assertions.assertThat(logList.get(3).getText().contains("Water: condition changed to true")).isTrue();
        //•	for radio button there is a log row and value is corresponded to the status of radio button;
        Assertions.assertThat(logList.get(1).getText().contains("metal: value changed to Selen")).isTrue();
        //• for dropdown there is a log row and value is corresponded to the selected value;
        Assertions.assertThat(logList.get(0).getText().contains("value changed to Yellow")).isTrue();
        // 10. Close Browser(configured in SetUpAndTearDown.class)
    }

}
