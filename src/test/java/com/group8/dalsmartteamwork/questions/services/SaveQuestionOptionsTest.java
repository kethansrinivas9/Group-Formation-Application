package com.group8.dalsmartteamwork.questions.services;

import com.group8.dalsmartteamwork.questions.Option;
import com.group8.dalsmartteamwork.questions.Question;
import com.group8.dalsmartteamwork.questions.dao.IQuestionDao;
import com.group8.dalsmartteamwork.questions.dao.QuestionDao;
import com.group8.dalsmartteamwork.questions.models.SaveQuestionOptions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SaveQuestionOptionsTest {
    private IQuestionDao questionDao;

    @BeforeEach
    void setup(){
        questionDao = mock(QuestionDao.class);
    }

    @Test
    void saveQuestionTest(){
        Question testQuestion = Question.getInstance();
        testQuestion.setTitle("title");
        testQuestion.setText("text");
        testQuestion.setType("numeric");
        when(questionDao.addQuestionToDb(testQuestion, 1, null)).thenReturn(10);
        SaveQuestionOptions saveQuestionOptions = new SaveQuestionOptions(questionDao);
        assertEquals(saveQuestionOptions.saveQuestion(testQuestion), 10);
    }

    @Test
    void saveOptionsTest(){
        List<Option> options = new ArrayList<>();
        Option option1 = new Option("display_text", 1);
        Option option2 = new Option("display_text_2", 2);
        options.add(option1);
        options.add(option2);
        when(questionDao.addOptionToDb(option1,1)).thenReturn(true);
        when(questionDao.addOptionToDb(option2,1)).thenReturn(true);
        SaveQuestionOptions saveQuestionOptions = new SaveQuestionOptions(questionDao);
        assertTrue(saveQuestionOptions.saveOptions(options,1));
    }

}
