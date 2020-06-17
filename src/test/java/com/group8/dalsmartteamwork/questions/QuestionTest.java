package com.group8.dalsmartteamwork.questions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTest {
    private final String TEST_TITLE = "title";
    private final String TEST_TEXT = "text";
    private final String TEST_TYPE = "numeric";
    static Question question;

    @BeforeAll
    static void setup(){
        question = Question.getInstance();
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
    void getTextTest(){
        question.setText(TEST_TEXT);
        assertEquals(question.getText(), TEST_TEXT);
    }

    @Test
    void setTextTest() {
        question.setText(TEST_TEXT);
        assertEquals(question.getText(), TEST_TEXT);
    }

    @Test
    void getTypeTest(){
    }

    @Test
    void setTypeTest() {
        question.setType(TEST_TYPE);
        assertEquals(question.getType(), TEST_TYPE);
    }

    @AfterAll
    static void reset(){
        question.reset();
    }
}
