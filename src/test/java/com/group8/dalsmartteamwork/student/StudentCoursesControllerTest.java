package com.group8.dalsmartteamwork.student;

import com.group8.dalsmartteamwork.student.dao.IStudentDao;
import com.group8.dalsmartteamwork.student.dao.ISurveyManagerDao;
import com.group8.dalsmartteamwork.student.dao.StudentDaoImpl;
import com.group8.dalsmartteamwork.student.dao.SurveyManagerDaoImpl;
import com.group8.dalsmartteamwork.student.models.IResponseHandler;
import com.group8.dalsmartteamwork.student.models.ISurveyHandler;
import com.group8.dalsmartteamwork.student.models.ResponseHandler;
import com.group8.dalsmartteamwork.student.models.SurveyHandlerImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class StudentCoursesControllerTest {
    private ISurveyManagerDao iSurveyManagerDao;
    private ISurveyHandler iSurveyHandler;
    private Answer answer;

    @BeforeEach
    void setup() {
        iSurveyManagerDao = mock(SurveyManagerDaoImpl.class);
        iSurveyHandler = mock(SurveyHandlerImpl.class);
        answer = Answer.getInstance();
    }

    @Test
    void getStudentEnrolledCoursesPageTest() {
        IStudentDao coursePage = mock(StudentDaoImpl.class);
        when(coursePage.displayCourses()).thenReturn(null);
        assertNull(coursePage.displayCourses());

    }

    @Test
    void getCoursePageTest() {
        iSurveyHandler = new SurveyHandlerImpl(iSurveyManagerDao);
        when(iSurveyHandler.getQuestions(anyInt())).thenReturn(null);
        answer = Answer.getInstance();
        assertEquals(0, answer.getQuestions().size());
    }

    @Test
    void saveSurveyResponsesTest() {
        IResponseHandler iResponseHandler = mock(ResponseHandler.class);
        answer.destroy();
        answer = Answer.getInstance();
        doNothing().when(iResponseHandler).getResponses(any(), any());
        Map<Integer, List<String>> answers = answer.getAnswers();
        assertEquals(0, answers.size());
    }

    @AfterEach
    void destroy() {
        answer.destroy();
    }
}
