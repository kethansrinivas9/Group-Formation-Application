package com.group8.dalsmartteamwork.groupformationlogic.models;

import java.util.List;

public class Group implements IGroup {
    Integer groupID;
    Integer courseID;
    List<String> bannerID;

    @Override
    public Integer getGroupID() {
        return groupID;
    }

    @Override
    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    @Override
    public List<String> getBannerID() {
        return bannerID;
    }

    @Override
    public void setBannerID(List<String> bannerID) {
        this.bannerID = bannerID;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }
}
