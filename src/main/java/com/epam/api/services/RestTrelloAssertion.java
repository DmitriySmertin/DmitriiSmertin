package com.epam.api.services;

import org.assertj.core.api.Assertions;

public class RestTrelloAssertion {

    public void checkCountBoards(Integer countBoard, Integer defaultCountBoard){
        Assertions.assertThat(countBoard).isEqualTo(defaultCountBoard).as("Count boards not equal expected");
    }

    public void checkFirstNameBoard(String nameFirstBoard, Object firstNameFromData)
    {
        Assertions.assertThat(nameFirstBoard).as("The first board name does not match the test data")
                .isEqualTo(firstNameFromData);
    }
    public void checkCreateBoard(Integer countBoards, Integer expectCount)
    {
        Assertions.assertThat(countBoards).isEqualTo(expectCount)
                .as("The number of boards does not match the expected result");
    }

}
