package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterSuite;


public abstract class SetUpAndTearDown {

    Calculator calculator = new Calculator();

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }
}


