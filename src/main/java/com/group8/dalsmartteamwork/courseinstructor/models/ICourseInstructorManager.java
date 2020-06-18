package com.group8.dalsmartteamwork.courseinstructor.models;

import com.group8.dalsmartteamwork.utils.User;

import java.util.List;

public interface ICourseInstructorManager {
    List<User> getCurrentTAs(int courseID);

    List<User> getCurrentStudents(int courseID);

    List<User> getEligibleTAs(int courseID);

    Boolean addTAtoCourse(String bannerID, int courseID);

    Boolean courseExists(int courseID);
}
