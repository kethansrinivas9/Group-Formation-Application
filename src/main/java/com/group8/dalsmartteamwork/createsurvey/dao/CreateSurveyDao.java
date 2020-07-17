package com.group8.dalsmartteamwork.createsurvey.dao;

import com.group8.dalsmartteamwork.course.Course;
import com.group8.dalsmartteamwork.questions.Question;

import java.util.List;

public interface CreateSurveyDao {

    List<Course> displayListOfCourses(String BannerID);

    boolean checkIfSurveyCreated(int courseID);

    List<Question> displayQuestions(String BannerID, int courseID);

    boolean saveQuestions(int courseID, List<Integer> questionID);

    boolean publishSurvey(int courseID);

}