package com.epam.tc.hw2;

public class GeneralData {
    private final String indexUrl = "https://jdi-testing.github.io/jdi-light/index.html";
    private final String expectedBrowserTitle = "Home Page";
    private final String userName = "Roman";
    private final String userPass = "Jdi1234";
    private final String expectedUserLogin = "ROMAN IOVLEV";

    public String getIndexUrl() {
        return indexUrl;
    }

    public String getExpectedBrowserTitle() {
        return expectedBrowserTitle;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public String getExpectedUserLogin() {
        return expectedUserLogin;
    }


}
