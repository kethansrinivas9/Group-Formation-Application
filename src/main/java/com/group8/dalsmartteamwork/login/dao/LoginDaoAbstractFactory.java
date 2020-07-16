package com.group8.dalsmartteamwork.login.dao;

public abstract class LoginDaoAbstractFactory {
    public abstract ICourseRoleDao courseRoleDao();

    public abstract ILoginDao loginDao();
}
