package com.group8.dalsmartteamwork.student;

public class NumericResponse implements IResponseObject {
    @Override
    public void addResponse(int questionId, String response) {
        Answer answer = Answer.getInstance();
        answer.addAnswer(questionId, response);
    }
}
