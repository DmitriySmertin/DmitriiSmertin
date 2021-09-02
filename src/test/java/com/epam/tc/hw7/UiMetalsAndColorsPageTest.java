package com.epam.tc.hw7;

import com.epam.jdi.enteties.MetalsAndColorsInfo;
import org.testng.annotations.Test;


import static com.epam.jdi.JdiSite.*;
import static com.epam.jdi.enteties.User.ROMAN;
import static com.epam.jdi.form.MetalsAndColorsForm.vegetable;
import static com.epam.jdi.form.MetalsAndColorsForm.vegetablesMultiDropdown;
import static com.epam.jdi.page.MetalsAndColorsPage.metalsAndColorsForm;
import static com.epam.jdi.util.TextResultWindowCreatorUtil.expectResult;
import static org.assertj.core.api.Assertions.assertThat;

public class UiMetalsAndColorsPageTest implements TestInit {

    @Test(dataProvider = "dataJson", dataProviderClass = JsonDataProvider.class)
    public void resultFormOnMetalsAndColorsPageTest(MetalsAndColorsInfo metalsAndColorsInfo) {
        open();
        login(ROMAN);
        homePage.userName.is().text(ROMAN.getFullName());
        header.select("Metals & Colors");
        metAndColPage.checkOpened();
        vegetable.click();
        vegetablesMultiDropdown.select("Vegetables");
        metalsAndColorsForm.fill(metalsAndColorsInfo);
        metalsAndColorsForm.submit();
        assertThat(metAndColPage.getResult())
                .as("Actual text doesn't match with expected result")
                .isEqualTo(expectResult(metalsAndColorsInfo));
        homePage.logout();
    }
}
