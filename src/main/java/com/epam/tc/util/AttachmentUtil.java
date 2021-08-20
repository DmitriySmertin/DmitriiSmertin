package com.epam.tc.util;

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

}
