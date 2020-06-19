package com.group8.dalsmartteamwork.questionmanager.dao;

import com.group8.dalsmartteamwork.questions.Question;

import java.util.List;

public interface DeleteDao {

    List<Question> displayListOfQuestions(String BannerID);

    boolean deleteQuestion(int questionID);
}