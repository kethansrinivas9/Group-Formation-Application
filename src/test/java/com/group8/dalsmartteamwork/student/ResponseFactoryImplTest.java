package com.group8.dalsmartteamwork.student;

import com.group8.dalsmartteamwork.student.models.ResponseFactoryImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResponseFactoryImplTest {
    @Test
    void getResponseObject() {
        ResponseFactoryImpl responseFactory = new ResponseFactoryImpl();
        IResponseObject numericResponse = new NumericResponse();
        assertEquals(numericResponse.getClass(), responseFactory.getResponseObject(1).getClass());

        IResponseObject mcqOneObject = new MultipleChoiceSingleResponse();
        assertEquals(mcqOneObject.getClass(), responseFactory.getResponseObject(2).getClass());

        IResponseObject mcqMultipleObject = new MultipleChoiceMultipleResponse();
        assertEquals(mcqMultipleObject.getClass(), responseFactory.getResponseObject(3).getClass());

        IResponseObject freeTextObject = new FreeTextResponse();
        assertEquals(freeTextObject.getClass(), responseFactory.getResponseObject(4).getClass());
    }
}
