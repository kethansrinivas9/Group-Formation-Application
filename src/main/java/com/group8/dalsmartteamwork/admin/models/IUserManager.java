package com.group8.dalsmartteamwork.admin.models;

import com.group8.dalsmartteamwork.course.model.Course;
import com.group8.dalsmartteamwork.utils.User;

import java.util.List;

public interface IUserManager {

    public List<String> getListOfNonAdminUsers();

    public String getCourseInstructor(String courseID);

    public List<String> getUsersWhoAreGuestsOrInstructors(String courseID);

}
