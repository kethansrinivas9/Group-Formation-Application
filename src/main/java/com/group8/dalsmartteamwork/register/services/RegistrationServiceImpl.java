package com.group8.dalsmartteamwork.register.services;

import com.group8.dalsmartteamwork.register.dao.RegistrationDao;
import com.group8.dalsmartteamwork.register.dao.RegistrationDaoImpl;
import com.group8.dalsmartteamwork.utils.Encryption;
import com.group8.dalsmartteamwork.utils.User;

public class RegistrationServiceImpl implements RegistrationService {
    private RegistrationDao dao;

    public RegistrationServiceImpl() {}

    public RegistrationServiceImpl(RegistrationDao dao){
        this.dao = dao;
    }

    @Override
    public Boolean registerUser(User user) {
        try{
            if(this.dao == null){
                this.dao = new RegistrationDaoImpl();
            }
            Encryption encryption = new Encryption();
            user.setPassword(encryption.encrypt(user.getPassword()));
            return this.dao.addUserToDb(user);
        }
        catch (Exception e){
            //TODO: Add to Log
            e.printStackTrace();
            return false;
        }
    }
}
