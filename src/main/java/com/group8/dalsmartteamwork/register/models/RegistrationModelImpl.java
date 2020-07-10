package com.group8.dalsmartteamwork.register.models;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.login.model.Encryption;
import com.group8.dalsmartteamwork.login.model.IEncryption;
import com.group8.dalsmartteamwork.register.dao.RegistrationDao;

public class RegistrationModelImpl implements IRegistrationModel {
    private final RegistrationDao dao;

    public RegistrationModelImpl(RegistrationDao dao) {
        this.dao = dao;
    }

    @Override
    public Boolean registerUser(User user) {
        try {
            IEncryption encryption = new Encryption();
            user.setPassword(encryption.encrypt(user.getPassword()));
            Boolean createUserStatus = this.dao.addUserToDb(user);
            Boolean addGuestRoleStatus = this.dao.addGuestRoleToUser(user.getId());
            return createUserStatus && addGuestRoleStatus;
        } catch (Exception e) {
            //TODO: Add to Log
            e.printStackTrace();
            return false;
        }
    }
}
