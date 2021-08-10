package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.GeneralData;
import com.epam.tc.hw2.SetUpAndTearDown;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class Exercise1 extends SetUpAndTearDown {

    //Data
    GeneralData data = new GeneralData();
    private final String homeNavItem = "HOME";
    private final String contactNavItem = "CONTACT FORM";
    private final String serviceNavItem = "SERVICE";
    private final String metalsAndColorsNavItem = "METALS & COLORS";
    private final List<String> expectedTextBenefitList = Arrays.asList(
            "To include good practices and ideas from successful EPAM project",
            "To be flexible and customizable",
            "To be multiplatform",
            "Already have good base (about 20 internal and some external projects), wish to get more…");
    private final List<String> expectedTextLeftMenuList = Arrays.asList(
            "Home", "Contact form", "Service", "Metals & Colors", "Elements packs");


    @Test
    public void seleniumHw2Exercise1Test() {
        //1. Open test site by URL
        driver.navigate().to(data.getIndexUrl());
        //2. Assert Browser title
        Assertions.assertThat(driver.getTitle()).isEqualTo(data.getExpectedBrowserTitle());
        //3. Perform login
        driver.findElement(By.className("profile-photo")).click();
        driver.findElement(By.id("name")).sendKeys(data.getUserName());
        driver.findElement(By.id("password")).sendKeys(data.getUserPass());
        driver.findElement(By.id("login-button")).click();
        //4. Assert Username is loggined
        Assertions.assertThat(driver.findElement(By.id("user-name")).getText()).isEqualTo(data.getExpectedUserLogin());
        Assertions.assertThat(driver.findElement(By.id("user-name")).isDisplayed());
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        Assertions.assertThat(driver.findElement(By.linkText("Home")).getText().toUpperCase(Locale.ROOT))
                .isEqualTo(homeNavItem);
        Assertions.assertThat(driver.findElement(By.linkText("Home")).isDisplayed());
        Assertions.assertThat(driver.findElement(By.linkText("Contact form")).getText().toUpperCase(Locale.ROOT))
                .isEqualTo(contactNavItem);
        Assertions.assertThat(driver.findElement(By.linkText("Contact form")).isDisplayed());
        Assertions.assertThat(driver.findElement(By.linkText("Service")).getText().toUpperCase(Locale.ROOT))
                .isEqualTo(serviceNavItem);
        Assertions.assertThat(driver.findElement(By.linkText("Service")).isDisplayed());
        Assertions.assertThat(driver.findElement(By.linkText("Metals & Colors")).getText().toUpperCase(Locale.ROOT))
                .isEqualTo(metalsAndColorsNavItem);
        Assertions.assertThat(driver.findElement(By.linkText("Metals & Colors")).isDisplayed());
        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> imgIndexList = driver.findElements(By.xpath("//span[contains(@class,'icons-benefit')]"));
        Assertions.assertThat(imgIndexList.size()).isEqualTo(4);
        for (int i = 0; i < imgIndexList.size(); i++) {
            Assertions.assertThat(imgIndexList.get(i).isDisplayed());
        }
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textBenefitList = driver.findElements(By.className("benefit-txt"));
        Assertions.assertThat(textBenefitList.size()).isEqualTo(4);
        for (int i = 0; i < textBenefitList.size(); i++) {
            Assertions.assertThat(textBenefitList.get(i).getText().replace("\n", " "))
                    .isEqualTo(expectedTextBenefitList.get(i));
        }
        //8. Assert that there is the iframe with “Frame Button” exist
        Assertions.assertThat(driver.findElement(By.id("frame")).isEnabled());
        //9.  Switch to the iframe and check that there is “Frame Button” in the iframe
        String windowHomePage = driver.getWindowHandle();
        driver.switchTo().frame("frame");
        Assertions.assertThat(driver.findElement(By.id("frame-button")).isEnabled());
        //10. Switch to original window back
        driver.switchTo().window(windowHomePage);
        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftMenuItemsList = driver.findElements(By.xpath("//ul[contains (@class, 'left')]/li/a"));
        Assertions.assertThat(leftMenuItemsList.size()).isEqualTo(5);
        for (int i = 0; i < leftMenuItemsList.size(); i++) {
            Assertions.assertThat(leftMenuItemsList.get(i).isDisplayed());
            Assertions.assertThat(leftMenuItemsList.get(i).getText()).isEqualTo(expectedTextLeftMenuList.get(i));
        }
        //12. Close Browser(configured in SetUpAndTearDown.class)
    }
}
