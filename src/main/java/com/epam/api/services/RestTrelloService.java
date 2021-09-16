package com.epam.api.services;

import com.epam.api.dto.BoardDto;
import com.google.gson.Gson;
import io.restassured.response.Response;

import static com.epam.api.services.URI.CREATE_NEW_BOARD_URI;
import static com.epam.api.services.URI.DELETE_BOARD_URI;

public class RestTrelloService extends CommonService {
    CommonService cs = new CommonService();
    
    public BoardDto[] getAllBoards() {
        return
                new Gson().fromJson(
                        new CommonService()
                                .getNoParams(URI.GET_ALL_BOARDS_URI)
                                .getBody().asString(), BoardDto[].class);

    }

    public Response createNewBoard(String name) {
        return cs.postWithParam(CREATE_NEW_BOARD_URI, "name", name);
    }

    public Response deleteBoardForId(String id)
    {
        return cs.deleteNoParam(DELETE_BOARD_URI+id);
    }


}
