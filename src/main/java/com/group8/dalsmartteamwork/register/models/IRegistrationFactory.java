package com.group8.dalsmartteamwork.register.models;

import com.group8.dalsmartteamwork.login.model.IEncryption;
import com.group8.dalsmartteamwork.register.dao.IRegistrationDao;
import com.group8.dalsmartteamwork.resetpassword.models.IMail;

public interface IRegistrationFactory {
    IRegistrationDao getRegistrationDaoObject();

    IMail getMailObject();

    IEncryption getEncryptionObject();
}
