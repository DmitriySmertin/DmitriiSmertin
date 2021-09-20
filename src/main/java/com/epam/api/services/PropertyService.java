package com.epam.api.services;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyService {
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
}