package com.group8.dalsmartteamwork.admin.dao;

public abstract class AdminDaoAbstractFactory {
    public abstract ICourseManagerDao courseManagerDao();

    public abstract IUserManagerDao userManagerDao();
}
