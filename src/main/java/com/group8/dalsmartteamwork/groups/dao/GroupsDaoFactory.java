package com.group8.dalsmartteamwork.groups.dao;

public class GroupsDaoFactory extends GroupsDaoAbstractFactory {
    private static GroupsDaoFactory instance = null;
    private IGroupRetrieverDao groupRetrieverDao;

    GroupsDaoFactory() {
    }

    public static GroupsDaoFactory instance() {
        if (null == instance) {
            instance = new GroupsDaoFactory();
        }
        return instance;
    }

    @Override
    public IGroupRetrieverDao groupRetrieverDao() {
        if (null == groupRetrieverDao) {
            groupRetrieverDao = new GroupRetrieverDaoImpl();
        }
        return groupRetrieverDao;
    }
}
