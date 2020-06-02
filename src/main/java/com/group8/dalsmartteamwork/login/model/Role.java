package com.group8.dalsmartteamwork.login.model;

public class Role {
    
    public String roleId;
    public String roleName;
    public String courseName;

    public Role() {

    }

    public Role(String roleId, String roleName, String courseName) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.courseName = courseName;
    }

    public Role(String roleName, String courseName) {
        this.roleName = roleName;
        this.courseName = courseName;
    }    

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
}