package com.group8.dalsmartteamwork.student.models;

import com.group8.dalsmartteamwork.student.IResponseObject;
import com.group8.dalsmartteamwork.student.StudentFactory;

public class ResponseFactoryImpl implements IResponseFactory {
    @Override
    public IResponseObject getResponseObject(int questionId) {
        if (questionId == 1) {
            return StudentFactory.instance().numericResponse();
        } else if (questionId == 2) {
            return StudentFactory.instance().multipleChoiceSingleResponse();
        } else if (questionId == 3) {
            return StudentFactory.instance().multipleChoiceMultipleResponse();
        } else {
            return StudentFactory.instance().freeTextResponse();
        }
    }
}
