package org.example.spring01.service;

import lombok.RequiredArgsConstructor;
import org.example.spring01.dao.PersonDao;
import org.example.spring01.domain.Person;

@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonDao dao;

    @Override
    public Person getByName(String name) {
        return dao.findByName(name);
    }
}
