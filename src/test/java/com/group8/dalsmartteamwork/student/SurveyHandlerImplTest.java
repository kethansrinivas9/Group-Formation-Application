package com.group8.dalsmartteamwork.student;

import com.group8.dalsmartteamwork.questions.IOption;
import com.group8.dalsmartteamwork.questions.Option;
import com.group8.dalsmartteamwork.student.dao.ISurveyManagerDao;
import com.group8.dalsmartteamwork.student.dao.SurveyManagerDaoImpl;
import com.group8.dalsmartteamwork.student.models.ISurveyHandler;
import com.group8.dalsmartteamwork.student.models.SurveyHandlerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SurveyHandlerImplTest {
    private static final int courseId = 5308;
    private ISurveyHandler iSurveyHandler;
    private ISurveyManagerDao iSurveyManagerDao;

    @BeforeEach
    void setup() {
        iSurveyManagerDao = mock(SurveyManagerDaoImpl.class);
        iSurveyHandler = new SurveyHandlerImpl(iSurveyManagerDao);
    }

    @Test
    void getQuestionsTest() {
        List<IQuestionDetails> questionDetails = new ArrayList<>();
        IQuestionDetails question1 = new QuestionDetails(1, "TEXT1", 1);
        IQuestionDetails question2 = new QuestionDetails(2, "TEXT2", 2);
        List<IOption> options = new ArrayList<>();
        IOption option = new Option();
        questionDetails.add(question1);
        questionDetails.add(question2);
        option.setOptionId(1);
        option.setDisplayText("TEXT");
        option.setStoredAs(1);
        options.add(option);
        when(iSurveyManagerDao.getSurveyQuestions(courseId)).thenReturn(questionDetails);
        when(iSurveyManagerDao.getQuestionOptions(2)).thenReturn(options);
        assertEquals(2, iSurveyHandler.getQuestions(courseId).size());
    }

    @Test
    void saveResponsesTest() {
        when(iSurveyManagerDao.saveResponses(1, "TEST", "TEST", 1)).thenReturn(true);
        iSurveyHandler = new SurveyHandlerImpl(iSurveyManagerDao);
        Map<Integer, List<String>> answers = new HashMap<>();
        iSurveyHandler.saveResponses(answers, "TEST", 1);
    }

    @Test
    void getSurveyPublishStatusTest() {
        when(iSurveyManagerDao.getSurveyPublishStatus(courseId)).thenReturn(true);
        assertTrue(iSurveyHandler.getSurveyPublishStatus(courseId));
    }
}
