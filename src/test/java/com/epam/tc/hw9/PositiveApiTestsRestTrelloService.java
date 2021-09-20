package com.epam.tc.hw9;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

public class PositiveApiTestsRestTrelloService extends BaseTest {
    @DataProvider
    public Object[][] boardNameData() {
        return new Object[][]{
                {"FirstBoard"},
                {"SecondBoard"},
                {"ThirdBoard"},
        };
    }

    @Test(description = "A test that verifies the correctness of creating a board",
            dataProvider = "boardNameData")
    public void createBoardTest(String nameBoard) {
        restTrelloService.createNewBoard(nameBoard)
                .then()
                .statusCode(SC_OK);
        boards = restTrelloService.getAllBoards();
        Assertions.assertThat(boards.length).isEqualTo(defaultCountBoard).as("Count boards not equal expected");
        ++defaultCountBoard;
        assertThat(boards[0].getName()).as("The first board name does not match the test data")
                .isEqualTo(boardNameData()[0][0]);
    }

    @Test(description = "A test that verifies the correctness of deleting the board")
    public void deleteBoardTest() {
        tearDown();
        restTrelloService.createNewBoard("Board for Delete")
                .then()
                .statusCode(SC_OK)
                .body("name", is("Board for Delete"));
        boards = restTrelloService.getAllBoards();
        assertThat(boards.length).isEqualTo(1).as("Board not create");
        restTrelloService.deleteBoardForId(boards[0].getId())
                .then()
                .statusCode(SC_OK);
        boards = restTrelloService.getAllBoards();
        assertThat(boards.length).isEqualTo(0).as("Board not delete");
    }

    @Test(description = "A test that verifies the correctness of creating a list")
    public void createListTest() {
        restTrelloService.createNewBoard("Amazing board");
        boards = restTrelloService.getAllBoards();
        String idBoard = boards[0].getId();
        Response resp = restTrelloService.createNewList("Amazing List", idBoard)
                .then().statusCode(SC_OK)
                .body("name", is("Amazing List"))
                .extract().response();
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
                .then()
                .statusCode(SC_OK)
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
                .then()
                .statusCode(SC_OK)
                .body("name", is("new Card"))
                .extract().response();
        tearDown();
    }
}