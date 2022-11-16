package com.example.jpaexercise.service.student;

import com.example.jpaexercise.model.Student;

import java.util.List;

public interface StudentService {
    void insertStudent(String name, String surname, int age,
                       int yearOfStudy, int enrollmentYear);
    void deleteStudentBy(int id);
    List<Student> retrieveFreeStudents();
    List<Student> retrieveAll();
}
