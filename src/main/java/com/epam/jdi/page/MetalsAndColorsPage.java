package com.epam.jdi.page;

import com.epam.jdi.enteties.MetalsAndColorsInfo;
import com.epam.jdi.form.MetalsAndColorsForm;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.lang.String.join;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {
    @Css("form")
    public static MetalsAndColorsForm metalsAndColorsForm;

    @Css(".results li")
    private static List<UIElement> resultWindow;

    public static List<String> getResult() {
        return resultWindow.stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    public List<String> expectResult(MetalsAndColorsInfo data) {
        List<String> expectedResult = new ArrayList<>();

        expectedResult.add(format("Summary: %s", (data.getSummary().get(0) + data.getSummary().get(1))));
        expectedResult.add(format("Elements: %s", join(", ", data.getElements())));
        expectedResult.add(format("Color: %s", data.getColor()));
        expectedResult.add(format("Metal: %s", data.getMetals()));
        expectedResult.add(format("Vegetables: %s", join(", ", data.getVegetables())));

        return expectedResult;
    }


}
