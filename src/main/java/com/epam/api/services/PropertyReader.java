package com.epam.api.services;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static Properties prop = new Properties();
    private static FileInputStream fis = null;

    public static String getValue(String key) {
        try {
            fis = new FileInputStream("./src/test/resources/test.properties");
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

    public static String getKey() {
        return getValue("API-Key");
    }

    public static String getToken() {
        return getValue("Token");
    }

    public static String getBaseUri() {
        return getValue("BaseUri");
    }
}