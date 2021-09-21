package com.epam.tc.hw9;

import com.epam.api.dto.BoardDto;
import com.epam.api.services.PropertyService;
import com.epam.api.services.RestTrelloAssertion;
import com.epam.api.services.RestTrelloService;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest extends RestTrelloAssertion {
    public RestTrelloService restTrelloService = new RestTrelloService();
    public BoardDto[] boards = restTrelloService.getAllBoards();
    public String idList;

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