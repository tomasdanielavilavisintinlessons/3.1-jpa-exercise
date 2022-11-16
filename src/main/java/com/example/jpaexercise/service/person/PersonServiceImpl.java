package com.example.jpaexercise.service.person;

import com.example.jpaexercise.dao.person.PersonDAO;
import com.example.jpaexercise.dao.person.PersonDAOImpl;
import com.example.jpaexercise.model.Person;

import java.util.List;

public class PersonServiceImpl implements PersonService {
    private PersonDAO personDAO = PersonDAOImpl.getInstance();

    private static PersonService INSTANCE = new PersonServiceImpl();

    private PersonServiceImpl() {
    }

    public static PersonService getInstance() {
        return INSTANCE;
    }

    @Override
    public Person retrievePersonById(int id) {
        return personDAO.retrievePersonById(id);
    }

    @Override
    public Person insertPerson(String name, String surname, int age) {
        return personDAO.insertPerson(name, surname, age);
    }

    @Override
    public void deletePersonById(int id) {
        personDAO.deletePersonById(id);
    }

    @Override
    public void updatePersonName(int id, String name) {
        personDAO.updatePersonName(id, name);
    }

    @Override
    public List<Person> retrieveAll() {
        return personDAO.retrieveAll();
    }
}
