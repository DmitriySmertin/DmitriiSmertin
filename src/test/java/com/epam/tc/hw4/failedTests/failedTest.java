package com.epam.tc.hw4.failedTests;

import com.epam.tc.hw3.page.IndexPage.IndexPage;
import com.epam.tc.hw3.page.IndexPage.IndexPageHeader;
import com.epam.tc.hw3.page.IndexPage.IndexPageLeftMenu;
import com.epam.tc.hw4.page.BasePage;
import org.testng.annotations.Test;

public class failedTest extends BasePage {

    @Test
    public void indexPageLoginAndFillingPageContentFailTest() {

        IndexPage indexPage = new IndexPage(driver);
        //1. Open test site by URL
        indexPage.openPage(propUtil.getValue("url.index"));
        //2. Assert Browser title
        indexPage.checkTitle();
        //3. Perform login
        indexPage.login();
        //4. Assert Username is loggined
        indexPage.checkLogin();
        //5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        IndexPageHeader header = new IndexPageHeader(driver);
        header.checkItemsHeaderMenu();
        //6. Assert that there are 4 images on the Index Page, and they are displayed
        indexPage.checkImgCount();
        indexPage.checkImgDisplayed();
        //7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        indexPage.checkBenefitTextCount();
        indexPage.checkBenefitTextDisplayed();
        //8. Assert that there is the iframe with “Frame Button” exist
        indexPage.checkFrameWthButtonEnabled();
        //9.  Switch to the iframe and check that there is “Frame Button” in the iframe
        indexPage.switchToIframe();
        indexPage.checkFrameButtonEnabled();
        //10. Switch to original window back
        indexPage.switchToWindowHome();
        //11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        IndexPageLeftMenu leftMenu = new IndexPageLeftMenu(driver);
        leftMenu.checkCountLeftMenuItems();
        leftMenu.checkTextAndDisplayedItems();
        //12. Close Browser(configured in BasePage.class)
    }

}
