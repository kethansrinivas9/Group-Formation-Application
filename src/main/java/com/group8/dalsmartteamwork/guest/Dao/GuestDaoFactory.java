package com.group8.dalsmartteamwork.guest.Dao;

public class GuestDaoFactory extends GuestDaoAbstractFactory{
    private static GuestDaoFactory instance = null;
    private IGuestDao guestDao;

    GuestDaoFactory() {
    }

    public static GuestDaoFactory instance() {
        if (null == instance) {
            instance = new GuestDaoFactory();
        }
        return instance;
    }

    @Override
    public IGuestDao guestDao() {
        if (null == guestDao) {
            guestDao = new GuestDaoImpl();
        }
        return guestDao;
    }
}
