package com.epam.api.services;

import com.epam.api.dto.BoardDto;
import com.epam.api.dto.CardDto;
import com.epam.api.dto.ListDto;
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
                                .getNoParams(GET_ALL_BOARDS_URI)
                                .getBody().asString(), BoardDto[].class);
    }

    public ValidatableResponse createNewBoard(BoardDto boardDto) {
        Map<String, Object> param = new HashMap<>();
        param.put("name", boardDto.getName());
        return new CommonService()
                .postWithParams(BOARDS_URI, param)
                .then()
                .statusCode(SC_OK);
    }

    public ValidatableResponse deleteBoardForId(BoardDto boardDto) {
        return new CommonService()
                .deleteNoParam(BOARDS_URI + boardDto.getId())
                .then()
                .statusCode(SC_OK);
    }
    public ValidatableResponse deleteBoardForId(String idBoard) {
        return new CommonService()
                .deleteNoParam(BOARDS_URI + idBoard)
                .then()
                .statusCode(SC_OK);
    }

    public Response createNewList(ListDto listDto, String idBoard) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", listDto.getName());
        params.put("idBoard",idBoard);
        return new CommonService()
                .postWithParams(LIST_URI, params);
    }

    public ValidatableResponse updateNameList(String idList, String newName) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", newName);
        return new CommonService()
                .putWithParams(LIST_URI + idList + "/", map)
                .then()
                .statusCode(SC_OK);
    }

    public ValidatableResponse createCard(CardDto cardDto,String idList) {
        Map<String, Object> map = new HashMap<>();
        map.put("idList", idList);
        map.put("name", cardDto.getName());
        return new CommonService()
                .postWithParams(CARD_URI, map)
                .then().statusCode(SC_OK);
    }
}