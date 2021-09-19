package com.epam.api.services;

import com.epam.api.dto.BoardDto;
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

    public Response getBoard(String id) {
        return new CommonService()
                .getNoParams(GET_A_BOARD + id);
    }

    public Response createNewList(String name, String idBoard) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("idBoard", idBoard);
        Response response = postWithParams(CREATE_NEW_LIST_URI, params);
        return response;
    }

    public ListDto[] getList(String id)
    {
        return
                new Gson().fromJson(
                        new CommonService()
                                .getNoParams(GET_A_LIST + id)
                                .getBody().asString(), ListDto[].class);
    }
    }


