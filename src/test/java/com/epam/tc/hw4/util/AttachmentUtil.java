package com.epam.tc.hw4.util;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import lombok.experimental.UtilityClass;

import java.io.InputStream;

@UtilityClass
public class AttachmentUtil {

    @Attachment
    public void attachFromInputStream(final String name, InputStream inputStream) {
        Allure.addAttachment(name, inputStream);
    }

    @Attachment(type = "image/png", value = "try to use param {name}")
    public byte[] makeScreenshotAttachment(final String name, final byte[] source) {
        return source;
    }

}
