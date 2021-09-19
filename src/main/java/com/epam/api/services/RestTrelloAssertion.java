package com.epam.api.services;

import com.epam.api.dto.BoardDto;
import org.assertj.core.api.Assertions;

public class RestTrelloAssertion {

    RestTrelloService restTrelloService = new RestTrelloService();
    BoardDto[] boards = restTrelloService.getAllBoards();

    public void verifyCountBoards()
    {

    }


}
