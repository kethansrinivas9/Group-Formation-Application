package com.group8.dalsmartteamwork.groupformationlogic.models;

import java.util.List;
import java.util.Map;

public interface IStudentResponses {
    void addAnswer(Integer questionID, String response);

    String getBannerID();

    void setBannerID(String bannerID);

    Map<Integer, List<String>> getResponses();

    void setResponses(Map<Integer, List<String>> responses);
}
