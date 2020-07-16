package com.group8.dalsmartteamwork.resetpassword.dao;

public class ResetPasswordDaoFactory extends ResetPasswordDaoAbstractFactory {
	private static ResetPasswordDaoFactory instance = null;
	private IResetPasswordDao resetPasswordDao;
	private IPasswordHistoryManager passwordHistoryManager;

	ResetPasswordDaoFactory() {
	}

	public static ResetPasswordDaoFactory instance() {
		if (null == instance) {
			instance = new ResetPasswordDaoFactory();
		}
		return instance;
	}

	@Override
	public IResetPasswordDao resetPasswordDao() {
		if (null == resetPasswordDao) {
			resetPasswordDao = new ResetPasswordDaoImpl();
		}
		return resetPasswordDao;
	}

	@Override
	public IPasswordHistoryManager passwordHistoryManager() {
		if (null == passwordHistoryManager) {
			passwordHistoryManager = new PasswordHistoryManagerImpl();
		}
		return passwordHistoryManager;
	}
}
