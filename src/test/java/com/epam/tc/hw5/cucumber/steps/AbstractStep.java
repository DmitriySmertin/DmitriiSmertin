package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.component.Header;
import com.epam.tc.component.LogWindow;
import com.epam.tc.hw5.cucumber.context.TestContext;
import com.epam.tc.page.DiffElementsPage;
import com.epam.tc.page.IndexPage;
import com.epam.tc.page.UserTablePage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import static com.epam.tc.util.PropertiesUtil.getValue;

public abstract class AbstractStep {
    protected IndexPage indexPage;
    protected UserTablePage userTablePage;
    protected Header header;
    protected DiffElementsPage diffElementsPage;
    protected LogWindow logWindow;



    public AbstractStep() {
        WebDriver driver = TestContext.getInstance().getTestObject("web_driver");
        indexPage = new IndexPage(driver);
        userTablePage = new UserTablePage(driver);
        header = new Header(driver);
        diffElementsPage = new DiffElementsPage(driver);
        logWindow = new LogWindow(driver);
    }



}
