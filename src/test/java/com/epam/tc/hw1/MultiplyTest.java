package com.epam.tc.hw1;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class MultiplyTest extends SetUpAndTearDown {
    @DataProvider
    public static Object[][] correctData() {
        return new Object[][]{{10, 2, 20}, {1, 1, 1}, {15, 2, 30}, {2, 2, 4}};
    }

    @Test(dataProvider = "correctData")
    public void firstMultiplyTest(long a, long b, long result) {
        long actualRes = calculator.mult(a, b);
        Assertions.assertThat(actualRes).as("Calculation is wrong").isEqualTo(result);
    }
}
