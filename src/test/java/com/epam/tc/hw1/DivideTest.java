package com.epam.tc.hw1;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivideTest extends SetUpAndTearDown {

    @DataProvider
    public static Object[][] correctData() {
        return new Object[][]{{4, 2, 2}, {10, 10, 1}, {100, 2, 50}, {1, 2, 0}};
    }

    @Test(dataProvider = "correctData")
    public void firstDivideTest(long a, long b, long result) {
        long actualRes = calculator.div(a, b);
        Assertions.assertThat(actualRes).as("Calculation is wrong").isEqualTo(result);
    }
}
