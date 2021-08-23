package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.component.Header;
import com.epam.tc.page.IndexPage;
import io.cucumber.java.en.Given;

import static com.epam.tc.util.PropertiesUtil.getValue;

public abstract class AbstractStep {
    protected IndexPage indexPage;

    @Given("I open Index Page")
    public void openIndexPage() {
        indexPage.openPage(getValue("url.index"));
    }

    @Given("I perform authorization")
    public void authorization() {
        indexPage.login();
    }


}
