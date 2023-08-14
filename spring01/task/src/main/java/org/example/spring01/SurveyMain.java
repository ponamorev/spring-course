package org.example.spring01;

import org.example.spring01.domain.Student;
import org.example.spring01.service.CsvService;
import org.example.spring01.service.HelloService;
import org.example.spring01.service.StudentService;
import org.example.spring01.service.SurveyService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SurveyMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        StudentService studentService = context.getBean(StudentService.class);
        HelloService helloService = context.getBean(HelloService.class);
        CsvService csvService = context.getBean(CsvService.class);
        SurveyService surveyService = context.getBean(SurveyService.class);

        csvService.parseCsvFile();
        helloService.hello();
        do {
            String firstName = helloService.askFirstName();
            String lastName = helloService.askLastName();
            Student student = studentService.find(firstName, lastName);

            helloService.confirmSurveyStart();
            surveyService.quiz(student);

            System.out.println("\n\n========================\n\n");
            surveyService.verify(student);
        } while (!helloService.askToContinueOrExit().equals("exit"));
    }
}
