package com.epam.tc.hw4.ex1;

import com.epam.tc.hw4.page.BasePage;
import com.epam.tc.hw4.page.IndexPage.IndexPage;
import com.epam.tc.hw4.page.IndexPage.IndexPageHeader;
import com.epam.tc.hw4.page.IndexPage.IndexPageLeftMenu;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;

public class Exercise1 extends BasePage {

    @Test(description = "Test login and filling content Index Page")
    @Feature("Authorization")
    @Feature("Header")
    @Feature("Left Menu")
    @Feature("Frame on IndexPage")
    @Story("Login on IndexPage")

    public void indexPageLoginAndFillingPageContentTest() {
        attachProperty();
        IndexPage indexPage = new IndexPage(driver);
        step("1. Open test site by URL");
        indexPage.openPage(propUtil.getValue("url.index"));
        step("2. Assert Browser title");
        indexPage.checkTitle("Home Page");
        step("3. Perform login");
        indexPage.login();
        step("4. Assert Username is loggined");
        indexPage.checkLogin();
        step("5. Assert that there are 4 items on the header section are displayed, and they have proper texts");
        IndexPageHeader header = new IndexPageHeader(driver);
        header.checkItemsHeaderMenu();
        step("6. Assert that there are 4 images on the Index Page, and they are displayed");
        indexPage.checkImgCount(4);
        indexPage.checkImgDisplayed();
        step("7. Assert that there are 4 texts on the Index Page under icons, and they have proper text");
        indexPage.checkBenefitTextCount(4);
        indexPage.checkBenefitTextDisplayed();
        step("8. Assert that there is the iframe with “Frame Button” exist");
        indexPage.checkFrameWthButtonEnabled();
        step("9.  Switch to the iframe and check that there is “Frame Button” in the iframe");
        indexPage.switchToIframe();
        indexPage.checkFrameButtonEnabled();
        step("10. Switch to original window back");
        indexPage.switchToWindowHome();
        step("11. Assert that there are 5 items in the Left Section are displayed, and they have proper text");
        IndexPageLeftMenu leftMenu = new IndexPageLeftMenu(driver);
        leftMenu.checkCountLeftMenuItems(5);
        leftMenu.checkTextAndDisplayedItems();
        step("12. Close Browser(configured in BasePage.class)");
    }

}
