package com.group8.dalsmartteamwork.createsurvey.dao;

import com.group8.dalsmartteamwork.questions.Question;

import java.util.List;

public interface CreateSurveyTADao {

    List<Question> displayQuestionsTA(String BannerID, int courseID);
}