package org.example.spring01.service;

import org.example.spring01.domain.Person;

public interface PersonService {
    Person getByName(String name);
}
