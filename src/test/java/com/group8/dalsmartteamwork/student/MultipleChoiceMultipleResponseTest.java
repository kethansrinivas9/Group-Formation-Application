package com.group8.dalsmartteamwork.student;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceMultipleResponseTest {
    private static Answer answer;
    @BeforeAll
    static void setup(){
        answer = Answer.getInstance();
    }

    @Test
    void addResponseTest(){
        IResponseObject iResponseObject = new MultipleChoiceMultipleResponse();
        iResponseObject.addResponse(1, "TEST");
        assertEquals(1, answer.getAnswers().size());
    }

    @AfterAll
    static void destroy(){
        answer.destroy();
    }
}
