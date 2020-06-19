package com.group8.dalsmartteamwork.questionmanager.model;

import com.group8.dalsmartteamwork.questions.Question;

import java.util.List;

public interface Delete {

    List<Question> displayListOfQuestions(String BannerID);

    boolean deleteQuestion(int questionID);
}