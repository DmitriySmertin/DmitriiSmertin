package com.epam.api.services;

import com.epam.api.dto.BoardDto;
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
                                .getNoParams(URI.GET_ALL_BOARDS_URI)
                                .getBody().asString(), BoardDto[].class);
    }

    public Response createNewBoard(String nameBoard) {
        Map<String, Object> param = new HashMap<>();
        param.put("name", nameBoard);
        return new CommonService()
                .postWithParams(CREATE_NEW_BOARD_URI, param);
    }

    public Response deleteBoardForId(String id) {
        return new CommonService()
                .deleteNoParam(DELETE_BOARD_URI + id);
    }

    public Response createNewList(String name, String idBoard) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("idBoard", idBoard);
        Response response = postWithParams(CREATE_NEW_LIST_URI, params);
        return response;
    }

    public Response updateNameList(String idList, String changeNameList) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", changeNameList);
        return putWithParams(UPDATE_NAME_LIST + idList + "/", map);
    }

    public Response createCard(String idList, String nameCard) {
        Map<String, Object> map = new HashMap<>();
        map.put("idList", idList);
        map.put("name", nameCard);
        return postWithParams(CREATE_NEW_CARD, map);
    }
}