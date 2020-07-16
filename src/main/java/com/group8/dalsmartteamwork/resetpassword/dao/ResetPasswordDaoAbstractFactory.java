package com.group8.dalsmartteamwork.resetpassword.dao;

public abstract class ResetPasswordDaoAbstractFactory {
    public abstract IResetPasswordDao resetPasswordDao();

    public abstract IPasswordHistoryManager passwordHistoryManager();
}
