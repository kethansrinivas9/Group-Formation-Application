package com.group8.dalsmartteamwork.createsurvey.model;

import com.group8.dalsmartteamwork.questions.Question;

import java.util.List;

public interface CreateSurveyTA {

    List<Question> displayQuestionsTA(String BannerID, int courseID);
}