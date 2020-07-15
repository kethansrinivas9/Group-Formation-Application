package com.group8.dalsmartteamwork.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionDetailsTest {
    private IQuestionDetails iQuestionDetails;

    @BeforeEach
    void setup() {
        iQuestionDetails = new QuestionDetails();
    }

    @Test
    void getQuestionIdTest() {
        iQuestionDetails.setQuestionId(1);
        assertEquals(1, iQuestionDetails.getQuestionId());
    }

    @Test
    void setQuestionIdTest() {
        iQuestionDetails.setQuestionId(1);
        assertEquals(1, iQuestionDetails.getQuestionId());
    }

    @Test
    void getTextTest() {
        iQuestionDetails.setText("TEST");
        assertEquals("TEST", iQuestionDetails.getText());
    }

    @Test
    void setTextTest() {
        iQuestionDetails.setText("TEST");
        assertEquals("TEST", iQuestionDetails.getText());
    }

    @Test
    void getTypeTest() {
        iQuestionDetails.setType(1);
        assertEquals(1, iQuestionDetails.getType());
    }

    @Test
    void setTypeTest() {
        iQuestionDetails.setType(1);
        assertEquals(1, iQuestionDetails.getType());
    }
}
