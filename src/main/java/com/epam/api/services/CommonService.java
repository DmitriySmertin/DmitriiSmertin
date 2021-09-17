package com.epam.api.services;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static com.epam.api.services.PropertyService.getValue;
import static io.restassured.RestAssured.given;

public class CommonService {
    private RequestSpecification REQUEST_SPECIFICATION;

    public CommonService() {
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .addParam("key", getValue("API-Key"))
                .addParam("token", getValue("Token"))
                .addFilter(new ResponseLoggingFilter()).build();
    }

    public String endpointForRequest(String endpoint, String param, String paramValue)
    {
        String request = endpoint + "?key=" + getValue("API-Key")
                + "&token=" + getValue("Token")
                + "&" + param + "=" + paramValue;
        return request;
    }


    public Response getNoParams(String endpoint) {
        Response response = RestAssured.given(REQUEST_SPECIFICATION)
                .get(endpoint);
        return response;
    }

    public Response postWithParam(String endpoint, String param, String paramValue) {
        return RestAssured.given().
                contentType(ContentType.JSON).
                post(endpointForRequest(endpoint,param,paramValue));
    }

    public Response deleteNoParam(String endpoint)
    {
       Response response = RestAssured.given(REQUEST_SPECIFICATION)
                .delete(endpoint);

       return response;
    }

    public Response getWithParams(String uri, Map<String, Object> params) {
        RequestSpecification specification = given(REQUEST_SPECIFICATION);

        for (Map.Entry<String, Object> param : params.entrySet())
            specification.param(param.getKey(), param.getValue());

        return specification.get(uri);
    }


}
