package com.group8.dalsmartteamwork.accesscontrol;

import java.util.Set;

public class CurrentUser {
    private static CurrentUser currentUser;
    private String BannerId;
    private Set<String> Roles;

    private CurrentUser() {
    }

    public static CurrentUser getInstance() {
        if (currentUser == null) {
            currentUser = new CurrentUser();
        }
        return currentUser;
    }

    public String getBannerId() {
        return BannerId;
    }

    public void setBannerId(String bannerId) {
        BannerId = bannerId;
    }

    public Set<String> getRoles() {
        return Roles;
    }

    public void setRoles(Set<String> roles) {
        Roles = roles;
    }
}
