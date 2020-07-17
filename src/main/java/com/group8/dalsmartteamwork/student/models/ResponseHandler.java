package com.group8.dalsmartteamwork.student.models;

import com.group8.dalsmartteamwork.questions.IOption;
import com.group8.dalsmartteamwork.student.IQuestionDetails;
import com.group8.dalsmartteamwork.student.IResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class ResponseHandler implements IResponseHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final IResponseFactory iResponseFactory;

    public ResponseHandler(IResponseFactory iResponseFactory) {
        this.iResponseFactory = iResponseFactory;
    }

    @Override
    public void getResponses(HttpServletRequest request, Map<IQuestionDetails, List<IOption>> questions) {
        for (IQuestionDetails question : questions.keySet()) {
            int questionId = question.getQuestionId();
            IResponseObject iResponseObject = iResponseFactory.getResponseObject(questionId);
            String parameter = "" + question.getQuestionId() + "result";
            String response = request.getParameter(parameter);
            if (response != null) {
                iResponseObject.addResponse(questionId, response);
            }
            if (questions.get(question) != null) {
                for (IOption option : questions.get(question)) {
                    parameter = "" + question.getQuestionId() + "result" + option.getStoredAs();
                    response = request.getParameter(parameter);
                    if (response != null) {
                        iResponseObject.addResponse(questionId, response);
                    }
                }
            }
        }
    }
}
