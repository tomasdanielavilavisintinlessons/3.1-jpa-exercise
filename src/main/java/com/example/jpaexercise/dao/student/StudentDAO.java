package com.example.jpaexercise.dao.student;

import com.example.jpaexercise.model.Person;
import com.example.jpaexercise.model.Student;

import java.util.List;

public interface StudentDAO {
    void insertStudent(Person person, int yearOfStudy, int enrollmentYear);
    void deleteStudentBy(int id);
    List<Student> retrieveFreeStudents();
    List<Student> retrieveAll();
}
