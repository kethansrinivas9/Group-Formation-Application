package com.group8.dalsmartteamwork.groups.models;

import com.group8.dalsmartteamwork.groups.IGroup;

import java.util.List;

public interface IGroupDisplayManager {
    List<IGroup> getGroups(int courseId);

    List<Integer> getInstructorCourses(String bannerId);
}
