package com.epam.tc.hw1;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SubtractTest extends SetUpAndTearDown {

    @DataProvider
    public static Object[][] correctData() {
        return new Object[][]{{49, 4, 45}, {4, 1, 3}, {66, 6, 60}, {-1, 2, -3}};
    }

    @Test(dataProvider = "correctData")
    public void firstSubtractTest(long a, long b, long result) {
        long actualRes = calculator.sub(a, b);
        Assertions.assertThat(actualRes).as("Calculation is wrong").isEqualTo(result);
    }

}
