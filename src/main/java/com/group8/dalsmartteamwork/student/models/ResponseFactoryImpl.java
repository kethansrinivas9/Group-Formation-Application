package com.group8.dalsmartteamwork.student.models;

import com.group8.dalsmartteamwork.student.*;

public class ResponseFactoryImpl implements IResponseFactory {
    @Override
    public IResponseObject getResponseObject(int questionId) {
        if (questionId == 1) {
            return new NumericResponse();
        } else if (questionId == 2) {
            return new MultipleChoiceSingleResponse();
        } else if (questionId == 3) {
            return new MultipleChoiceMultipleResponse();
        } else {
            return new FreeTextResponse();
        }
    }
}
