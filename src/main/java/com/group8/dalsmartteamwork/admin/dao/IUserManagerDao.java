package com.group8.dalsmartteamwork.admin.dao;

import java.util.List;

public interface IUserManagerDao {

    public List<String> getListOfNonAdminUsers();

    public String getCourseInstructor(String courseID);

    public List<String> getUsersWhoAreGuestsOrInstructors(String courseID);

}
