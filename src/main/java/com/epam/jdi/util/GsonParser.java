package com.epam.jdi.util;

import com.epam.jdi.enteties.MetalsAndColorsInfo;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

public class GsonParser {

    public static Object[][] parse(String path) throws IOException {
        Gson gson = new Gson();
        Object[][] dataObject;
        Type type = new TypeToken<Map<String, MetalsAndColorsInfo>>() {
        }.getType();
        Map<String, MetalsAndColorsInfo> myMap = gson.fromJson(new JsonReader(new FileReader(path)), type);
        int i = 0;
        dataObject = new Object[myMap.size()][1];
        for (Map.Entry<String, MetalsAndColorsInfo> entry : myMap.entrySet()) {
            dataObject[i][0] = entry.getValue();
            i++;
        }
        return dataObject;
    }
}
