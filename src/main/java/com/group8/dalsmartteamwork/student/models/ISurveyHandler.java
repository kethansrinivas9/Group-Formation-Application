package com.group8.dalsmartteamwork.student.models;

import com.group8.dalsmartteamwork.questions.IOption;
import com.group8.dalsmartteamwork.student.IQuestionDetails;

import java.util.HashMap;
import java.util.List;

public interface ISurveyHandler {
    HashMap<IQuestionDetails, List<IOption>> getQuestions(int courseId);
}
