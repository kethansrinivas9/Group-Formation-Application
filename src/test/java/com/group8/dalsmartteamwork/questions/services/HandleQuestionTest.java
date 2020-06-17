package com.group8.dalsmartteamwork.questions.services;

import com.group8.dalsmartteamwork.questions.Question;
import com.group8.dalsmartteamwork.questions.models.HandleQuestion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class HandleQuestionTest {
    private final String TEST_TITLE = "title";
    private final String TEST_TEXT = "text";
    private final String TEST_TYPE = "numeric";
    private static Question question;

    @BeforeAll
    static void setup(){
        question = Question.getInstance();
    }

    @Test
    void createQuestionTest(){
        HandleQuestion handleQuestion = new HandleQuestion(question);
        Question result = handleQuestion.createQuestion(TEST_TITLE, TEST_TEXT, TEST_TYPE);
        assertEquals(result.getTitle(), TEST_TITLE);
        assertEquals(result.getText(), TEST_TEXT);
        assertEquals(result.getType(), TEST_TYPE);
    }

    @Test
    void resetQuestionTest(){
        HandleQuestion handleQuestion = new HandleQuestion(question);
        handleQuestion.resetQuestion();
        assertNull(question.getTitle());
        assertNull(question.getText());
        assertNull(question.getType());
    }
}
