package com.example.jpaexercise.service.student;

import com.example.jpaexercise.dao.person.PersonDAO;
import com.example.jpaexercise.dao.person.PersonDAOImpl;
import com.example.jpaexercise.dao.student.StudentDAO;
import com.example.jpaexercise.dao.student.StudentDAOImpl;
import com.example.jpaexercise.model.Person;
import com.example.jpaexercise.model.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private PersonDAO personDAO;
    private StudentDAO studentDAO;

    private static StudentService INSTANCE = new StudentServiceImpl();

    private StudentServiceImpl() {
        studentDAO = StudentDAOImpl.getInstance();
        personDAO = PersonDAOImpl.getInstance();
    }

    public static StudentService getInstance() {
        return INSTANCE;
    }

    @Override
    public void insertStudent(String name, String surname, int age, int yearOfStudy, int enrollmentYear) {
        Person person = new Person(name, surname, age);
        studentDAO.insertStudent(person, yearOfStudy, enrollmentYear);
    }

    @Override
    public void deleteStudentBy(int id) {
        studentDAO.deleteStudentBy(id);
    }

    @Override
    public List<Student> retrieveFreeStudents() {
        return studentDAO.retrieveFreeStudents();
    }

    @Override
    public List<Student> retrieveAll() {
        return studentDAO.retrieveAll();
    }
}
