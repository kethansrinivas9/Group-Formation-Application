package com.group8.dalsmartteamwork.createsurvey.model;

import java.util.List;
import com.group8.dalsmartteamwork.course.Course;
import com.group8.dalsmartteamwork.questions.Question;

public interface CreateSurvey {

    List<Course> displayListOfCourses(String BannerID);

    boolean checkIfSurveyCreated(int courseID);

    List<Question> displayQuestions(String BannerID,int courseID);
    
    boolean saveQuestions(int courseID,List<Integer> questionID);

    boolean publishSurvey(int courseID);
}