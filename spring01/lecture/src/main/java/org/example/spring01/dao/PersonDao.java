package org.example.spring01.dao;

import org.example.spring01.domain.Person;

public interface PersonDao {
    Person findByName(String name);
}
