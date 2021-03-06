package com.epam.tc.hw3.ex1;


import com.epam.tc.page.IndexPage;
import com.epam.tc.page.BasePage;
import org.testng.annotations.Test;

import static com.epam.tc.util.PropertiesUtil.getValue;

public class UiIndexPageTests extends BasePage {

    @Test
    public void indexPageLoginAndFillingPageContentTest() {

        IndexPage indexPage = new IndexPage(driver);
        //1. Open test site by URL
        indexPage.openPage(getValue("url.index"));
        //2. Assert Browser title
        indexPage.checkTitle("Home Page");
        //3. Perform login
        indexPage.login(getValue("user.login"));
        //4. Assert Username is loggined
        indexPage.checkLogin();
        //5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        header.checkItemsHeaderMenu();
        //6. Assert that there are 4 images on the Index Page, and they are displayed
        indexPage.checkImgCount(4);
        indexPage.checkImgDisplayed();
        //7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        indexPage.checkBenefitTextCount(4);
        indexPage.checkBenefitTextDisplayed();
        //8. Assert that there is the iframe with “Frame Button” exist
        indexPage.checkFrameWthButtonEnabled();
        //9.  Switch to the iframe and check that there is “Frame Button” in the iframe
        indexPage.switchToIframe();
        indexPage.checkFrameButtonEnabled();
        //10. Switch to original window back
        indexPage.switchToWindowHome();
        //11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        leftMenu.checkCountLeftMenuItems(5);
        leftMenu.checkTextAndDisplayedItems();
        //12. Close Browser(configured in BasePage.class)
    }

}
