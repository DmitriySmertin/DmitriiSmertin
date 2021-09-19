package com.epam.api.services;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static com.epam.api.services.PropertyService.getValue;
import static io.restassured.RestAssured.given;

public class CommonService {
    private RequestSpecification REQUEST_SPECIFICATION;

    public CommonService() {
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .addQueryParam("key", getValue("API-Key"))
                .addQueryParam("token", getValue("Token"))
                .addFilter(new ResponseLoggingFilter()).build();
    }


    public Response getNoParams(String endpoint) {
        Response response = RestAssured.given(REQUEST_SPECIFICATION)
                .get(endpoint);
        return response;
    }

    public Response postWithParams(String uri, Map<String, Object> params) {
        RequestSpecification specification = given(REQUEST_SPECIFICATION)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);

        for (Map.Entry<String, Object> param : params.entrySet())
            specification.queryParam(param.getKey(), param.getValue());

        return specification.post(uri);
    }

    public Response deleteNoParam(String endpoint) {
        Response response = RestAssured.given(REQUEST_SPECIFICATION)
                .delete(endpoint);

        return response;
    }


}
