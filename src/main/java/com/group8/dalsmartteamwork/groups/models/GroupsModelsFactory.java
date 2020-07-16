package com.group8.dalsmartteamwork.groups.models;

import com.group8.dalsmartteamwork.groups.dao.GroupsDaoFactory;

public class GroupsModelsFactory extends GroupsModelsAbstractFactory {
    private static GroupsModelsFactory instance = null;
    private IGroupDisplayManager groupDisplayManager;

    GroupsModelsFactory() {
    }

    public static GroupsModelsFactory instance() {
        if (null == instance) {
            instance = new GroupsModelsFactory();
        }
        return instance;
    }

    @Override
    public IGroupDisplayManager groupDisplayManager() {
        if (null == groupDisplayManager) {
            groupDisplayManager = new GroupDisplayManagerImpl(GroupsDaoFactory.instance().groupRetrieverDao());
        }
        return groupDisplayManager;
    }
}
