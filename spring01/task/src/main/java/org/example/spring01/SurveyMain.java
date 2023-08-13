package org.example.spring01;

import org.example.spring01.service.impl.CsvServiceImpl;

public class SurveyMain {
    public static void main(String[] args) {
        var result = new CsvServiceImpl("spring01/task/src/main/resources/questions.csv").parseCsvFile();
        System.out.println(result);
    }
}
