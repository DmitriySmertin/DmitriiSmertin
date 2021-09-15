package com.epam.api.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CommonService {
    private RequestSpecification REQUEST_SPECIFICATION;
    private PropertyService prop = new PropertyService();

    public CommonService() {
        REQUEST_SPECIFICATION = (RequestSpecification) new RequestSpecBuilder()
                .setBaseUri(prop.getValue("BaseUri"))
                .addParam("key",prop.getValue("TrelloAPI-Key"))
                .addParam("token",prop.getValue("TrelloToken"))
                .addFilter(new RequestLoggingFilter())
                .build();
    }

    public Response getWithParams(String uri, Map<String, Object> params) {
        RequestSpecification specification = given(REQUEST_SPECIFICATION);

        for (Map.Entry<String, Object> param : params.entrySet())
            specification.param(param.getKey(), param.getValue());

        return specification.get(uri);
    }

}
