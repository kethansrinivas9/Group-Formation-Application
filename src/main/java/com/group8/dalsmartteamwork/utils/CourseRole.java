package com.group8.dalsmartteamwork.utils;

public class CourseRole {
    private String bannerID;
    private int courseID;
    private int roleID;

    public CourseRole() {
    }

    public CourseRole(String bannerID, int courseID, int roleID) {
        this.bannerID = bannerID;
        this.courseID = courseID;
        this.roleID = roleID;
    }

    public String getBannerID() {
        return bannerID;
    }

    public void setBannerID(String bannerID) {
        this.bannerID = bannerID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
}
