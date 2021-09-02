package com.epam.tc.hw7;

import com.epam.jdi.enteties.MetalsAndColorsInfo;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

import static com.epam.jdi.JdiSite.*;
import static com.epam.jdi.enteties.User.ROMAN;
import static com.epam.jdi.form.MetalsAndColorsForm.vegetable;
import static com.epam.jdi.form.MetalsAndColorsForm.vegetablesMultiDropdown;
import static com.epam.jdi.page.MetalsAndColorsPage.metalsAndColorsForm;

public class UiMetalsAndColorsPageTest implements TestInit {

    @BeforeTest
    public void loginAsRoman() {
        open();
        login(ROMAN);
        homePage.userName.is().text(ROMAN.getFullName());
    }

    @Test(dataProvider = "dataJson", dataProviderClass = JsonDataProvider.class)
    public void resultFormOnMetalsAndColorsPageTest(MetalsAndColorsInfo metalsAndColorsInfo) {

        header.select("Metals & Colors");
        metAndColPage.checkOpened();
        vegetable.click();
        vegetablesMultiDropdown.select("Vegetables");
        metalsAndColorsForm.fill(metalsAndColorsInfo);
        metalsAndColorsForm.submit();
        List<String> actResult = metAndColPage.getResult();
        List<String> expResult = metAndColPage.expectResult(metalsAndColorsInfo);
//        assertThat(actResult).isEqualTo(expResult);
    }
}
