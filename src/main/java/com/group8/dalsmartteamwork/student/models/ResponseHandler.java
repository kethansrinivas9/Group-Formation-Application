package com.group8.dalsmartteamwork.student.models;

import com.group8.dalsmartteamwork.questions.IOption;
import com.group8.dalsmartteamwork.student.Answer;
import com.group8.dalsmartteamwork.student.IQuestionDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class ResponseHandler implements IResponseHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public void getResponses(HttpServletRequest request, Map<IQuestionDetails, List<IOption>> questions) {
        Answer answer = Answer.getInstance();
        for (IQuestionDetails question : questions.keySet()) {
            if (questions.get(question) == null || question.getType() == 2) {
                String parameter = "result" + question.getQuestionId();
                String response = request.getParameter(parameter);
                if (response != null) {
                    answer.addAnswer(question.getQuestionId(), response);
                }
            } else {
                for (IOption option : questions.get(question)) {
                    String parameter = "result" + question.getQuestionId() + "option" + option.getStoredAs();
                    String response = request.getParameter(parameter);
                    if (response != null) {
                        answer.addAnswer(question.getQuestionId(), response);
                    }
                }
            }
        }
    }
}
