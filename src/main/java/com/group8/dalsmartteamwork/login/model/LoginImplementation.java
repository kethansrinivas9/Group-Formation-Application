package com.group8.dalsmartteamwork.login.model;

import com.group8.dalsmartteamwork.login.dao.LoginDao;

public class LoginImplementation implements Login {

    private LoginDao loginDao;

    public LoginImplementation(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public Boolean getUserDetails(String id, String firstName, String email, String password) {
        return loginDao.getUserDetails(id, firstName, email, password);
    }

}