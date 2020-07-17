package com.group8.dalsmartteamwork.course.models;

import com.group8.dalsmartteamwork.accesscontrol.User;

import java.util.List;

public interface ICourseInstructorManager {
    List<User> getCurrentTAs(int courseID);

    List<User> getCurrentStudents(int courseID);

    List<User> getEligibleTAs(int courseID);

    Boolean addTAtoCourse(String bannerID, int courseID);

    Boolean courseExists(int courseID);
}
