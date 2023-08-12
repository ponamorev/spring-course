package org.example.spring01.dao;

import org.example.spring01.domain.Person;

public class PersonDaoSimple implements PersonDao {
    @Override
    public Person findByName(String name) {
        return new Person(name, 18);
    }
}
