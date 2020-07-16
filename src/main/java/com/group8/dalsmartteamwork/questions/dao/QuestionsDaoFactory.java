package com.group8.dalsmartteamwork.questions.dao;

import com.group8.dalsmartteamwork.resetpassword.dao.IPasswordHistoryManager;
import com.group8.dalsmartteamwork.resetpassword.dao.IResetPasswordDao;
import com.group8.dalsmartteamwork.resetpassword.dao.ResetPasswordDaoFactory;
import com.group8.dalsmartteamwork.resetpassword.dao.ResetPasswordDaoImpl;

public class QuestionsDaoFactory extends QuestionsDaoAbstractFactory{
    private static QuestionsDaoFactory instance = null;
    private IQuestionDao questionDao;

    QuestionsDaoFactory() {
    }

    public static QuestionsDaoFactory instance() {
        if (null == instance) {
            instance = new QuestionsDaoFactory();
        }
        return instance;
    }

    @Override
    public IQuestionDao questionDao() {
        if (null == questionDao) {
            questionDao = new QuestionDao();
        }
        return questionDao;
    }
}
