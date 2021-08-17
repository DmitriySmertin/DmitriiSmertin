package com.epam.tc.hw3.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    Properties prop = new Properties();
    FileInputStream fis = null;

    public String getValue(String key) {
        try {
            fis = new FileInputStream("./src/test/resources/application.property");
            prop.load(fis);
            return prop.getProperty(key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
