package org.example.spring01.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class Question {
    private String question;
    private Set<String> answers;
}
