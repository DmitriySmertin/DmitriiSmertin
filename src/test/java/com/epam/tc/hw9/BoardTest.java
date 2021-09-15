package com.epam.tc.hw9;

import com.epam.api.services.PropertyService;
import com.epam.api.services.RestTrelloService;
import com.epam.api.services.URI;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import netscape.javascript.JSObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.api.services.PropertyService.getValue;
import static com.epam.api.services.URI.GET_ALL_BOARDS_URI;

public class BoardTest extends BaseTest{
    PropertyService prop = new PropertyService();
    RequestSpecification REQUEST_SPECIFICATION;
    String token = getValue("Token");
    String key = getValue("API-Key");
    String endpoint = "/1/members/me/boards/";

    @BeforeMethod
    public void setup() {
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .addParam("key", prop.getValue("API-Key"))
                .addParam("token",prop.getValue("Token"))
                .addFilter(new ResponseLoggingFilter()).build();
    }


    @Test
    public void getAllBoards()
    {
        RestAssured.given()
                .get("https://api.trello.com/1/members/me/boards/?key=e6aa340f0a408510fa586d960a277c5e&token=0f4780c5df167bb5225c2676d5b994fde1da74adc30826f009b98e50c7b418e2")
                .prettyPrint();
    }

    @Test
    public void getAllBoards2()
    {
        PropertyService prop = new PropertyService();
        RestAssured.given()
                .get("https://api.trello.com/1/members/me/boards/?key="+key+
                        "&token="+token)
                .prettyPrint();
    }
    @Test
    public void getAllBoards3()
    {
        String uri = "/1/members/me/boards/";
        PropertyService prop = new PropertyService();

        RestAssured.given(REQUEST_SPECIFICATION)
                .get(GET_ALL_BOARDS_URI).prettyPrint();
    }
    @Test
    public void getAllBoards4()
    {
        RestAssured.given(REQUEST_SPECIFICATION)
                .param("name", "NewBoard")
                .post(URI.CREATE_NEW_BOARD);

    }
}
