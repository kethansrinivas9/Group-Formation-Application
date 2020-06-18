package com.group8.dalsmartteamwork.student.model;

import java.util.ArrayList;
import com.group8.dalsmartteamwork.student.dao.StudentDao;

public class StudentImp implements IStudent {
    private StudentDao studentDao;

    public StudentImp(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public ArrayList<Student> displayCourses() {
        return studentDao.displayCourses();
    }
}