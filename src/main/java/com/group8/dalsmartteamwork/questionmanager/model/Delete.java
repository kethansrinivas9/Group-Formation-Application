package com.group8.dalsmartteamwork.questionmanager.model;

import java.util.List;
import com.group8.dalsmartteamwork.questions.Question;

public interface Delete {

    public List<Question> displayListOfQuestions(String BannerID);

    public boolean deleteQuestion(int questionID);
}