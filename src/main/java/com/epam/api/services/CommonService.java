package com.epam.api.services;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static com.epam.api.services.PropertyService.*;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class CommonService {
    private RequestSpecification requestSpecification;

    public CommonService() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(getBaseUri())
                .addQueryParam("key", getKey())
                .addQueryParam("token", getToken())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public Response getNoParams(String endpoint) {
        return RestAssured.given(requestSpecification)
                .get(endpoint);
    }

    public Response postWithParams(String uri, Map<String, Object> params) {
        RequestSpecification specification = given(requestSpecification)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);

        for (Map.Entry<String, Object> param : params.entrySet())
            specification.queryParam(param.getKey(), param.getValue());

        return specification.post(uri);
    }

    public Response deleteNoParam(String endpoint) {
        return RestAssured.given(requestSpecification)
                .delete(endpoint);
    }

    public Response putWithParams(String endpoint, Map<String, Object> params) {
        RequestSpecification specification = RestAssured.given(requestSpecification)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);

        for (Map.Entry<String, Object> param : params.entrySet())
            specification.queryParam(param.getKey(), param.getValue());

        return specification.put(endpoint);
    }
}