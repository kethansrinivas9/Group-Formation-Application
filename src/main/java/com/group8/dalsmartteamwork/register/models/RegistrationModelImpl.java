package com.group8.dalsmartteamwork.register.models;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.login.model.IEncryption;
import com.group8.dalsmartteamwork.register.dao.IRegistrationDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistrationModelImpl implements IRegistrationModel {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final IRegistrationDao iRegistrationDao;
    private final IEncryption iEncryption;

    public RegistrationModelImpl(IRegistrationFactory iRegistrationFactory) {
        iRegistrationDao = iRegistrationFactory.getRegistrationDaoObject();
        iEncryption = iRegistrationFactory.getEncryptionObject();
    }

    @Override
    public Boolean registerUser(User user) {
        try {
            user.setPassword(iEncryption.encrypt(user.getPassword()));
            Boolean createUserStatus = iRegistrationDao.addUserToDb(user);
            Boolean addGuestRoleStatus = iRegistrationDao.addGuestRoleToUser(user.getId());
            return createUserStatus && addGuestRoleStatus;
        } catch (Exception e) {
            LOGGER.error("Exception occerred while trying to register user. ", e);
            return false;
        }
    }
}
