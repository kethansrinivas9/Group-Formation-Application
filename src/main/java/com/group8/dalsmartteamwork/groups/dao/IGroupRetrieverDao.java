package com.group8.dalsmartteamwork.groups.dao;

import com.group8.dalsmartteamwork.groups.IGroup;

import java.util.List;

public interface IGroupRetrieverDao {
    List<IGroup> getGroups(int courseId);

    List<Integer> getCourses(String bannerId);
}
