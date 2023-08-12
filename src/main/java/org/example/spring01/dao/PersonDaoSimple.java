package org.example.spring01.dao;

import lombok.Setter;
import org.example.spring01.domain.Person;

public class PersonDaoSimple implements PersonDao {
    @Setter
    private int defaultAge;

    @Override
    public Person findByName(String name) {
        return new Person(name, defaultAge);
    }
}
