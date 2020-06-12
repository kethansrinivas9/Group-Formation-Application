package com.group8.dalsmartteamwork.register.services;

import com.group8.dalsmartteamwork.register.dao.RegistrationDao;
import com.group8.dalsmartteamwork.utils.Encryption;
import com.group8.dalsmartteamwork.utils.User;

public class RegistrationServiceImpl implements RegistrationService {
    private RegistrationDao dao;

    public RegistrationServiceImpl(RegistrationDao dao){
        this.dao = dao;
    }

    @Override
    public Boolean registerUser(User user) {
        try{
            Encryption encryption = new Encryption();
            user.setPassword(encryption.encrypt(user.getPassword()));
            Boolean createUserStatus = this.dao.addUserToDb(user);
            Boolean addGuestRoleStatus = this.dao.addGuestRole(user.getId());
            return createUserStatus && addGuestRoleStatus;
        }
        catch (Exception e){
            //TODO: Add to Log
            e.printStackTrace();
            return false;
        }
    }
}
