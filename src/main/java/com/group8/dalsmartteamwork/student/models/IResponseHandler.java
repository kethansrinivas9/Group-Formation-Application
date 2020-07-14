package com.group8.dalsmartteamwork.student.models;

import com.group8.dalsmartteamwork.questions.IOption;
import com.group8.dalsmartteamwork.student.IQuestionDetails;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IResponseHandler {
    void getResponses(HttpServletRequest request, Map<IQuestionDetails, List<IOption>> questions);
}
