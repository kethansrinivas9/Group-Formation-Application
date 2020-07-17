package com.group8.dalsmartteamwork.createsurvey;

import com.group8.dalsmartteamwork.course.Course;
import com.group8.dalsmartteamwork.createsurvey.dao.CreateSurveyDao;
import com.group8.dalsmartteamwork.createsurvey.dao.CreateSurveyDaoImpl;
import com.group8.dalsmartteamwork.createsurvey.model.CreateSurvey;
import com.group8.dalsmartteamwork.createsurvey.model.CreateSurveyImpl;
import com.group8.dalsmartteamwork.questions.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateSurveyImpTest {
    private final CreateSurveyDao createSurveyDao = mock(CreateSurveyDaoImpl.class);
    private final List<Course> courseList = Arrays.asList(new Course(1, "java"));
    private final List<Question> questionList = Arrays.asList(new Question(1, "what is java"));
    private final List<Integer> questionIDList = Arrays.asList(1, 2, 3);
    private final String BannerID = "B00123456";
    private final int courseID = 5308;
    private CreateSurvey createSurvey = null;

    @BeforeEach
    public void setup() {
        createSurvey = new CreateSurveyImpl(createSurveyDao);
    }

    @Test
    public void displayListOfCoursesTest() {
        when(createSurveyDao.displayListOfCourses(BannerID)).thenReturn(courseList);
        assertEquals(createSurvey.displayListOfCourses(BannerID), courseList);
        verify(createSurveyDao).displayListOfCourses(BannerID);
    }

    @Test
    public void checkIfSurveyCreatedTest() {
        when(createSurveyDao.checkIfSurveyCreated(courseID)).thenReturn(true);
        assertEquals(createSurvey.checkIfSurveyCreated(courseID), true);
        verify(createSurveyDao).checkIfSurveyCreated(courseID);
    }

    @Test
    public void displayQuestionsTest() {
        when(createSurveyDao.displayQuestions(BannerID, courseID)).thenReturn(questionList);
        assertEquals(createSurvey.displayQuestions(BannerID, courseID), questionList);
        verify(createSurveyDao).displayQuestions(BannerID, courseID);
    }

    @Test
    public void addQuestionToSurveyTest() {
        when(createSurveyDao.saveQuestions(courseID, questionIDList)).thenReturn(true);
        assertEquals(createSurvey.saveQuestions(courseID, questionIDList), true);
        verify(createSurveyDao).saveQuestions(courseID, questionIDList);
    }

    @Test
    public void publishSurveyTest() {
        when(createSurveyDao.publishSurvey(courseID)).thenReturn(true);
        assertEquals(createSurvey.publishSurvey(courseID), true);
        verify(createSurveyDao).publishSurvey(courseID);
    }
}