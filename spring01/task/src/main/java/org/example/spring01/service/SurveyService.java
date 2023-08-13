package org.example.spring01.service;

import org.example.spring01.domain.Student;

import java.util.Map;
import java.util.Set;

public interface SurveyService {
    Map<String, String> quiz();

    void verify(Student student);
}
