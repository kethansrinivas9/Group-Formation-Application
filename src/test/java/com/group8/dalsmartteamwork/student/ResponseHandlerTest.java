package com.group8.dalsmartteamwork.student;

import com.group8.dalsmartteamwork.questions.IOption;
import com.group8.dalsmartteamwork.student.models.IResponseFactory;
import com.group8.dalsmartteamwork.student.models.IResponseHandler;
import com.group8.dalsmartteamwork.student.models.ResponseFactoryImpl;
import com.group8.dalsmartteamwork.student.models.ResponseHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ResponseHandlerTest {
    private HttpServletRequest request;
    private IResponseHandler iResponseHandler;
    private Answer answer;

    @BeforeEach
    void setup() {
        request = mock(HttpServletRequest.class);
        answer = Answer.getInstance();
        IResponseFactory iResponseFactory = new ResponseFactoryImpl();
        iResponseHandler = new ResponseHandler(iResponseFactory);
    }

    @Test
    void getResponsesTest() {
        Map<IQuestionDetails, List<IOption>> questions = new HashMap<>();
        IQuestionDetails iQuestionDetails = new QuestionDetails(1, "TEST", 1);
        questions.put(iQuestionDetails, null);
        when(request.getParameter("1result")).thenReturn("test");
        iResponseHandler.getResponses(request, questions);
        assertEquals(1, answer.getAnswers().size());
    }

    @Test
    void getResponsesFailTest() {
        Map<IQuestionDetails, List<IOption>> questions = new HashMap<>();
        IQuestionDetails iQuestionDetails = new QuestionDetails(1, "TEST", 1);
        questions.put(iQuestionDetails, null);
        when(request.getParameter("result")).thenReturn("test");
        iResponseHandler.getResponses(request, questions);
        assertEquals(1, answer.getAnswers().size());
    }
}
