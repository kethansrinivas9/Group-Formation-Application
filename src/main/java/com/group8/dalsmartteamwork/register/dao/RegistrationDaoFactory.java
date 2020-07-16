package com.group8.dalsmartteamwork.register.dao;

public class RegistrationDaoFactory extends RegistrationDaoAbstractFactory {
	private static RegistrationDaoFactory instance = null;
	private IRegistrationDao registrationDao;

	RegistrationDaoFactory() {
	}

	public static RegistrationDaoFactory instance() {
		if (null == instance) {
			instance = new RegistrationDaoFactory();
		}
		return instance;
	}

	@Override
	public IRegistrationDao registrationDao() {
		if (null == registrationDao) {
			registrationDao = new RegistrationDaoImpl();
		}
		return registrationDao;
	}
}
