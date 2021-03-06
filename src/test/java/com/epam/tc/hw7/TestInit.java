package com.epam.tc.hw7;

import com.epam.jdi.JdiSite;
import com.epam.jdi.page.HomePage;
import com.epam.tc.page.IndexPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.JdiSite.*;
import static com.epam.jdi.enteties.User.ROMAN;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;

public interface TestInit {
    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        initSite(JdiSite.class);
    }
}
