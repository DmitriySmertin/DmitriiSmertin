package com.epam.tc.hw9;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
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
        checkCountBoards(boards.length, 1);
        checkNameBoard(boards[0].getName(), nameBoard);
    }

    @Test(description = "A test that verifies the correctness of deleting the board")
    public void deleteBoardTest() {
        boardDto.setName("Board for Delete");
        restTrelloService.createNewBoard(boardDto)
                .then()
                .body("name", is(boardDto.getName()));
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
        listDto.setIdBoard(idBoard);
        restTrelloService.createNewList(listDto)
                .then()
                .body("name", is(listDto.getName()));
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
        listDto.setIdBoard(boards[0].getId());
        Response respList = restTrelloService.createNewList(listDto);
        idList = restTrelloService.setIdList(respList);
        restTrelloService.updateNameList(idList, nameList)
                .then()
                .body("name", is(nameList));
    }

    @Test(description = "A test that verifies the correctness of creating a card on a list")
    public void createCardOnListTest() {
        boardDto.setName("Board for Card");
        restTrelloService.createNewBoard(boardDto);
        boards = restTrelloService.getAllBoards();
        listDto.setName("List for Card");
        listDto.setIdBoard(boards[0].getId());
        Response respList = restTrelloService.createNewList(listDto);
        idList = restTrelloService.setIdList(respList);
        cardDto.setName("Card for List");
        cardDto.setIdList(idList);
        restTrelloService.createCard(cardDto)
                .then()
                .body("name", is(cardDto.getName()))
                .extract().response();
    }

}