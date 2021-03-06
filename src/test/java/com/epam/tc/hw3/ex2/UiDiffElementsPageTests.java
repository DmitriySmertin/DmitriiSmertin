package com.epam.tc.hw3.ex2;

import com.epam.tc.page.DiffElementsPage;
import com.epam.tc.page.IndexPage;
import com.epam.tc.page.BasePage;
import org.testng.annotations.Test;


import static com.epam.tc.util.PropertiesUtil.getValue;

public class UiDiffElementsPageTests extends BasePage {

    @Test
    public void indexPageLoginAndDifferentElementsPageTest() {
        IndexPage indexPage = new IndexPage(driver);
        //1. Open test site by URL
        indexPage.openPage(getValue("url.index"));
        //2. Assert Browser title
        indexPage.checkTitle("Home Page");
        //3. Perform login
        indexPage.login(getValue("user.login"));
        //4. Assert Username is loggined
        indexPage.checkLogin();
        //5. Open through the header menu Service -> Different Elements Page
        header.openDiffElementPage();
        DiffElementsPage diffElementsPage = new DiffElementsPage(driver);
        diffElementsPage.checkTitle("Different Elements");
        //6. Select checkboxes
        diffElementsPage.selectWater();
        diffElementsPage.selectWind();
        //7. Select radio
        diffElementsPage.selectSelen();
        //8. Select in dropdown
        diffElementsPage.selectYellow();
        //* 9. Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox;
        logWindow.checkWebElementInLogWindow(4, "Water: condition changed to true");
        logWindow.checkWebElementInLogWindow(3, "Wind: condition changed to true");
        //•	for radio button there is a log row and value is corresponded to the status of radio button;
        logWindow.checkWebElementInLogWindow(2, "metal: value changed to Selen");
        //• for dropdown there is a log row and value is corresponded to the selected value;
        logWindow.checkWebElementInLogWindow(1, "value changed to Yellow");
        // 10. Close Browser(configured in BasePage.class)
    }
}

