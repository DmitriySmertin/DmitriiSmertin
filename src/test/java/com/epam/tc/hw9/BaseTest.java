package com.epam.tc.hw9;

import com.epam.api.services.PropertyService;
import com.epam.api.services.RestTrelloService;
import com.epam.api.services.URI;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private RequestSpecification REQUEST_SPECIFICATION;
    PropertyService prop = new PropertyService();
    RestTrelloService restTrelloService = new RestTrelloService();





}
