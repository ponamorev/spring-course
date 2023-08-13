package org.example.spring01.service.impl;

import lombok.AllArgsConstructor;
import org.example.spring01.dao.StudentDao;
import org.example.spring01.domain.Student;
import org.example.spring01.service.StudentService;

@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentDao dao;

    @Override
    public Student find(String firstName, String lastName) {
        return dao.findByName(firstName, lastName);
    }

    @Override
    public void save(Student student) {
        dao.save(student);
    }
}
