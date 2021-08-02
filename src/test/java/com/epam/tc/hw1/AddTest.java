package com.epam.tc.hw1;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class AddTest extends SetUpAndTearDown {

    @DataProvider
    public static Object[][] correctData() {
        return new Object[][]{{1, 2, 3}, {10, 12, 22}, {40, 15, 55}, {6, 10, 16}};
    }

    @Test(dataProvider = "correctData")
    public void firstAddTest(long a, long b, long result) {
        long actualRes = calculator.sum(a, b);
        Assertions.assertThat(actualRes).as("Calculation is wrong").isEqualTo(result);
    }
}
