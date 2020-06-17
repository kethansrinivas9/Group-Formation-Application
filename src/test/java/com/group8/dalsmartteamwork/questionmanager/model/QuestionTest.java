package com.group8.dalsmartteamwork.questionmanager.model;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.group8.dalsmartteamwork.questionmanager.model.Question;

import org.junit.jupiter.api.Test;

public class QuestionTest {

    public Question questionMock(){
        Question question = new Question();
        question.setBannerID("12");
        question.setQuestionID(1);
        question.setQuestionText("Java");
        question.setQuestionTitle("Do you like Java?");

        return question;
    }

    @Test
    public void defaultConstructor(){
        Question question1 = new Question();
        assertNull(question1.getBannerID());
    }

    @Test
    public void constructor(){
        Question question = questionMock();
        assertTrue(question.getBannerID().equals("12"));
    }

    @Test
    public void getBannerIDTest(){
        Question question = questionMock();
        assertTrue(question.getBannerID().equals("12"));
    }

    @Test
    public void setBannerIDTest(){
        Question question = questionMock();
        question.setBannerID("123");
        assertTrue(question.getBannerID().equals("123"));
    }

    @Test
    public void getQuestionID(){
        Question question = questionMock();
        int value = 1;
        assertTrue(question.getQuestionID()==value);
    }

    @Test
    public void setQuestionID(){
        Question question = questionMock();
        question.setQuestionID(2);
        assertTrue(question.getQuestionID()==2);
    }

    @Test
    public void getQuestionTitle(){
        Question question = questionMock();
        assertTrue(question.getQuestionTitle().equals("Do you like Java?"));
    }

    @Test
    public void setQuestionTile(){
        Question question = questionMock();
        question.setQuestionTitle("What is java?");
        assertTrue(question.getQuestionTitle().equals("What is java?"));
    }

    @Test
    public void getQuestionText(){
        Question question = questionMock();
        assertTrue(question.getQuestionText().equals("Java"));
    }

    @Test
    public void setQuestionText(){
        Question question = questionMock();
        question.setQuestionText("C++");
        assertTrue(question.getQuestionText().equals("C++"));
    }
}