package com.group8.dalsmartteamwork.groups;

public class GroupsFactory extends GroupsAbstractFactory{
    private static GroupsFactory instance = null;
    private IGroup group;

    GroupsFactory() {
    }

    public static GroupsFactory instance() {
        if (null == instance) {
            instance = new GroupsFactory();
        }
        return instance;
    }

    @Override
    public IGroup group() {
        if (null == group) {
            group = new Group();
        }
        return group;
    }
}
