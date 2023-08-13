package org.example.spring01.dao;

import org.example.spring01.domain.Student;

import java.util.HashSet;
import java.util.Set;

public class StudentDaoSimple implements StudentDao {
    private final Set<Student> students = new HashSet<>();

    @Override
    public Student findByName(String firstName, String lastName) {
        Student blankStudent = new Student(firstName, lastName);
        return students.stream()
                .filter(student -> student.equals(blankStudent))
                .findFirst()
                .orElse(blankStudent);
    }

    @Override
    public void save(Student student) {
        students.add(student);
    }
}
