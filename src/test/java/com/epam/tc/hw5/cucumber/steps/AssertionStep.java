package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.component.LogWindow;
import com.epam.tc.page.DiffElementsPage;
import io.cucumber.java.en.Then;

import static io.qameta.allure.Allure.step;

public class AssertionStep extends AbstractStep{

    protected LogWindow logWindow;
    protected DiffElementsPage diffElementsPage;

    @Then("All changes in the state of elements are reflected in the log window")
    public void checkLogWindow(int position, String element)
    {
        logWindow.checkWebElementInLogWindow(3, "Wind: condition changed to true");
        logWindow.checkWebElementInLogWindow(4, "Water: condition changed to true");
        step("9b. Assert that for radio button there is a log row and value is corresponded to the status of radio button");
        logWindow.checkWebElementInLogWindow(2, "metal: value changed to Selen");
        step("9c. Assert that for dropdown there is a log row and value is corresponded to the selected value");
        logWindow.checkWebElementInLogWindow(1, "value changed to Yellow");
    }

}
