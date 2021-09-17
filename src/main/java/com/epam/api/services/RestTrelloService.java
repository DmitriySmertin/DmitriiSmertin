package com.epam.api.services;

import com.epam.api.dto.BoardDto;
import com.google.gson.Gson;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static com.epam.api.services.URI.*;

public class RestTrelloService extends CommonService {
    public BoardDto[] getAllBoards() {
        return
                new Gson().fromJson(
                        new CommonService()
                                .getNoParams(URI.GET_ALL_BOARDS_URI)
                                .getBody().asString(), BoardDto[].class);
    }

    public Response createNewBoard(String name) {
        return new CommonService().postWithParam(CREATE_NEW_BOARD_URI, "name", name);
    }

    public Response deleteBoardForId(String id) {
        return new CommonService().deleteNoParam(DELETE_BOARD_URI + id);
    }

    public Response getBoard(String id) {
        return new CommonService().getNoParams(GET_A_BOARD + id);
    }

    public BoardDto[] deleteAllBoards(List<String> listBoardsId) {
        if (listBoardsId.size() != 0) {
            for (int i = 0; i < listBoardsId.size(); i++) {
                deleteBoardForId(listBoardsId.get(i));
            }
        } else {
            System.out.println("ListId empty");
        }
        return getAllBoards();
    }


}
