package com.group8.dalsmartteamwork.register.models;

import com.group8.dalsmartteamwork.login.model.Encryption;
import com.group8.dalsmartteamwork.login.model.IEncryption;
import com.group8.dalsmartteamwork.register.dao.IRegistrationDao;
import com.group8.dalsmartteamwork.register.dao.RegistrationDaoImpl;
import com.group8.dalsmartteamwork.resetpassword.models.IMail;
import com.group8.dalsmartteamwork.resetpassword.models.Mail;

public class RegistrationFactoryImpl implements IRegistrationFactory {

    @Override
    public IRegistrationDao getRegistrationDaoObject() {
        return new RegistrationDaoImpl();
    }

    @Override
    public IMail getMailObject() {
        return new Mail();
    }

    @Override
    public IEncryption getEncryptionObject() {
        return new Encryption();
    }

}
