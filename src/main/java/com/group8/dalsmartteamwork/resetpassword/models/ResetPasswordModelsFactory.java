package com.group8.dalsmartteamwork.resetpassword.models;

import com.group8.dalsmartteamwork.resetpassword.dao.IResetPasswordDao;
import com.group8.dalsmartteamwork.resetpassword.dao.ResetPasswordDaoImpl;

public class ResetPasswordModelsFactory extends ResetPasswordModelsAbstractFactory {
	private static ResetPasswordModelsFactory instance = null;
	private IMail mail;
	private INewPassword newPassword;
	private IPasswordPolicy passwordPolicy;
	private IPasswordResetToken passwordResetToken;
	private IResetPasswordManager resetPasswordManager;
	private IResetPasswordRequest resetPasswordRequest;
	private IResetToken resetToken;


	ResetPasswordModelsFactory() {
	}

	public static ResetPasswordModelsFactory instance() {
		if (null == instance) {
			instance = new ResetPasswordModelsFactory();
		}
		return instance;
	}

	@Override
	public INewPassword newPassword() {
		if (null == newPassword) {
			newPassword = new NewPassword();
		}
		return newPassword;
	}

	@Override
	public IMail mail() {
		if (null == mail) {
			mail = new Mail();
		}
		return mail;
	}

	@Override
	public IPasswordPolicy passwordPolicy() {
		if (null == passwordPolicy) {
			passwordPolicy = new PasswordPolicy();
		}
		return passwordPolicy;
	}

	@Override
	public IPasswordResetToken passwordResetToken() {
		if (null == passwordResetToken) {
			passwordResetToken = new PasswordResetToken();
		}
		return passwordResetToken;
	}

	@Override
	public IResetPasswordManager resetPasswordManager() {
		if (null == resetPasswordManager) {
			resetPasswordManager = new ResetPasswordManagerImpl();
		}
		return resetPasswordManager;
	}

	@Override
	public IResetPasswordRequest resetPasswordRequest() {
		if (null == resetPasswordRequest) {
			resetPasswordRequest = new ResetPasswordRequest();
		}
		return resetPasswordRequest;
	}

	@Override
	public IResetToken resetToken() {
		if (null == resetToken) {
			resetToken = new ResetToken();
		}
		return resetToken;
	}

}
