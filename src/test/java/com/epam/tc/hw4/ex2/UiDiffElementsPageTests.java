package com.epam.tc.hw4.ex2;

import com.epam.tc.page.BasePage;
import com.epam.tc.page.DiffElementsPage;
import com.epam.tc.page.IndexPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.epam.tc.util.PropertiesUtil.getValue;
import static io.qameta.allure.Allure.step;

public class UiDiffElementsPageTests extends BasePage {

    @Test(description = "Test login,change the states of elements on DiffElements Page and records of log window")
    @Feature("Authorization")
    @Feature("Log Window")
    @Story("Login on IndexPage")
    @Story("Logging in the LogWindow")
    public void indexPageLoginAndDifferentElementsPageTest() {
        IndexPage indexPage = new IndexPage(driver);
        step("1. Open test site by URL");
        //1. Open test site by URL
        indexPage.openPage(getValue("url.index"));
        step("2. Assert Browser title");
        indexPage.checkTitle("Home Page");
        step("3. Perform login");
        indexPage.login(getValue("user.login"));
        step("4. Assert Username is loggined");
        indexPage.checkLogin();
        step("5. Open through the header menu Service -> Different Elements Page");
        header.openDiffElementPage();
        DiffElementsPage diffElementsPage = new DiffElementsPage(driver);
        diffElementsPage.checkTitle("Different Elements");
        step("6. Select checkboxes Water and Wind");
        diffElementsPage.selectWater();
        diffElementsPage.selectWind();
        step("7. Select radio Selen");
        diffElementsPage.selectSelen();
        step("8. Select in dropdown Yellow");
        diffElementsPage.selectYellow();
        step("9a. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox");
        logWindow.checkWebElementInLogWindow(4, "Water: condition changed to true");
        logWindow.checkWebElementInLogWindow(3, "Wind: condition changed to true");
        step("9b. Assert that for radio button there is a log row and value is corresponded to the status of radio button");
        logWindow.checkWebElementInLogWindow(2, "metal: value changed to Selen");
        step("9c. Assert that for dropdown there is a log row and value is corresponded to the selected value");
        logWindow.checkWebElementInLogWindow(1, "value changed to Yellow");
        step("10. Close Browser(configured in BasePage.class)");
    }

}
