package com.epam.jdi.util;

import com.epam.jdi.enteties.MetalsAndColorsInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.lang.String.join;

public final class TextResultWindowCreatorUtil {

    public static List<String> expectResult(MetalsAndColorsInfo data) {
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add(format("Summary: %s", (data.getSummary().get(0) + data.getSummary().get(1))));
        expectedResult.add(format("Elements: %s", join(", ", data.getElements())));
        expectedResult.add(format("Color: %s", data.getColor()));
        expectedResult.add(format("Metal: %s", data.getMetals()));
        expectedResult.add(format("Vegetables: %s", join(", ", data.getVegetables())));

        return expectedResult;
    }
}
