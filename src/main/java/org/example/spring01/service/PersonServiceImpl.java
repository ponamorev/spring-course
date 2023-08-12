package org.example.spring01.service;

import org.example.spring01.dao.PersonDao;
import org.example.spring01.domain.Person;

public class PersonServiceImpl implements PersonService {
    private PersonDao dao;

    public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }

    @Override
    public Person getByName(String name) {
        return dao.findByName(name);
    }
}
