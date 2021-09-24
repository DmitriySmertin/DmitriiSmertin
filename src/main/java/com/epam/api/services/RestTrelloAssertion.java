package com.epam.api.services;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.assertj.core.api.Assertions;

import static org.apache.hc.core5.http.HttpStatus.SC_OK;

public class RestTrelloAssertion {

    public void checkCountBoards(Integer countBoard, Integer expectedCountBoard) {
        Assertions.assertThat(countBoard).isEqualTo(expectedCountBoard).as("Count boards not equal expected");
    }

    public void checkFirstNameBoard(String nameFirstBoard, Object firstNameFromData) {
        Assertions.assertThat(nameFirstBoard).as("The first board name does not match the test data")
                .isEqualTo(firstNameFromData);
    }

    public void checkCreateBoard(Integer countBoards, Integer expectCount) {
        Assertions.assertThat(countBoards).isEqualTo(expectCount)
                .as("The number of boards does not match the expected result");
    }

    public void checkNameBoard(String actualName, String expectedName)
        {
            Assertions.assertThat(actualName).isEqualTo(expectedName)
                    .as("The name of board does not match the expected name");
        }

        public ValidatableResponse checkStatusCode(Response response)
        {
            return response.then().statusCode(SC_OK);
        }

}
