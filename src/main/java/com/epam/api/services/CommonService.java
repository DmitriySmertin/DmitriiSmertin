package com.epam.api.services;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CommonService {
    private RequestSpecification REQUEST_SPECIFICATION;
    private PropertyService prop = new PropertyService();


    public CommonService() {
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .addParam("key", prop.getValue("API-Key"))
                .addParam("token",prop.getValue("Token"))
//                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter()).build();
    }


    public Response getNoParams(String endpoint){
        Response response = RestAssured.given(REQUEST_SPECIFICATION)
                .get(endpoint);
        return response;
    }

    public Response postWithParams(String endpoint, Map<String, Object> params){

        RequestSpecification specification = given(REQUEST_SPECIFICATION);
        for (Map.Entry<String, Object> param : params.entrySet())
            specification.param(param.getKey(), param.getValue());
        return specification.post(endpoint);

    }

    public Response getWithParams(String uri, Map<String, Object> params) {
        RequestSpecification specification = given(REQUEST_SPECIFICATION);

        for (Map.Entry<String, Object> param : params.entrySet())
            specification.param(param.getKey(), param.getValue());

        return specification.get(uri);
    }



}
