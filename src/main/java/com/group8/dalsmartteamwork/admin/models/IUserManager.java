package com.group8.dalsmartteamwork.admin.models;

import java.util.List;

public interface IUserManager {

    List<String> getListOfNonAdminUsers();

    String getCourseInstructor(String courseID);

    List<String> getUsersWhoAreGuestsOrInstructors(String courseID);

}
