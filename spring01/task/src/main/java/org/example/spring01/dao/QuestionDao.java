package org.example.spring01.dao;

import org.example.spring01.domain.Question;

import java.util.Set;

public interface QuestionDao {
    Set<Question> getQuestions();

    void setQuestion(Question question);
}
