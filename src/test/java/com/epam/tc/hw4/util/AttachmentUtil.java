package com.epam.tc.hw4.util;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import lombok.experimental.UtilityClass;

import java.io.InputStream;

@UtilityClass
public class AttachmentUtil {

    public void attachFromInputStream(final String name, InputStream inputStream) {
        Allure.addAttachment(name, inputStream);
    }

}
