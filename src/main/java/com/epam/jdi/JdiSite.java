package com.epam.jdi;

import com.epam.jdi.enteties.User;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.page.HomePage;
import com.epam.jdi.page.MetalsAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {
    @UI("//ul[contains(@class, 'm-l8')]/li/a")
    public static Menu header;
    public static HomePage homePage;
    public static MetalsAndColorsPage metAndColPage;

    public static void open() {
        homePage.open();
    }

    public static void login(User user) {
        homePage.login(user);

    }

    public static String getUserName() {
        return homePage.getUserName();
    }


}

