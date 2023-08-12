package org.example.spring01;

import org.example.spring01.domain.Person;
import org.example.spring01.service.PersonService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        PersonService service = context.getBean(PersonService.class);
        Person ivan = service.getByName("ivan");
        System.out.println("Person: name = " + ivan.getName() + "; age = " + ivan.getAge());
    }
}
