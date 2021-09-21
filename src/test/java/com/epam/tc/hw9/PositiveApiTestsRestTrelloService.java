package com.epam.tc.hw9;

import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.*;

public class PositiveApiTestsRestTrelloService extends BaseTest {
    @DataProvider
    public Object[][] boardData() {
        return new Object[][]{
                {"FirstBoard", 1},
                {"SecondBoard", 2},
                {"ThirdBoard", 3},
        };
    }

    @Test(description = "A test that verifies the correctness of creating a board",
            dataProvider = "boardData")
    public void createBoardTest(String nameBoard, Integer expCountBoard) {
        restTrelloService.createNewBoard(nameBoard);
        boards = restTrelloService.getAllBoards();
        checkCountBoards(boards.length, expCountBoard);
        checkFirstNameBoard(boards[0].getName(), boardData()[0][0]);
    }

    @Test(description = "A test that verifies the correctness of deleting the board")
    public void deleteBoardTest() {
        tearDown();
        restTrelloService.createNewBoard("Board for Delete")
                .body("name", is("Board for Delete"));
        boards = restTrelloService.getAllBoards();
        checkCreateBoard(boards.length, 1);
        restTrelloService.deleteBoardForId(boards[0].getId());
        boards = restTrelloService.getAllBoards();
        checkCreateBoard(boards.length, 0);
    }

    @Test(description = "A test that verifies the correctness of creating a list")
    public void createListTest() {
        restTrelloService.createNewBoard("Amazing board");
        boards = restTrelloService.getAllBoards();
        String idBoard = boards[0].getId();
        restTrelloService.createNewList("Amazing List", idBoard)
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
        restTrelloService.createNewBoard("White Board");
        boards = restTrelloService.getAllBoards();
        Response respList = restTrelloService.createNewList("White List", boards[0].getId());
        idList = respList.body().asString().substring(7, 31);
        restTrelloService.updateNameList(idList, nameList)
                .body("name", is(nameList));
        tearDown();
    }

    @Test(description = "A test that verifies the correctness of creating a card on a list")
    public void createCardOnListTest() {
        restTrelloService.createNewBoard("White Board");
        boards = restTrelloService.getAllBoards();
        Response respList = restTrelloService.createNewList("White List", boards[0].getId());
        idList = respList.body().asString().substring(7, 31);
        restTrelloService.createCard(idList, "new Card")
                .body("name", is("new Card"))
                .extract().response();
        tearDown();
    }
}