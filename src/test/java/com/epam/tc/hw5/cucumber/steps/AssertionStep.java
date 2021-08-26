package com.epam.tc.hw5.cucumber.steps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.Map;

public class AssertionStep extends AbstractStep {


    @Then("All changes in the state of elements are reflected in the log window")
    public void checkLogWindow() {
        logWindow.checkWebElementInLogWindow(4, "Water: condition changed to true");
        logWindow.checkWebElementInLogWindow(3, "Wind: condition changed to true");
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
    public void verificationCheckboxesOnUserTable(int count) {
        userTablePage.checkCountCheckboxesOnUserTable(count);
        userTablePage.verificationCheckboxesDisplayedOnUserTable();
    }

    @Then("User table should contain following values:")
    public void checkUserTables(DataTable table) {
        List<Map<String, String>> userList = table.asMaps(String.class, String.class);
        for (int i = 0; i < userList.size(); i++)
            userTablePage.checkUserTableNameUserDescr(
                    Integer.parseInt(userList.get(i).get("number")),
                    userList.get(i).get("user"),
                    userList.get(i).get("description"));

    }

    @Then("droplist should contain values in column Type for user Roman:")
    public void checkUserDroplistType(DataTable table) {
        List<String> dropdownList = table.asList(String.class);
        for (int i = 0; i < dropdownList.size() - 1; i++) {
            String actualDropdownValue = userTablePage.getValueRoman().get(i);
            String expectedDropdownValue = dropdownList.get(i + 1);
            Assertions.assertThat(actualDropdownValue).isEqualTo(expectedDropdownValue);
        }

    }

    @Then("{int} log row has {string} text in log section")
    public void checkRowHasTextInLogWindow(int count, String text) {
        logWindow.checkWebElementInLogWindow(count, text);
    }

}
