package com.epam.api.services;

import com.epam.api.dto.BoardDto;
import com.epam.api.dto.CardDto;
import com.epam.api.dto.ListDto;
import com.google.gson.Gson;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.epam.api.services.URI.*;

public class RestTrelloService extends CommonService {
    public BoardDto[] getAllBoards() {
        return
                new Gson().fromJson(
                        new CommonService()
                                .getNoParams(GET_ALL_BOARDS_URI)
                                .getBody().asString(), BoardDto[].class);
    }

    public Response createNewBoard(BoardDto boardDto) {
        Map<String, Object> param = new HashMap<>();
        param.put("name", boardDto.getName());
        Response response = new CommonService()
                .postWithParams(BOARDS_URI, param);
        checkStatusCode(response);
        return response;

    }

    public Response deleteBoardForId(BoardDto boardDto) {
        return new CommonService()
                .deleteNoParam(BOARDS_URI + boardDto.getId());
    }

    public Response deleteBoardForId(String idBoard) {
        Response response = new CommonService()
                .deleteNoParam(BOARDS_URI + idBoard);
        checkStatusCode(response);
        return response;
    }

    public Response createNewList(ListDto listDto) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", listDto.getName());
        params.put("idBoard", listDto.getIdBoard());
        Response response = new CommonService()
                .postWithParams(LIST_URI, params);
        checkStatusCode(response);
        return response;
    }

    public Response updateNameList(String idList, String newName) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", newName);
        Response response = new CommonService()
                .putWithParams(LIST_URI + idList + "/", map);
        checkStatusCode(response);
        return response;
    }

    public Response createCard(CardDto cardDto) {
        Map<String, Object> map = new HashMap<>();
        map.put("idList", cardDto.getIdList());
        map.put("name", cardDto.getName());
        Response response = new CommonService()
                .postWithParams(CARD_URI, map);
        checkStatusCode(response);
        return response;
    }

    public  String setIdList(Response response)
    {
        return response.body().asString().substring(7,31);
    }
}