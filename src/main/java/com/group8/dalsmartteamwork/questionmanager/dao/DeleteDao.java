package com.group8.dalsmartteamwork.questionmanager.dao;

import java.util.List;
import com.group8.dalsmartteamwork.questions.Question;

public interface DeleteDao {

    public List<Question> displayListOfQuestions(String BannerID);

    public boolean deleteQuestion(int questionID);
}