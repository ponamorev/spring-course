package org.example.spring01.service.impl;

import org.example.spring01.service.HelloService;

import java.util.Scanner;

public class HelloServiceImpl implements HelloService {
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

    private String ask(String question) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(question);
            return scanner.nextLine();
        }
    }
}
