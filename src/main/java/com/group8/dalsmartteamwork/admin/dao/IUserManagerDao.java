package com.group8.dalsmartteamwork.admin.dao;

import java.util.List;

public interface IUserManagerDao {

    List<String> getListOfNonAdminUsers();

    String getCourseInstructor(String courseID);

    List<String> getUsersWhoAreGuestsOrInstructors(String courseID);

}
