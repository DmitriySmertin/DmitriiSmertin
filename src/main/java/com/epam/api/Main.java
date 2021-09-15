package com.epam.api;

import com.epam.api.dto.BoardDto;
import com.epam.api.services.CommonService;
import com.epam.api.services.PropertyService;
import com.epam.api.services.RestTrelloService;
import com.epam.api.services.URI;
import io.restassured.specification.RequestSpecification;

public class Main {
    public static void main(String[] args) {

        PropertyService prop = new PropertyService();
        RestTrelloService restTrelloService = new RestTrelloService();
        restTrelloService.getNoParams(URI.GET_ALL_BOARDS_URI).prettyPrint();
    }



}
