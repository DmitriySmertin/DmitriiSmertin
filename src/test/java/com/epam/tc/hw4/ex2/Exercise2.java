package com.epam.tc.hw4.ex2;

import com.epam.tc.hw4.page.BasePage;
import com.epam.tc.hw4.page.DiffElementsPage.DiffElementsLogWindow;
import com.epam.tc.hw4.page.DiffElementsPage.DiffElementsPage;
import com.epam.tc.hw4.page.IndexPage.IndexPage;
import com.epam.tc.hw4.page.IndexPage.IndexPageHeader;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;

public class Exercise2 extends BasePage {

    @Test(description = "Test login,change the states of elements on DiffElements Page and records of log window")
    @Feature("Login")
    @Feature("Elements on DiffElements Page")
    @Feature("LogWindow")
    @Story("Login in IndexPage")
    @Story("The log window records changes in the states of the elements")
    public void indexPageLoginAndDifferentElementsPageTest() {
        attachProperty();
        IndexPage indexPage = new IndexPage(driver);
        step("1. Open test site by URL");
        //1. Open test site by URL
        indexPage.openPage(propUtil.getValue("url.index"));
        step("2. Assert Browser title");
        indexPage.checkTitle("Home Page");
        step("3. Perform login");
        indexPage.login();
        step("4. Assert Username is loggined");
        indexPage.checkLogin();
        step("5. Open through the header menu Service -> Different Elements Page");
        IndexPageHeader header = new IndexPageHeader(driver);
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
        DiffElementsLogWindow logWindow = new DiffElementsLogWindow(driver);
        logWindow.checkWebElementInLogWindow(3, "Wind: condition changed to true");
        logWindow.checkWebElementInLogWindow(4, "Water: condition changed to true");
        step("9b. Assert that for radio button there is a log row and value is corresponded to the status of radio button");
        logWindow.checkWebElementInLogWindow(2, "metal: value changed to Selen");
        step("9c. Assert that for dropdown there is a log row and value is corresponded to the selected value");
        logWindow.checkWebElementInLogWindow(1, "value changed to Yellow");
        step("10. Close Browser(configured in BasePage.class)");
    }

}
