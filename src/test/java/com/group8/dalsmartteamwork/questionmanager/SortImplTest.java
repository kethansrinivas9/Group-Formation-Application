package com.group8.dalsmartteamwork.questionmanager;

import com.group8.dalsmartteamwork.questionmanager.dao.SortDao;
import com.group8.dalsmartteamwork.questionmanager.dao.SortDaoImpl;
import com.group8.dalsmartteamwork.questionmanager.model.Sort;
import com.group8.dalsmartteamwork.questionmanager.model.SortImpl;
import com.group8.dalsmartteamwork.questions.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SortImplTest {
    private final SortDao sortDao = mock(SortDaoImpl.class);
    private final List<Question> sortedList = Arrays.asList(new Question("java"), new Question("C++"));
    private final String BannerID = "B00123456";
    private Sort sort = null;

    @BeforeEach
    public void setup() {
        sort = new SortImpl(sortDao);
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