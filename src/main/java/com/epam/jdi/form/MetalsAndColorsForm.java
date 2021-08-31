package com.epam.jdi.form;

import com.epam.jdi.enteties.MetalsAndColorsInfo;
import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;


public class MetalsAndColorsForm extends Form<MetalsAndColorsInfo> {
    @JDropdown(root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret"
    )
    public static Dropdown colors;

    @JDropdown(root = "div[ui='combobox']",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown metals;

    @JDropdown(root = "#salad-dropdown",
            value = ".filter-option",
            list = "label",
            expand = ".caret")
    public static Dropdown salad;
    @UI("#vegetables")
    public static Button vegetable;

    @UI("#elements-checklist input")
    public static Checklist elementsChecklist;

    @UI("section.horizontal-group input")
    public static RadioButtons summary;

    @JDropdown(root = "div[ui=droplist]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown vegetablesMultiDropdown;

    @Css("[type=checkbox][checked=\"checked\"]")
    public static Checkbox selectedVegetable;

    @UI("button#submit-button")
    public Button submitBtn;


    @Override
    public void fill(MetalsAndColorsInfo metalsAndColors) {
        summary.select(metalsAndColors.getSummary().get(0).toString());
        summary.select(metalsAndColors.getSummary().get(1).toString());
        metalsAndColors.getElements().forEach(elementsChecklist::select);
        colors.select(metalsAndColors.getColor());
        metals.select(metalsAndColors.getMetals());
        vegetable.click();
        if (selectedVegetable.isDisplayed()) {
            vegetablesMultiDropdown.select("Vegetables");
        }
        metalsAndColors.getVegetables().forEach(vegetablesMultiDropdown::select);
    }

    @Override
    public void submit() {
        submitBtn.click();
    }

}
