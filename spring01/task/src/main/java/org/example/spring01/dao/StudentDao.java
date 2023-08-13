package org.example.spring01.dao;

import org.example.spring01.domain.Student;

public interface StudentDao {
    Student findByName(String firstName, String lastName);

    void save(Student student);
}
