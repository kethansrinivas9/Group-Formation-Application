package com.group8.dalsmartteamwork.questions;

import com.group8.dalsmartteamwork.questions.models.QuestionHandler;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class QuestionHandlerTest {
    private static Question question;
    private final String TEST_TITLE = "title";
    private final String TEST_TEXT = "text";
    private final String TEST_TYPE = "numeric";

    @BeforeAll
    static void setup() {
        question = Question.getInstance();
    }

    @Test
    void createQuestionTest() {
        QuestionHandler questionHandler = new QuestionHandler(question);
        Question result = questionHandler.createQuestion(TEST_TITLE, TEST_TEXT, TEST_TYPE);
        assertEquals(result.getTitle(), TEST_TITLE);
        assertEquals(result.getText(), TEST_TEXT);
        assertEquals(result.getType(), TEST_TYPE);
    }

    @Test
    void resetQuestionTest() {
        QuestionHandler questionHandler = new QuestionHandler(question);
        questionHandler.resetQuestion();
        assertNull(question.getTitle());
        assertNull(question.getText());
        assertNull(question.getType());
    }
}
