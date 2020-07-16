package com.group8.dalsmartteamwork.questionmanager.model;

import com.group8.dalsmartteamwork.questionmanager.dao.QuestionManagerDaoFactory;

public class QuestionManagerModelFactory extends QuestionManagerModelAbstractFactory{
    private static QuestionManagerModelFactory instance = null;
    private Delete delete;
    private Sort sort;

    QuestionManagerModelFactory() {
    }

    public static QuestionManagerModelFactory instance() {
        if (null == instance) {
            instance = new QuestionManagerModelFactory();
        }
        return instance;
    }

    @Override
    public Delete delete() {
        if (null == delete) {
            delete = new DeleteImpl(QuestionManagerDaoFactory.instance().deleteDao());
        }
        return delete;
    }

    @Override
    public Sort sort() {
        if (null == sort) {
            sort = new SortImpl(QuestionManagerDaoFactory.instance().sortDao());
        }
        return sort;
    }
}
