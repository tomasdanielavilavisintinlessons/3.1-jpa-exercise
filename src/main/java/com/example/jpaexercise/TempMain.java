package com.example.jpaexercise;

import com.example.jpaexercise.connection.ConnectionHandler;
import com.example.jpaexercise.connection.ConnectionHandlerImpl;
import com.example.jpaexercise.model.*;
import jakarta.persistence.EntityManager;

public class TempMain {
    public static void main(String[] args) {
        ConnectionHandler connectionHandler = ConnectionHandlerImpl.getInstance();
        EntityManager entityManager = connectionHandler.getConnection();

        entityManager.getTransaction().begin();
        Person person = new Person("ciao", "prova", 200);
        Professor professor = new Professor(person, "cioa", 2022);
        Student student = new Student(person, 3, 2020);
        Course course = new Course("name", professor);
        entityManager.persist(student);
        entityManager.persist(course);

        CourseEnrollment courseEnrollment = new CourseEnrollment(course, student);

        entityManager.persist(courseEnrollment);

        entityManager.getTransaction().commit();
    }
}
