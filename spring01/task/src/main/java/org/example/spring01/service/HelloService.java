package org.example.spring01.service;

public interface HelloService {
    void hello();

    String askFirstName();

    String askLastName();

    void confirmSurveyStart();

    String askToContinueOrExit();
}
