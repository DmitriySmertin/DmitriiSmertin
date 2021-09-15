package com.epam.api.services;

import com.epam.api.dto.BoardDto;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class RestTrelloService extends CommonService {

    public BoardDto[] getAllBoards()
    {
        return
                new Gson().fromJson(
                        new CommonService()
                                .getNoParams(URI.GET_ALL_BOARDS_URI)
                                .getBody().asString(),BoardDto[].class);
    }

    public void postCreateNewBoard(String name)
    {
        CommonService cs = new CommonService();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);
        cs.postWithParams(URI.CREATE_NEW_BOARD,params);
    }




}
