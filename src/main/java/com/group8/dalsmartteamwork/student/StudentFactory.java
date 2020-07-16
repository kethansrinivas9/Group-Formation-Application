package com.group8.dalsmartteamwork.student;

public class StudentFactory extends StudentAbstractFactory {
    private static StudentFactory instance = null;
    private IQuestionDetails questionDetails;
    private IResponseObject responseObject;
    private IStudent student;
    private Answer answer;
    private IResponseObject freeTextResponse;
    private IResponseObject multipleChoiceMultipleResponse;
    private IResponseObject multipleChoiceSingleResponse;
    private IResponseObject numericResponse;

    StudentFactory() {
    }

    public static StudentFactory instance() {
        if (null == instance) {
            instance = new StudentFactory();
        }
        return instance;
    }

    @Override
    public IQuestionDetails questionDetails() {
        if (null == questionDetails) {
            questionDetails = new QuestionDetails();
        }
        return questionDetails;
    }

    @Override
    public IStudent student() {
        if (null == student) {
            student = new Student();
        }
        return student;
    }

    @Override
    public Answer answer() {
        if (null == answer) {
            answer = new Answer();
        }
        return answer;
    }

    @Override
    public IResponseObject freeTextResponse() {
        if (null == freeTextResponse) {
            freeTextResponse = new FreeTextResponse();
        }
        return freeTextResponse;
    }

    @Override
    public IResponseObject multipleChoiceMultipleResponse() {
        if (null == multipleChoiceMultipleResponse) {
            multipleChoiceMultipleResponse = new MultipleChoiceMultipleResponse();
        }
        return multipleChoiceMultipleResponse;
    }

    @Override
    public IResponseObject multipleChoiceSingleResponse() {
        if (null == multipleChoiceSingleResponse) {
            multipleChoiceSingleResponse = new MultipleChoiceSingleResponse();
        }
        return multipleChoiceSingleResponse;
    }


    @Override
    public IResponseObject numericResponse() {
        if (null == numericResponse) {
            numericResponse = new NumericResponse();
        }
        return numericResponse;
    }
}
