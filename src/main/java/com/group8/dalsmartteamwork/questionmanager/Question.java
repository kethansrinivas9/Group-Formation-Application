package com.group8.dalsmartteamwork.questionmanager;

public class Question {

    private String BannerID;
    private String questionTitle;
    private String questionText;
    private int questionID;
    
    public Question(int questionID, String questionText) {
        this.questionText = questionText;
        this.questionID = questionID;
    }

    public Question() {
    }
    
    public String getBannerID() {
        return BannerID;
    }

    public void setBannerID(String bannerID ) {
        BannerID = bannerID;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public Question(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }
    
}