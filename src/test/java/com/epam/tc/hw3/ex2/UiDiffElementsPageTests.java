package com.epam.tc.hw3.ex2;

import com.epam.tc.hw2.SetUpAndTearDown;
import com.epam.tc.page.DiffElementsPage.DiffElementsPage;
import com.epam.tc.page.DiffElementsPage.DiffElementsLogWindow;
import com.epam.tc.page.IndexPage.IndexPage;
import com.epam.tc.page.BasePage;
import com.epam.tc.page.IndexPage.IndexPageHeader;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        indexPage.login();
        //4. Assert Username is loggined
        indexPage.checkLogin();
        //5. Open through the header menu Service -> Different Elements Page
        IndexPageHeader header = new IndexPageHeader(driver);
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
        DiffElementsLogWindow logWindow = new DiffElementsLogWindow(driver);
        logWindow.checkWebElementInLogWindow(4, "Water: condition changed to true");
        logWindow.checkWebElementInLogWindow(3, "Wind: condition changed to true");
        //•	for radio button there is a log row and value is corresponded to the status of radio button;
        logWindow.checkWebElementInLogWindow(2, "metal: value changed to Selen");
        //• for dropdown there is a log row and value is corresponded to the selected value;
        logWindow.checkWebElementInLogWindow(1, "value changed to Yellow");
        // 10. Close Browser(configured in BasePage.class)
    }
}

