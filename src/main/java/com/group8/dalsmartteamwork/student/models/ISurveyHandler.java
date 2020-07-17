package com.group8.dalsmartteamwork.student.models;

import com.group8.dalsmartteamwork.questions.IOption;
import com.group8.dalsmartteamwork.student.IQuestionDetails;

import java.util.List;
import java.util.Map;

public interface ISurveyHandler {
    Map<IQuestionDetails, List<IOption>> getQuestions(int courseId);

    Boolean saveResponses(Map<Integer, List<String>> answers, String bannerId, int courseId);

    Boolean getSurveyPublishStatus(int courseId);
}
