package com.epam.tc.hw2;

public abstract class BaseExerciseClass extends SetUpAndTearDown {
    private final static String INDEX_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    private final static String EXPECTED_BROWSER_TITLE = "Home Page";
    private final static String USER_NAME = "Roman";
    private final static String USER_PASS = "Jdi1234";
    private final static String EXPECTED_USER_LOGIN = "ROMAN IOVLEV";

    public String getIndexUrl() {
        return INDEX_URL;
    }

    public String getExpectedBrowserTitle() {
        return EXPECTED_BROWSER_TITLE;
    }

    public String getUserName() {
        return USER_NAME;
    }

    public String getUserPass() {
        return USER_PASS;
    }

    public String getExpectedUserLogin() {
        return EXPECTED_USER_LOGIN;
    }


}
