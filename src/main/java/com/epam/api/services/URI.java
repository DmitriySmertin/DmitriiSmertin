package com.epam.api.services;

import static com.epam.api.services.PropertyService.getValue;

public class URI {
    PropertyService prop = new PropertyService();
    private static final String BASE_URI = getValue("BaseUri");
    public static final String GET_ALL_BOARDS_URI = BASE_URI + "/1/members/me/boards/";
    public static final String CREATE_NEW_BOARD = BASE_URI + "/1/boards/";
}
