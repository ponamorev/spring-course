package org.example.spring01.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.spring01.service.HelloService;

import java.util.Scanner;

@RequiredArgsConstructor
public class HelloServiceImpl implements HelloService {
    private final Scanner scanner;

    @Override
    public void hello() {
        System.out.println("Hello! We're glad to see you here in our quiz. Introduce yourself");
    }

    @Override
    public String askFirstName() {
        return ask("Please enter your first name and press Enter:");
    }

    @Override
    public String askLastName() {
        return ask("Please enter your last name and press Enter:");
    }

    @Override
    public void confirmSurveyStart() {
        ask("Press Enter to start survey...");
    }

    @Override
    public String askToContinueOrExit() {
        String q = """
                Do you want to pass quiz again or exit?
                For continue - press and symbol and then press Enter
                For exit - enter 'exit' and press Enter""";
        return ask(q);
    }

    private String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
