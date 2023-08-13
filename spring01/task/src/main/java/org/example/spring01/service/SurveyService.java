package org.example.spring01.service;

import org.example.spring01.domain.Student;

public interface SurveyService {
    void quiz(Student student);

    void verify(Student student);
}
