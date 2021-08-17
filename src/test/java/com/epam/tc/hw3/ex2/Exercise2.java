package com.epam.tc.hw3.ex2;

import com.epam.tc.hw2.SetUpAndTearDown;
import com.epam.tc.hw3.page.BasePage;
import com.epam.tc.hw3.page.DiffElementsPage.DiffElementsLogWindow;
import com.epam.tc.hw3.page.DiffElementsPage.DiffElementsPage;
import com.epam.tc.hw3.page.IndexPage.IndexPage;
import com.epam.tc.hw3.page.IndexPage.IndexPageHeader;
import com.epam.tc.hw3.page.IndexPage.IndexPageLeftMenu;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Exercise2 extends BasePage {

    @Test
    public void indexPageLoginAndDifferentElementsPageTest() {
        IndexPage indexPage = new IndexPage(driver);
        //1. Open test site by URL
        indexPage.openPage(propUtil.getValue("url.index"));
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
        logWindow.checkWaterCheckBox();
        logWindow.checkWindCheckBox();
        //•	for radio button there is a log row and value is corresponded to the status of radio button;
        logWindow.checkSelenRadioBtn();
        //• for dropdown there is a log row and value is corresponded to the selected value;
        logWindow.checkYellowColorDropbox();
        // 10. Close Browser(configured in BasePage.class)
    }

}
