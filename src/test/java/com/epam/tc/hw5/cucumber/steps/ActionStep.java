package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.component.Header;
import com.epam.tc.page.DiffElementsPage;
import io.cucumber.java.en.When;

import java.util.Locale;

public class ActionStep extends AbstractStep {


    @When("I open Different Elements Page")
    public void openDiffPage() {
        header.openDiffElementPage();
    }

    @When("I select {string} checkbox")
    public void selectCheckBox(String checkBox) {
        switch (checkBox) {
            case "Wind":
                diffElementsPage.selectWind();
                break;
            case "Water":
                diffElementsPage.selectWater();
                break;
            default:
                System.out.println("checkBox not selected");
                break;
        }
    }

    @When("I select {string} radiobutton")
    public void selectRadioBtn(String radioBtn) {
        switch (radioBtn) {
            case "Selen":
                diffElementsPage.selectSelen();
                break;
            default:
                System.out.println("radiobutton not selected");
                break;
        }
    }

    @When("I select {string} in dropdown")
    public void selectItemInDropdown(String item) {
        switch (item) {
            case "Yellow":
                diffElementsPage.selectYellow();
                break;
            default:
                System.out.println("item in dropdown not selected");
                break;
        }
    }

    @When("I click on {string} button in Header")
    public void openItemButtonInHeader(String item) {
        switch (item.toLowerCase(Locale.ROOT)) {
            case "service":
                header.openServiceMenu();
                break;
            default:
                System.out.println(item + " button not exist");
                break;
        }


    }

    @When("I click on {string} button in Service dropdown")
    public void selectItemInServiceDropdown (String item)
    {
        switch (item.toLowerCase(Locale.ROOT))
        {
            case "user table":
                header.openUserTable();
                break;
            default:
                System.out.println(item + " item not exist");
                break;
        }

    }
}
