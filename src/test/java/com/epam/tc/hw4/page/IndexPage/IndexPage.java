package com.epam.tc.hw4.page.IndexPage;

import com.epam.tc.hw4.page.BasePage;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;


public class IndexPage extends BasePage {
    //DATA
    private final List<String> TEXT_BENEFIT_LIST = Arrays.asList(
            "To include good practices and ideas from successful EPAM project",
            "To be flexible and customizable",
            "To be multiplatform",
            "Already have good base (about 20 internal and some external projects), wish to get more…");

    //LOCATORS
    @FindBy(className = "profile-photo")
    private WebElement profilePhoto;

    @FindBy(id = "name")
    private WebElement nameLoginField;

    @FindBy(id = "password")
    private WebElement passLoginField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(xpath = "//span[contains(@class,'icons-benefit')]")
    private List<WebElement> imgIndexList;

    @FindBy(className = "benefit-txt")
    private List<WebElement> textBenefitList;

    @FindBy(id = "frame")
    private WebElement frameWthButton;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public IndexPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step
    public void checkTitle() {
        Assertions.assertThat(driver.getTitle()).isEqualTo("Home Page");
    }

    @Step
    public void checkLogin() {
        Assertions.assertThat(userName.getText()).isEqualTo(propUtil.getValue("user.login"));
        Assertions.assertThat(userName.isDisplayed());
    }

    @Step
    public void login() {
        profilePhoto.click();
        nameLoginField.sendKeys(propUtil.getValue("user.name"));
        passLoginField.sendKeys(propUtil.getValue("user.pass"));
        loginButton.click();
    }

    @Step
    public void checkImgCount(int count) {
        Assertions.assertThat(imgIndexList.size()).isEqualTo(count);
    }

    @Step
    public void checkImgDisplayed() {
        for (int i = 0; i < imgIndexList.size(); i++) {
            Assertions.assertThat(imgIndexList.get(i).isDisplayed());
        }
    }

    @Step
    public void checkBenefitTextCount(int count) {
        Assertions.assertThat(textBenefitList.size()).isEqualTo(count);
    }

    @Step
    public void checkBenefitTextDisplayed() {
        for (int i = 0; i < textBenefitList.size(); i++) {
            Assertions.assertThat(textBenefitList.get(i).getText().replace("\n", " "))
                    .isEqualTo(TEXT_BENEFIT_LIST.get(i));
        }
    }

    @Step
    public void checkFrameWthButtonEnabled() {
        Assertions.assertThat(frameWthButton.isEnabled());
    }

    private String windowHomePage = "";

    @Step
    public String switchToIframe() {
        windowHomePage = driver.getWindowHandle();
        driver.switchTo().frame("frame");
        return windowHomePage;
    }
    @Step
    public void switchToWindowHome() {
        driver.switchTo().window(windowHomePage);
    }

    @Step
    public void checkFrameButtonEnabled() {
        Assertions.assertThat(frameButton.isEnabled());
    }
}