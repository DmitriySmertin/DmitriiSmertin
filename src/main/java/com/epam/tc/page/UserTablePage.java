package com.epam.tc.page;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class UserTablePage extends BasePage {

    public UserTablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "table#user-table tbody tr")
    List<WebElement> typeDropdownList;

    @FindBy(css = "table#user-table a")
    List<WebElement> userNameList;

    @FindBy(css = "div.user-descr span")
    List<WebElement> textDescriptionList;

    @FindBy(css = "div.user-descr input")
    List<WebElement> checkBoxesList;

    @FindBy(xpath = "((//select)[1])//option")
    List<WebElement> romanTypeList;

    @FindBy(id = "ivan")
    WebElement ivanCheckbox;

    public static List<Integer> typeIndexes = new ArrayList<Integer>();

    public static <T> List<Integer> getIndexesList(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            typeIndexes.add(i + 1);
        }
        return typeIndexes;
    }

    @Step("Check count type dropdown on user table on User Table Page")
    public void checkCountTypeDropdownOnUserTable(int count) {
        Assertions.assertThat(typeDropdownList.size()).isEqualTo(count);
    }

    @Step("Check displayed type dropdown on user table on User Table Page")
    public void checkTypeDropdownDisplayedOnUserTable() {
        for (int i = 0; i < typeDropdownList.size(); i++) {
            Assertions.assertThat(typeDropdownList.get(i).isDisplayed());
        }
    }

    @Step("Check count usernames on user table on User Table Page")
    public void checkCountUserNamesOnUserTable(int count) {
        Assertions.assertThat(userNameList.size()).isEqualTo(count);
    }

    @Step("Check displayed usernames on user table on User Table Page")
    public void checkUserNamesDisplayedOnUserTable() {
        for (int i = 0; i < userNameList.size(); i++) {
            Assertions.assertThat(userNameList.get(i).isDisplayed());
        }
    }

    @Step("Check count text description on user table on User Table Page")
    public void checkCountTextDescriptionOnUserTable(int count) {
        Assertions.assertThat(textDescriptionList.size()).isEqualTo(count);
    }

    @Step("Check displayed text description on user table on User Table Page")
    public void checkTextDescriptionDisplayedOnUserTable() {
        for (int i = 0; i < textDescriptionList.size(); i++) {
            Assertions.assertThat(textDescriptionList.get(i).isDisplayed());
        }
    }

    @Step("Check count checkboxes on user table on User Table Page")
    public void checkCountCheckboxesOnUserTable(int count) {
        Assertions.assertThat(checkBoxesList.size()).isEqualTo(count);
    }

    @Step("Check displayed checkboxes on user table on User Table Page")
    public void verificationCheckboxesDisplayedOnUserTable() {
        for (int i = 0; i < checkBoxesList.size(); i++) {
            Assertions.assertThat(checkBoxesList.get(i).isDisplayed());
        }
    }

    @Step("Check name, user, description block UserTable")
    public void checkUserTableNameUserDescr(int number, String user, String descr) {
        getIndexesList(typeDropdownList);
        Assertions.assertThat(number).isEqualTo(typeIndexes.get(number - 1));
        String expDescr = textDescriptionList.get(number - 1).getText().replaceAll("\n", " ");
        Assertions.assertThat(user).isEqualTo(userNameList.get(number - 1).getText());
        Assertions.assertThat(descr).isEqualTo(expDescr);
    }

    public List<String> getValueRoman() {
        List<String> romanValue = new ArrayList<>();
        for (int i = 0; i < romanTypeList.size(); i++) {
            romanValue.add(romanTypeList.get(i).getText());
        }
        return romanValue;
    }

    @Step("Click for checkbox Ivan")
    public void enableCheckboxIvan() {
        ivanCheckbox.click();
    }

}
