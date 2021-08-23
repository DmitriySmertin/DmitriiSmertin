package com.epam.tc.page;

import com.epam.tc.page.BasePage;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static com.epam.tc.util.PropertiesUtil.getValue;


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

    @Step("Check login")
    public void checkLogin() {
        Assertions.assertThat(userName.getText()).isEqualTo(getValue("user.login"));
        Assertions.assertThat(userName.isDisplayed());
    }

    @Step("Login in Index Page")
    public void login(String user) {
        profilePhoto.click();
        user = user.replaceAll(" ", ".");
        nameLoginField.sendKeys(getValue("user.name." + user.toLowerCase().trim()));
        passLoginField.sendKeys(getValue("user.pass."+ user.toLowerCase().trim()));
        loginButton.click();
    }

    @Step("Check count images on Index Page")
    public void checkImgCount(int count) {
        Assertions.assertThat(imgIndexList.size()).isEqualTo(count);
    }

    @Step("Check displayed image on Index Page")
    public void checkImgDisplayed() {
        for (int i = 0; i < imgIndexList.size(); i++) {
            Assertions.assertThat(imgIndexList.get(i).isDisplayed());
        }
    }

    @Step("Check count Benefit Text blocks")
    public void checkBenefitTextCount(int count) {
        Assertions.assertThat(textBenefitList.size()).isEqualTo(count);
    }

    @Step("Check displayed Benefit Text blocks")
    public void checkBenefitTextDisplayed() {
        for (int i = 0; i < textBenefitList.size(); i++) {
            Assertions.assertThat(textBenefitList.get(i).getText().replace("\n", " "))
                    .isEqualTo(TEXT_BENEFIT_LIST.get(i));
        }
    }

    @Step("Check frame with Button enabled")
    public void checkFrameWthButtonEnabled() {
        Assertions.assertThat(frameWthButton.isEnabled());
    }

    private String windowHomePage = "";

    @Step("Switch to iframe")
    public String switchToIframe() {
        windowHomePage = driver.getWindowHandle();
        driver.switchTo().frame("frame");
        return windowHomePage;
    }

    @Step("Switch to Window Home")
    public void switchToWindowHome() {
        driver.switchTo().window(windowHomePage);
    }

    @Step("Check frame button enabled")
    public void checkFrameButtonEnabled() {
        Assertions.assertThat(frameButton.isEnabled());
    }
}
