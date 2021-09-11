package com.epam.tc.hw7;

import com.epam.jdi.util.GsonParser;
import org.testng.annotations.DataProvider;
import java.io.IOException;

public class JsonDataProvider {


    @DataProvider(name = "dataJson")
    public static Object[][] metalsAndColorsDataSet() throws IOException {
        return GsonParser.parse("src/test/resources/metalsColorsDataSet.json");
    }
}
