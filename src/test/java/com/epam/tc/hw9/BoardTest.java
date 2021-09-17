package com.epam.tc.hw9;

import com.epam.api.dto.BoardDto;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;


public class BoardTest extends BaseTest {

    private Integer defaultCountBoard = 1;

    @DataProvider
    public Object[][] boardNameData() {
        return new Object[][]{
                {"FirstBoard"},
                {"SecondBoard"},
                {"ThirdBoard"},
        };
    }

    @Test(dataProvider = "boardNameData")
    public void createBoardTest(String nameBoard) {
        restTrelloService.createNewBoard(nameBoard)
                .then()
                .statusCode(SC_OK);
        boards = restTrelloService.getAllBoards();
        Assertions.assertThat(boards.length).isEqualTo(defaultCountBoard);
        ++defaultCountBoard;
        Assertions.assertThat(boards[0].getName()).as("The first board name does not match the test data")
                .isEqualTo(boardNameData()[0][0]);
    }

    @Test
    public void deleteBoardTest() {
        if(boards.length==0)
        {
            restTrelloService.createNewBoard("Board for delete");
        }


    }

    @Test
    public void getAllBoards4() {
        System.out.println(restTrelloService.getAllBoards()[0].getId());

    }

    @Test
    public void getAllBoards5() {
        restTrelloService.deleteBoardForId("614498bd92cc993c18e8ae5d");
    }

    @Test
    public void test() {

    }


}
