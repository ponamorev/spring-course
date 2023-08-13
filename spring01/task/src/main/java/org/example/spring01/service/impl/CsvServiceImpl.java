package org.example.spring01.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.spring01.dao.QuestionDao;
import org.example.spring01.domain.Question;
import org.example.spring01.service.CsvService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CsvServiceImpl implements CsvService {
    private static final String COMMA_DELIMITER = ",";
    private final String path;
    private final QuestionDao dao;

    @Override
    public void parseCsvFile() {
        List<List<String>> records = readCsv();
        Map<String, Set<String>> map = splitQuestionsAndAnswers(records);
        map.forEach((k, v) -> dao.setQuestion(new Question(k, v)));
    }

    private Map<String, Set<String>> splitQuestionsAndAnswers(List<List<String>> records) {
        return records.stream()
                .map(rec -> {
                    String key = rec.get(0);
                    Set<String> values = rec.stream()
                            .filter(v -> !v.equals(key))
                            .collect(Collectors.toSet());
                    return Map.entry(key, values);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private List<List<String>> readCsv() {
        File file = new File(path);
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (IOException e) {
            System.err.println("Can't read file with path " + file.getAbsolutePath());
            System.err.println("Caught exception: " + e);
        }
        return records;
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}
