package com.group8.dalsmartteamwork.questions;

import com.group8.dalsmartteamwork.accesscontrol.CurrentUser;
import com.group8.dalsmartteamwork.questions.dao.IQuestionDao;
import com.group8.dalsmartteamwork.questions.dao.QuestionDao;
import com.group8.dalsmartteamwork.questions.models.QuestionOptionManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class QuestionOptionManagerTest {
    private IQuestionDao questionDao;

    @BeforeEach
    void setup() {
        questionDao = mock(QuestionDao.class);
    }

    @Test
    void saveQuestionTest() {
        Question testQuestion = Question.getInstance();
        testQuestion.setTitle("title");
        testQuestion.setText("text");
        testQuestion.setType("numeric");
        when(questionDao.addQuestionToDb(testQuestion, 1, CurrentUser.getInstance().getBannerId())).thenReturn(10);
        QuestionOptionManager saveQuestionOptions = new QuestionOptionManager(questionDao);
        assertEquals(saveQuestionOptions.saveQuestion(testQuestion), 10);
    }

    @Test
    void saveOptionsTest() {
        List<Option> options = new ArrayList<>();
        Option option1 = new Option("display_text", 1);
        Option option2 = new Option("display_text_2", 2);
        options.add(option1);
        options.add(option2);
        when(questionDao.addOptionToDb(option1, 1)).thenReturn(true);
        when(questionDao.addOptionToDb(option2, 1)).thenReturn(true);
        QuestionOptionManager saveQuestionOptions = new QuestionOptionManager(questionDao);
        assertTrue(saveQuestionOptions.saveOptions(options, 1));
    }

}
