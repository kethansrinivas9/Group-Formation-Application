package com.group8.dalsmartteamwork.questionmanager;

import com.group8.dalsmartteamwork.questionmanager.dao.DeleteDao;
import com.group8.dalsmartteamwork.questionmanager.dao.DeleteDaoImpl;
import com.group8.dalsmartteamwork.questionmanager.model.Delete;
import com.group8.dalsmartteamwork.questionmanager.model.DeleteImpl;
import com.group8.dalsmartteamwork.questions.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class DeleteImplTest {

    private final DeleteDao deleteDao = mock(DeleteDaoImpl.class);
    private final List<Question> sortedList = Arrays.asList(new Question("java"), new Question("C++"));
    private final String BannerID = "B00123456";
    private final int QuestionID = 12;
    private Delete delete = null;

    @BeforeEach
    public void setup() {
        delete = new DeleteImpl(deleteDao);
    }

    @Test
    public void displayListOfQuestionsTest() {
        when(deleteDao.displayListOfQuestions(BannerID)).thenReturn(sortedList);
        assertEquals(delete.displayListOfQuestions(BannerID), sortedList);
        verify(deleteDao).displayListOfQuestions(BannerID);
    }

    @Test
    public void deleteQuestionTest() {
        when(deleteDao.deleteQuestion(QuestionID)).thenReturn(true);
        assertTrue(delete.deleteQuestion(QuestionID));
        verify(deleteDao).deleteQuestion(QuestionID);
    }
}