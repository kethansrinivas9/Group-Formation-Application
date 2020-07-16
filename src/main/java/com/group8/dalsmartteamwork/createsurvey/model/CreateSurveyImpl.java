package com.group8.dalsmartteamwork.createsurvey.model;

import com.group8.dalsmartteamwork.course.Course;
import com.group8.dalsmartteamwork.createsurvey.dao.ICreateSurveyDao;
import com.group8.dalsmartteamwork.questions.Question;
import java.util.List;

public class CreateSurveyImpl implements CreateSurvey {
    private final ICreateSurveyDao iCreateSurveyDao;

    public CreateSurveyImpl(ICreateSurveyDao iCreateSurveyDao) {
        this.iCreateSurveyDao = iCreateSurveyDao;
    }
    
    @Override
    public boolean checkIfSurveyCreated(int courseID) {
        return iCreateSurveyDao.checkIfSurveyCreated(courseID);
    }

    @Override
    public List<Question> displayQuestions(String BannerID, int courseID) {
        return iCreateSurveyDao.displayQuestions(BannerID, courseID);
    }

    @Override
    public boolean publishSurvey(int courseID) {
        return iCreateSurveyDao.publishSurvey(courseID);
    }

    @Override
    public boolean saveQuestions(int courseID, List<Integer> questionID) {
        return iCreateSurveyDao.saveQuestions(courseID, questionID);
    }

    @Override
    public List<Course> displayListOfCourses(String BannerID) {
        return iCreateSurveyDao.displayListOfCourses(BannerID);
    }

}