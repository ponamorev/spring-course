package org.example.spring01.dao;

import org.example.spring01.domain.Question;

import java.util.HashSet;
import java.util.Set;

public class QuestionDaoSimple implements QuestionDao {
    private Set<Question> questions;

    @Override
    public Set<Question> getQuestions() {
        return questions == null
                ? Set.of()
                : questions;
    }

    @Override
    public void setQuestion(Question question) {
        if (questions == null) {
            questions = new HashSet<>();
        }
        questions.add(question);
    }
}
