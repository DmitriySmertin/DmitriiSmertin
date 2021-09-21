package com.epam.api.services;

import com.epam.api.dto.BoardDto;
import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.util.HashMap;
import java.util.Map;

import static com.epam.api.services.URI.*;
import static org.apache.http.HttpStatus.SC_OK;

public class RestTrelloService extends CommonService {
    public BoardDto[] getAllBoards() {
        return
                new Gson().fromJson(
                        new CommonService()
                                .getNoParams(URI.GET_ALL_BOARDS_URI)
                                .getBody().asString(), BoardDto[].class);
    }

    public ValidatableResponse createNewBoard(String nameBoard) {
        Map<String, Object> param = new HashMap<>();
        param.put("name", nameBoard);
        return new CommonService()
                .postWithParams(BOARDS_URI, param)
                .then()
                .statusCode(SC_OK);
    }

    public ValidatableResponse deleteBoardForId(String id) {
        return new CommonService()
                .deleteNoParam(BOARDS_URI + id)
                .then()
                .statusCode(SC_OK);
    }

    public Response createNewList(String name, String idBoard) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("idBoard", idBoard);
        return new CommonService()
                .postWithParams(LIST_URI, params);
    }

    public ValidatableResponse updateNameList(String idList, String changeNameList) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", changeNameList);
        return new CommonService()
                .putWithParams(LIST_URI + idList + "/", map)
                .then()
                .statusCode(SC_OK);
    }

    public ValidatableResponse createCard(String idList, String nameCard) {
        Map<String, Object> map = new HashMap<>();
        map.put("idList", idList);
        map.put("name", nameCard);
        return new CommonService()
                .postWithParams(CARD_URI, map)
                .then().statusCode(SC_OK);
    }
}