package org.example.spring01.service.impl;

import org.example.spring01.service.CsvService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class CsvServiceImpl implements CsvService {
    private static final String COMMA_DELIMITER = ",";
    private final File file;

    public CsvServiceImpl(String path) {
        file = new File(path);
    }

    @Override
    public Map<String, Set<String>> parseCsvFile() {
        List<List<String>> records = readCsv();
        return splitQuestionsAndAnswers(records);
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
