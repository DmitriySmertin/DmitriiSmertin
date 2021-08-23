package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.component.Header;
import com.epam.tc.page.DiffElementsPage;
import io.cucumber.java.en.When;

public class ActionStep extends AbstractStep {
    protected Header header;
    protected DiffElementsPage diffElementsPage;

    @When("I open Different Elements Page")
    public void openDiffPage() {
        header.openDiffElementPage();
    }

    @When("I select {string} checkbox")
    public void selectCheckBox(String checkBox) {
        switch (checkBox) {
            case "Wind":
                diffElementsPage.selectWind();
            case "Water":
                diffElementsPage.selectWater();
            default:
                System.out.println("checkBox not selected");
        }
    }

    @When("I select {string} radiobutton")
    public void selectRadioBtn(String radioBtn) {
        switch (radioBtn) {
            case "Selen":
                diffElementsPage.selectSelen();
            default:
                System.out.println("radiobutton not selected");
        }
    }

    @When("I select {string} in dropdown")
    public void selectItemInDropdown(String item) {
        switch (item) {
            case "Yellow":
                diffElementsPage.selectYellow();
            default:
                System.out.println("item in dropdown not selected");
        }
    }


}
