package com.epam.tc.hw9;

import com.epam.api.dto.BoardDto;
import com.epam.api.dto.CardDto;
import com.epam.api.dto.ListDto;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class PositiveApiTestsRestTrelloService extends BaseTest {
    @DataProvider
    public Object[][] boardData() {
        return new Object[][]{
                {"FirstBoard"},
                {"SecondBoard"},
                {"ThirdBoard"},
        };
    }

    @Test(description = "A test that verifies the correctness of creating a board",
            dataProvider = "boardData")
    public void createBoardTest(String nameBoard) {
        boardDto.setName(nameBoard);
        restTrelloService.createNewBoard(boardDto);
        boards = restTrelloService.getAllBoards();
        checkCountBoards(boards.length, defCountBoard);
    }

    @Test(description = "A test that verifies the correctness of deleting the board")
    public void deleteBoardTest() {
        boardDto.setName("Board for Delete");
        restTrelloService.createNewBoard(boardDto)
                .body("name", is("Board for Delete"));
        boards = restTrelloService.getAllBoards();
        checkCreateBoard(boards.length, 1);
        restTrelloService.deleteBoardForId(boards[0].getId());
        boards = restTrelloService.getAllBoards();
        checkCreateBoard(boards.length, 0);
    }

    @Test(description = "A test that verifies the correctness of creating a list")
    public void createListTest() {
        boardDto.setName("Board for List");
        restTrelloService.createNewBoard(boardDto);
        boards = restTrelloService.getAllBoards();
        String idBoard = boards[0].getId();
        listDto.setName("Amazing List");
        restTrelloService.createNewList(listDto, idBoard)
                .then()
                .body("name", is("Amazing List"));
    }

    @DataProvider
    public Object[][] nameListData() {
        return new Object[][]{
                {"White List"},
                {"Red List"},
                {"Black List"},
        };
    }

    @Test(description = "A test that verifies the correctness of changing the list name",
            dataProvider = "nameListData")
    public void changeNameListTest(String nameList) {
        boardDto.setName("Board for List");
        restTrelloService.createNewBoard(boardDto);
        boards = restTrelloService.getAllBoards();
        listDto.setName("Strange List");
        Response respList = restTrelloService.createNewList(listDto, boards[0].getId());
        idList = respList.body().asString().substring(7, 31);
        restTrelloService.updateNameList(idList, nameList)
                .body("name", is(nameList));
    }

    @Test(description = "A test that verifies the correctness of creating a card on a list")
    public void createCardOnListTest() {
        boardDto.setName("Board for Card");
        restTrelloService.createNewBoard(boardDto);
        boards = restTrelloService.getAllBoards();
        listDto.setName("List for Card");
        Response respList = restTrelloService.createNewList(listDto, boards[0].getId());
        idList = respList.body().asString().substring(7, 31);
        cardDto.setName("Card for List");
        restTrelloService.createCard(cardDto, idList)
                .body("name", is(listDto.getName()))
                .extract().response();
    }
}