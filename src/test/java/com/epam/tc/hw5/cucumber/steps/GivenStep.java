package com.epam.tc.hw5.cucumber.steps;

import io.cucumber.java.en.Given;

import static com.epam.tc.util.PropertiesUtil.getValue;

public class GivenStep extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openIndexPage() {
        indexPage.openPage(getValue("url.index"));
    }

    @Given("I login as user {string}")
    public void authorization(String login) {
        indexPage.login(login);
    }
}
