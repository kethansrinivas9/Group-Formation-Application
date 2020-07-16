package com.group8.dalsmartteamwork.student.dao;

public class StudentDaoFactory extends StudentDaoAbstractFactory {
    private static StudentDaoFactory instance = null;
    private IStudentDao studentDao;
    private ISurveyManagerDao surveyManagerDao;

    StudentDaoFactory() {
    }

    public static StudentDaoFactory instance() {
        if (null == instance) {
            instance = new StudentDaoFactory();
        }
        return instance;
    }

    @Override
    public IStudentDao studentDao() {
        if (null == studentDao) {
            studentDao = new StudentDaoImpl();
        }
        return studentDao;
    }

    @Override
    public ISurveyManagerDao surveyManagerDao() {
        if (null == surveyManagerDao) {
            surveyManagerDao = new SurveyManagerDaoImpl();
        }
        return surveyManagerDao;
    }
}
