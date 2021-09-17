package com.epam.tc.hw9;

import com.epam.api.dto.BoardDto;
import com.epam.api.services.PropertyService;
import com.epam.api.services.RestTrelloService;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;


public class BaseTest {
    public RequestSpecification REQUEST_SPECIFICATION;
    private final PropertyService prop = new PropertyService();
    public RestTrelloService restTrelloService = new RestTrelloService();;
    BoardDto[] boards = restTrelloService.getAllBoards();
    @BeforeMethod
    public void setup() {
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .addParam("key", prop.getValue("API-Key"))
                .addParam("token", prop.getValue("Token"))
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new ResponseLoggingFilter()).build();
    }

    @AfterClass
    public void tearDown()
    {
        for(int i=0;i<boards.length;i++)
        {
            restTrelloService.deleteBoardForId(boards[i].getId());
        }
        boards = restTrelloService.getAllBoards();
    }


}
