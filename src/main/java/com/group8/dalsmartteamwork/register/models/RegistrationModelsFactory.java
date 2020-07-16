package com.group8.dalsmartteamwork.register.models;

import com.group8.dalsmartteamwork.resetpassword.dao.*;

public class RegistrationModelsFactory extends RegistrationModelsAbstractionFactory{
    private static RegistrationModelsFactory instance = null;
    private IRegistrationFactory registrationFactory;
    private IRegistrationModel registrationModel;

    RegistrationModelsFactory() {
    }

    public static RegistrationModelsFactory instance() {
        if (null == instance) {
            instance = new RegistrationModelsFactory();
        }
        return instance;
    }

    @Override
    public IRegistrationFactory registrationFactory() {
        if (null == registrationFactory) {
            registrationFactory = new RegistrationFactoryImpl();
        }
        return registrationFactory;
    }

    @Override
    public IRegistrationModel registrationModel() {
        if (null == registrationModel) {
            registrationModel = new RegistrationModelImpl(registrationFactory());
        }
        return registrationModel;
    }
}
