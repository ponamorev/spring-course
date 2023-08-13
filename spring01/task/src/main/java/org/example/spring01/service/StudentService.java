package org.example.spring01.service;

import org.example.spring01.domain.Student;

import java.util.Map;

public interface StudentService {
    Student find(String firstName, String lastName);

    void save(Student student);
}
