package com.group8.dalsmartteamwork.questionmanager.dao;

public class QuestionManagerDaoFactory extends QuestionManagerDaoAbstractFactory{
    private static QuestionManagerDaoFactory instance = null;
    private DeleteDao deleteDao;
    private SortDao sortDao;

    QuestionManagerDaoFactory() {
    }

    public static QuestionManagerDaoFactory instance() {
        if (null == instance) {
            instance = new QuestionManagerDaoFactory();
        }
        return instance;
    }

    @Override
    public DeleteDao deleteDao() {
        if (null == deleteDao) {
            deleteDao = new DeleteDaoImpl();
        }
        return deleteDao;
    }

    @Override
    public SortDao sortDao() {
        if (null == sortDao) {
            sortDao = new SortDaoImpl();
        }
        return sortDao;
    }
}
