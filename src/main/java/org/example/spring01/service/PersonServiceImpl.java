package org.example.spring01.service;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.spring01.dao.PersonDao;
import org.example.spring01.domain.Person;

//@AllArgsConstructor
@NoArgsConstructor
@Setter
public class PersonServiceImpl implements PersonService {
    private PersonDao dao;

    @Override
    public Person getByName(String name) {
        return dao.findByName(name);
    }
}
