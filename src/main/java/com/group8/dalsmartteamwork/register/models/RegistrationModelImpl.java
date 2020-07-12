package com.group8.dalsmartteamwork.register.models;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.login.model.Encryption;
import com.group8.dalsmartteamwork.login.model.IEncryption;
import com.group8.dalsmartteamwork.register.dao.IRegistrationDao;

public class RegistrationModelImpl implements IRegistrationModel {
    private IRegistrationDao dao;
    private IEncryption iEncryption;

    public RegistrationModelImpl(IRegistrationFactory iRegistrationFactory) {
        dao = iRegistrationFactory.getRegistrationDaoObject();
        iEncryption = iRegistrationFactory.getEncryptionObject();
    }

    @Override
    public Boolean registerUser(User user) {
        try {
            user.setPassword(iEncryption.encrypt(user.getPassword()));
            Boolean createUserStatus = dao.addUserToDb(user);
            Boolean addGuestRoleStatus = dao.addGuestRoleToUser(user.getId());
            return createUserStatus && addGuestRoleStatus;
        } catch (Exception e) {
            //TODO: Add to Log
            e.printStackTrace();
            return false;
        }
    }
}
