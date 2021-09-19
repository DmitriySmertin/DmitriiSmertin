package com.epam.tc.hw9;

import com.epam.api.dto.ListDto;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

public class BoardTest extends BaseTest {

    Integer defaultCountBoard = 1;

    @DataProvider
    public Object[][] boardNameData() {
        return new Object[][]{
                {"FirstBoard"},
                {"SecondBoard"},
                {"ThirdBoard"},
        };
    }

    @Test(description = "Check status code is 200 and count creates boards is correct",
            dataProvider = "boardNameData")
    public void createBoardTest(String nameBoard) {
        restTrelloService.createNewBoard(nameBoard)
                .then()
                .statusCode(SC_OK);
        boards = restTrelloService.getAllBoards();
        Assertions.assertThat(boards.length).isEqualTo(defaultCountBoard);
        ++defaultCountBoard;
        assertThat(boards[0].getName()).as("The first board name does not match the test data")
                .isEqualTo(boardNameData()[0][0]);
    }

    @Test(description = "Check the correct removal of the board")
    public void deleteBoardTest() {
        tearDown();
        restTrelloService.createNewBoard("Board for Delete")
                .then()
                .statusCode(SC_OK)
                .body("name", is("Board for Delete"));
        boards = restTrelloService.getAllBoards();
        assertThat(boards.length).isEqualTo(1);
        restTrelloService.deleteBoardForId(boards[0].getId())
                .then()
                .statusCode(SC_OK);
        boards = restTrelloService.getAllBoards();
        assertThat(boards.length).isEqualTo(0);
    }

    @Test
    public void createListTest() {
        restTrelloService.createNewBoard("Amazing board");
        boards = restTrelloService.getAllBoards();
        String idBoard = boards[0].getId();
        restTrelloService.createNewList("Amazing List", idBoard)
                .then().statusCode(SC_OK)
                .extract().response();
    }
//
//
//
//
//    @Test
//    public void getAllBoards4() {
//       restTrelloService.createNewList("NewList123123",boards[0].getId());
//    }
////
//    @Test
//    public void getAllBoards() {
//        tearDown();
//    }
}

