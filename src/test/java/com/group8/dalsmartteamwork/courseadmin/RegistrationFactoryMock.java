package com.group8.dalsmartteamwork.courseadmin;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.login.model.Encryption;
import com.group8.dalsmartteamwork.login.model.IEncryption;
import com.group8.dalsmartteamwork.register.dao.IRegistrationDao;
import com.group8.dalsmartteamwork.register.dao.RegistrationDaoImpl;
import com.group8.dalsmartteamwork.register.models.IRegistrationFactory;
import com.group8.dalsmartteamwork.resetpassword.models.IMail;
import com.group8.dalsmartteamwork.resetpassword.models.Mail;

import static org.mockito.Mockito.*;

public class RegistrationFactoryMock implements IRegistrationFactory {
    private final User existingUser = new User("B00000000", "fName", "lName", "email@email.com", "pwd");
    private final User newUser = new User("B1111111", "fName", "lName", "email@email.com", "pwd");

    @Override
    public IRegistrationDao getRegistrationDaoObject() {
        IRegistrationDao iRegistrationDao = mock(RegistrationDaoImpl.class);
        when(iRegistrationDao.isUserInDb(existingUser.getId())).thenReturn(true);
        when(iRegistrationDao.isUserInDb(newUser.getId())).thenReturn(false);
        when(iRegistrationDao.addUserToDb(existingUser)).thenReturn(false);
        when(iRegistrationDao.addUserToDb(newUser)).thenReturn(true);
        return iRegistrationDao;
    }

    @Override
    public IMail getMailObject() {
        IMail iMail = mock(Mail.class);
        when(iMail.sendEmail(anyString(), anyString(), anyString())).thenReturn(true);
        return iMail;
    }

    @Override
    public IEncryption getEncryptionObject() {
        IEncryption iEncryption = mock(Encryption.class);
        when(iEncryption.encrypt(anyString())).thenReturn("TEST");
        when(iEncryption.decrypt(anyString())).thenReturn("TEST");
        return iEncryption;
    }
}
