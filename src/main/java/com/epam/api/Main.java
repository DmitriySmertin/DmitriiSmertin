package com.epam.api;

import com.epam.api.dto.BoardDto;
import com.epam.api.services.CommonService;
import com.epam.api.services.PropertyService;
import com.epam.api.services.RestTrelloService;
import com.epam.api.services.URI;
import io.restassured.specification.RequestSpecification;

import static com.epam.api.services.PropertyService.getValue;
import static com.epam.api.services.PropertyService.setValue;
import static com.epam.api.services.URI.CREATE_NEW_BOARD_URI;

public class Main {
    public static void main(String[] args) {
        PropertyService prop = new PropertyService();
        setValue("asdasldkas", "IdBoard");
        System.out.println(getValue("IdBoard"));

    }



}
