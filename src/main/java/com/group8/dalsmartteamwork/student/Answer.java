package com.group8.dalsmartteamwork.student;


import com.group8.dalsmartteamwork.questions.IOption;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Answer {
    private static Answer answer;
    private int courseId;
    private Map<IQuestionDetails, List<IOption>> questions = new HashMap<>();
    private Map<Integer, List<String>> answers = new HashMap<>();

    private Answer() {
    }

    public static Answer getInstance() {
        if (answer == null) {
            answer = new Answer();
        }
        return answer;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Map<Integer, List<String>> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Integer, List<String>> answers) {
        this.answers = answers;
    }

    public Map<IQuestionDetails, List<IOption>> getQuestions() {
        return questions;
    }

    public void setQuestions(Map<IQuestionDetails, List<IOption>> questions) {
        this.questions = questions;
    }

    public void addAnswer(int questionId, String answer) {
        if (answers.containsKey(questionId)) {
            answers.get(questionId).add(answer);
        } else {
            List<String> results = new ArrayList<>();
            results.add(answer);
            answers.put(questionId, results);
        }
    }

    public void destroy() {
        answer = null;
    }

}
