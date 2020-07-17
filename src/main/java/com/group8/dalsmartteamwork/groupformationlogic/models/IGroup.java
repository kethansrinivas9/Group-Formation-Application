package com.group8.dalsmartteamwork.groupformationlogic.models;

import java.util.List;

public interface IGroup {
    Integer getGroupID();

    void setGroupID(Integer groupID);

    List<String> getBannerID();

    void setBannerID(List<String> bannerID);

    Integer getCourseID();

    void setCourseID(Integer courseID);
}
