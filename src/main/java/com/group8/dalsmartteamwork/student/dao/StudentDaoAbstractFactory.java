package com.group8.dalsmartteamwork.student.dao;

public abstract class StudentDaoAbstractFactory {
    public abstract IStudentDao studentDao();

    public abstract ISurveyManagerDao surveyManagerDao();
}
