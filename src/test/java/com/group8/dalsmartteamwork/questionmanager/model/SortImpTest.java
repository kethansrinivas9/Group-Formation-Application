package com.group8.dalsmartteamwork.questionmanager.model;

import com.group8.dalsmartteamwork.questionmanager.dao.SortDao;
import com.group8.dalsmartteamwork.questionmanager.dao.SortDaoImp;
import com.group8.dalsmartteamwork.questions.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

public class SortImpTest {
    private Sort sort = null;
    private final SortDao sortDao = mock(SortDaoImp.class);
    private final List<Question> sortedList = Arrays.asList(new Question("java"), new Question("C++"));
    private final String BannerID = "B00123456";

    @BeforeEach
    public void setup() {
        sort = new SortImp(sortDao);
    }

    @Test
    public void getAllQuestionTest() {
        when(sortDao.getAllQuestion(BannerID)).thenReturn(sortedList);
        assertEquals(sort.getAllQuestion(BannerID), sortedList);
        verify(sortDao).getAllQuestion(BannerID);
    }

    @Test
    public void sortQuestionsByTitleTest() {
        when(sortDao.sortQuestionsByTitle(BannerID)).thenReturn(sortedList);
        assertEquals(sort.sortQuestionsByTitle(BannerID), sortedList);
        verify(sortDao).sortQuestionsByTitle(BannerID);
    }

    @Test
    public void sortQuestionsByDateTest() {
        when(sortDao.sortAllQuestionByDate(BannerID)).thenReturn(sortedList);
        assertEquals(sort.sortAllQuestionByDate(BannerID), sortedList);
        verify(sortDao).sortAllQuestionByDate(BannerID);
    }
}