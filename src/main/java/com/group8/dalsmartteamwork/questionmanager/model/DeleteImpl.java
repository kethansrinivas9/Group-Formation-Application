package com.group8.dalsmartteamwork.questionmanager.model;

import com.group8.dalsmartteamwork.questionmanager.dao.DeleteDao;
import com.group8.dalsmartteamwork.questions.Question;

import java.util.List;

public class DeleteImpl implements Delete {
    private final DeleteDao deleteDao;

    public DeleteImpl(DeleteDao deleteDao) {
        this.deleteDao = deleteDao;
    }

    @Override
    public List<Question> displayListOfQuestions(String BannerID) {
        return deleteDao.displayListOfQuestions(BannerID);
    }

    @Override
    public boolean deleteQuestion(int questionID) {
        return deleteDao.deleteQuestion(questionID);
    }
}