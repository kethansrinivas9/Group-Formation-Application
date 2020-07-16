package com.group8.dalsmartteamwork.resetpassword.models;

public abstract class ResetPasswordModelsAbstractFactory {
    public abstract INewPassword newPassword();

    public abstract IMail mail();

    public abstract IPasswordPolicy passwordPolicy();

    public abstract IPasswordResetToken passwordResetToken();

    public abstract IResetPasswordManager resetPasswordManager();

    public abstract IResetPasswordRequest resetPasswordRequest();

    public abstract IResetToken resetToken();
}
