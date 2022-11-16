package com.example.jpaexercise.dao.person;

import com.example.jpaexercise.connection.ConnectionHandler;
import com.example.jpaexercise.connection.ConnectionHandlerImpl;
import com.example.jpaexercise.model.Person;
import com.example.jpaexercise.utils.ResultSetUtility;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    private ConnectionHandler connectionHandler = ConnectionHandlerImpl.getInstance();

    private static PersonDAO INSTANCE = new PersonDAOImpl();

    private PersonDAOImpl() {
    }

    public static PersonDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Person retrievePersonById(int id) {
        return connectionHandler.getConnection().find(Person.class, id);
    }

    @Override
    public Person insertPerson(String name, String surname, int age) {
        connectionHandler.getConnection().getTransaction().begin();

        Person person = new Person(name, surname, age);
        connectionHandler.getConnection().persist(person);

        connectionHandler.getConnection().getTransaction().commit();
        return person;
    }

    @Override
    public void deletePersonById(int id) {
        EntityManager entityManager = connectionHandler.getConnection();
        entityManager.getTransaction().begin();
        Person personToDelete = entityManager.find(Person.class, id);

        entityManager.remove(personToDelete);

        entityManager.getTransaction().commit();
    }

    @Override
    public void updatePersonName(int id, String name) {
        connectionHandler.getConnection().getTransaction().begin();

        Person personToUpdate = connectionHandler.getConnection().find(Person.class, id);
        personToUpdate.setName(name);

        connectionHandler.getConnection().getTransaction().commit();
    }

    @Override
    public List<Person> retrieveAll() {
        List<Person> result = new ArrayList<>();

        Query query = connectionHandler.getConnection().createQuery("SELECT p FROM Person p");
        result = query.getResultList();

        return result;
    }
}
