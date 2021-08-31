package com.epam.tc.hw7;

import com.epam.jdi.JdiSite;
import com.epam.jdi.enteties.MetalsAndColorsInfo;
import com.epam.jdi.form.MetalsAndColorsForm;
import com.epam.jdi.util.GsonParser;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.jdi.JdiSite.*;
import static com.epam.jdi.enteties.User.*;
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
        metalsAndColorsForm.fill(metalsAndColorsInfo);
        metalsAndColorsForm.submit();
        Assertions.assertThat(metAndColPage.getResult()).isEqualTo(metAndColPage.expectResult(metalsAndColorsInfo));


    }
}
