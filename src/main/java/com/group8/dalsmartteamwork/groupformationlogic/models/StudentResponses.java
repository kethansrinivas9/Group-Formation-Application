package com.group8.dalsmartteamwork.groupformationlogic.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentResponses implements IStudentResponses {
    private String bannerID;
    private Map<Integer, List<String>> responses = new HashMap<>();

    @Override
    public void addAnswer(Integer questionID, String response) {
        if (responses.containsKey(questionID)) {
            responses.get(questionID).add(response);
        } else {
            List<String> questionResponses = new ArrayList<String>();
            questionResponses.add(response);
            responses.put(questionID, questionResponses);
        }
    }

    @Override
    public String getBannerID() {
        return bannerID;
    }

    @Override
    public void setBannerID(String bannerID) {
        this.bannerID = bannerID;
    }

    @Override
    public Map<Integer, List<String>> getResponses() {
        return responses;
    }

    @Override
    public void setResponses(Map<Integer, List<String>> responses) {
        this.responses = responses;
    }
}
