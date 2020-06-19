package com.group8.dalsmartteamwork.questions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTest {
    static Question question;
    private final String TEST_TITLE = "title";
    private final String TEST_TEXT = "text";
    private final String TEST_TYPE = "numeric";
    private final int TEST_QUESTION_ID = 1;

    @BeforeAll
    static void setup() {
        question = Question.getInstance();
    }

    @AfterAll
    static void reset() {
        question.reset();
    }

    @Test
    void getTitleText() {
        question.setTitle(TEST_TITLE);
        assertEquals(question.getTitle(), TEST_TITLE);
    }

    @Test
    void setTitleTest() {
        question.setTitle(TEST_TITLE);
        assertEquals(question.getTitle(), TEST_TITLE);
    }

    @Test
    void getTextTest() {
        question.setText(TEST_TEXT);
        assertEquals(question.getText(), TEST_TEXT);
    }

    @Test
    void setTextTest() {
        question.setText(TEST_TEXT);
        assertEquals(question.getText(), TEST_TEXT);
    }

    @Test
    void getTypeTest() {
    }

    @Test
    void setTypeTest() {
        question.setType(TEST_TYPE);
        assertEquals(question.getType(), TEST_TYPE);
    }

    @Test
    void getQuestionID() {
        question.setQuestionID(TEST_QUESTION_ID);
        assertEquals(question.getQuestionID(), TEST_QUESTION_ID);
    }

    @Test
    void setQuestionID() {
        question.setQuestionID(TEST_QUESTION_ID);
        assertEquals(question.getQuestionID(), TEST_QUESTION_ID);
    }
}
