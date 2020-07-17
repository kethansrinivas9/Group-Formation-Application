package com.group8.dalsmartteamwork.createsurvey.model;

import com.group8.dalsmartteamwork.course.Course;
import com.group8.dalsmartteamwork.createsurvey.dao.CreateSurveyDao;
import com.group8.dalsmartteamwork.questions.Question;

import java.util.List;

public class CreateSurveyImpl implements CreateSurvey {
    private final CreateSurveyDao createSurveyDao;

    public CreateSurveyImpl(CreateSurveyDao createSurveyDao) {
        this.createSurveyDao = createSurveyDao;
    }

    @Override
    public boolean checkIfSurveyCreated(int courseID) {
        return createSurveyDao.checkIfSurveyCreated(courseID);
    }

    @Override
    public List<Question> displayQuestions(String BannerID, int courseID) {
        return createSurveyDao.displayQuestions(BannerID, courseID);
    }

    @Override
    public boolean publishSurvey(int courseID) {
        return createSurveyDao.publishSurvey(courseID);
    }

    @Override
    public boolean saveQuestions(int courseID, List<Integer> questionID) {
        return createSurveyDao.saveQuestions(courseID, questionID);
    }

    @Override
    public List<Course> displayListOfCourses(String BannerID) {
        return createSurveyDao.displayListOfCourses(BannerID);
    }

}