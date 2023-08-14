package org.example.spring01.service.impl;

import lombok.AllArgsConstructor;
import org.example.spring01.dao.QuestionDao;
import org.example.spring01.domain.Question;
import org.example.spring01.domain.Student;
import org.example.spring01.service.StudentService;
import org.example.spring01.service.SurveyService;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SurveyServiceImpl implements SurveyService {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    private StudentService studentService;
    private QuestionDao dao;
    private Scanner scanner;

    @Override
    public void quiz(Student student) {
        Set<String> questions = dao.getQuestions().stream().map(Question::getQuestion).collect(Collectors.toSet());
        Map<String, String> answers = askQuestions(questions);
        student.setAnswers(answers);
        studentService.save(student);
    }

    @Override
    public void verify(Student student) {
        Set<Question> source = dao.getQuestions();
        Map<String, String> answers = student.getAnswers();
        if (answers == null) {
            System.out.println("\nStudent '" + student.getFirstName() + " " + student.getLastName() +
                    "' hasn't answered questions yet\n");
            return;
        }
        answers.forEach((k, v) -> verify(source, Map.entry(k, v)));
    }

    private Map<String, String> askQuestions(Set<String> questions) {
        System.out.println("Write down your answers under each question and press Enter..");
        return questions.stream()
                .map(q -> askQuestion(q, scanner))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Map.Entry<String, String> askQuestion(String question, Scanner scanner) {
        System.out.println("\nQuestion:");
        System.out.println(question);
        return Map.entry(question, scanner.nextLine());
    }

    private void verify(Set<Question> source, Map.Entry<String, String> studentAnswer) {
        String question = studentAnswer.getKey();
        Set<String> sourceAnswers = source.stream()
                .filter(q -> q.getQuestion().equals(question))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There is no question '" + question + "'"))
                .getAnswers();
        if (sourceAnswers.contains(studentAnswer.getValue())) {
            System.out.println("Question\n" + question + ANSI_GREEN + "\nAnswer is CORRECT!" + ANSI_RESET);
        } else {
            System.out.println("Question\n" + question + ANSI_RED + "\nAnswer is WRONG!" + ANSI_RESET);
            System.out.println("Possible answers:\n" + sourceAnswers);
        }
        System.out.println("\n\n");
    }
}
