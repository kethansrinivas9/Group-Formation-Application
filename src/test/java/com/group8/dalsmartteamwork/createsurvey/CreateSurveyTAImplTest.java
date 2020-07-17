package com.group8.dalsmartteamwork.createsurvey;

import com.group8.dalsmartteamwork.createsurvey.dao.CreateSurveyTADao;
import com.group8.dalsmartteamwork.createsurvey.dao.CreateSurveyTADaoImpl;
import com.group8.dalsmartteamwork.createsurvey.model.CreateSurveyTA;
import com.group8.dalsmartteamwork.createsurvey.model.CreateSurveyTAImpl;
import com.group8.dalsmartteamwork.questions.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateSurveyTAImplTest {

    private final CreateSurveyTADao createSurveyTADao = mock(CreateSurveyTADaoImpl.class);
    private final List<Question> questionList = Arrays.asList(new Question(1, "what is java"));
    private final String BannerID = "B00123456";
    private final int courseID = 5308;
    private CreateSurveyTA createSurveyTA = null;

    @BeforeEach
    public void setup() {
        createSurveyTA = new CreateSurveyTAImpl(createSurveyTADao);
    }

    @Test
    public void displayQuestionsTATest() {
        when(createSurveyTADao.displayQuestionsTA(BannerID, courseID)).thenReturn(questionList);
        assertEquals(createSurveyTA.displayQuestionsTA(BannerID, courseID), questionList);
        verify(createSurveyTADao).displayQuestionsTA(BannerID, courseID);
    }
}