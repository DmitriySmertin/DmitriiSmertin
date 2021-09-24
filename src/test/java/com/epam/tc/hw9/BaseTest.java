package com.epam.tc.hw9;

import com.epam.api.dto.BoardDto;
import com.epam.api.dto.CardDto;
import com.epam.api.dto.ListDto;
import com.epam.api.services.RestTrelloAssertion;
import com.epam.api.services.RestTrelloService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


public class BaseTest extends RestTrelloAssertion {
    public BoardDto boardDto;
    public ListDto listDto;
    public CardDto cardDto;
    public RestTrelloService restTrelloService = new RestTrelloService();
    public BoardDto[] boards = restTrelloService.getAllBoards();
    public String idList;

    @BeforeClass
    public void setUp() {
        boardDto = new BoardDto();
        listDto = new ListDto();
        cardDto = new CardDto();

    }

    @AfterMethod
    public void tearDown() {
        if (boards.length != 0) {
            for (int i = 0; i < boards.length; i++) {
                restTrelloService.deleteBoardForId(boards[i].getId());
            }
            boards = restTrelloService.getAllBoards();
        }
    }
}