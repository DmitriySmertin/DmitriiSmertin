package com.epam.tc.hw5.cucumber.steps;

import io.cucumber.java.en.Then;

import static io.qameta.allure.Allure.step;

public class AssertionStep extends AbstractStep {


    @Then("All changes in the state of elements are reflected in the log window")
    public void checkLogWindow() {
        logWindow.checkWebElementInLogWindow(3, "Wind: condition changed to true");
        logWindow.checkWebElementInLogWindow(4, "Water: condition changed to true");
        logWindow.checkWebElementInLogWindow(2, "metal: value changed to Selen");
        logWindow.checkWebElementInLogWindow(1, "value changed to Yellow");
    }

    @Then("{string} page should be opened")
    public void checkOpenPage(String namePage) {
        indexPage.checkTitle(namePage);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkTypeDropdownsOnUserTable(int count) {
        userTablePage.checkCountTypeDropdownOnUserTable(count);
        userTablePage.checkTypeDropdownDisplayedOnUserTable();
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void checkUserNamesOnUserTable(int count) {
        userTablePage.checkCountUserNamesOnUserTable(count);
        userTablePage.checkUserNamesDisplayedOnUserTable();
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void checkTextDescrOnUserTable(int count) {
        userTablePage.checkCountTextDescriptionOnUserTable(count);
        userTablePage.checkTextDescriptionDisplayedOnUserTable();
    }
    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void verificationCheckboxesOnUserTable(int count)
    {
        userTablePage.checkCountCheckboxesOnUserTable(count);
        userTablePage.verificationCheckboxesDisplayedOnUserTable();
    }


}
