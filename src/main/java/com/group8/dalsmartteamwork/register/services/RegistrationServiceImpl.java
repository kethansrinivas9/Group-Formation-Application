package com.group8.dalsmartteamwork.register.services;

import com.group8.dalsmartteamwork.register.dao.RegistrationDaoImpl;
import com.group8.dalsmartteamwork.utils.Encryption;
import com.group8.dalsmartteamwork.utils.User;

public class RegistrationServiceImpl implements RegistrationService {
    @Override
    public Boolean registerUser(User user) {
        try{
            RegistrationDaoImpl dao = new RegistrationDaoImpl();
            Encryption encryption = new Encryption();
            user.setPassword(encryption.encrypt(user.getPassword()));
            return dao.addUserToDb(user);
        }
        catch (Exception e){
            //TODO: Add to Log
            e.printStackTrace();
            return false;
        }
    }
}
