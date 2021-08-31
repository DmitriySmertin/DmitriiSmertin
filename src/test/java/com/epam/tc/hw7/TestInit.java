package com.epam.tc.hw7;

import com.epam.jdi.JdiSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;

public interface TestInit {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        initElements(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public static void TearDown()
    {
        killAllSeleniumDrivers();
    }
}
