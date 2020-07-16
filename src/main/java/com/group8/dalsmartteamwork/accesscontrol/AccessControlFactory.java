package com.group8.dalsmartteamwork.accesscontrol;

public class AccessControlFactory extends AccessControlAbstractFactory {
    private static AccessControlFactory instance = null;
    private IUser user;
    private CurrentUser currentUser;

    AccessControlFactory() {
    }

    public static AccessControlFactory instance() {
        if (null == instance) {
            instance = new AccessControlFactory();
        }
        return instance;
    }

    @Override
    public IUser user() {
        if (null == user) {
            user = new User();
        }
        return user;
    }
}
