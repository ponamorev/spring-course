package org.example.spring01.service;

import java.io.File;
import java.util.Map;
import java.util.Set;

public interface CsvService {
    Map<String, Set<String>> parseCsvFile();
}
