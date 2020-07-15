package com.group8.dalsmartteamwork.student;

import com.group8.dalsmartteamwork.questions.IOption;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnswerTest {
    private static Answer answer;

    @BeforeAll
    static void setup() {
        answer = Answer.getInstance();
    }

    @AfterAll
    static void destroy() {
        answer.destroy();
    }

    @Test
    void getCourseIdTest() {
        answer.setCourseId(1);
        assertEquals(1, answer.getCourseId());
    }

    @Test
    void setCourseIdTest() {
        answer.setCourseId(2);
        assertEquals(2, answer.getCourseId());
    }

    @Test
    void getQuestionsTest() {
        assertEquals(0, answer.getQuestions().size());
    }

    @Test
    void setQuestionsTest() {
        Map<IQuestionDetails, List<IOption>> questions = new HashMap<>();
        IQuestionDetails iQuestionDetails = new QuestionDetails();
        iQuestionDetails.setQuestionId(1);
        questions.put(iQuestionDetails, null);
        answer.setQuestions(questions);
        assertEquals(1, questions.size());
    }

    @Test
    void getAnswersTest() {
        assertEquals(0, answer.getAnswers().size());
    }

    @Test
    void setAnswersTest() {
        Map<Integer, List<String>> answers = new HashMap<>();
        answers.put(1, null);
        answer.setAnswers(answers);
        assertEquals(1, answer.getAnswers().size());
    }

    @Test
    void addAnswerTest() {
        answer.addAnswer(1, "TEST");
        answer.addAnswer(2, "TEST");
        assertEquals(2, answer.getAnswers().size());

    }
}
