package com.epam.tc.hw9;

import com.epam.api.dto.BoardDto;
import com.epam.api.services.PropertyService;
import com.epam.api.services.RestTrelloService;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    public RequestSpecification REQUEST_SPECIFICATION;
    public PropertyService prop = new PropertyService();
    public RestTrelloService restTrelloService = new RestTrelloService();
    public BoardDto[] boards = restTrelloService.getAllBoards();
    public Integer defaultCountBoard = 1;
    public String idList;

    @BeforeClass
    public void setup() {
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .addQueryParam("key", prop.getValue("API-Key"))
                .addQueryParam("token", prop.getValue("Token"))
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new ResponseLoggingFilter()).build();
    }

    @AfterClass
    public void tearDown() {
        if (boards.length != 0) {
            for (int i = 0; i < boards.length; i++) {
                restTrelloService.deleteBoardForId(boards[i].getId());
            }
            boards = restTrelloService.getAllBoards();
        }
    }
}