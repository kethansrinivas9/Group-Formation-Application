package com.group8.dalsmartteamwork.login.model;

import com.group8.dalsmartteamwork.login.dao.ILoginDao;

public class LoginImpl implements ILogin {

    private final ILoginDao loginDao;

    public LoginImpl(ILoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public Boolean getUserDetails(String id, String firstName, String email, String password) {
        return loginDao.getUserDetails(id, firstName, email, password);
    }

}