package com.example.jpaexercise.dao.course;

import com.example.jpaexercise.model.Course;

import java.util.List;

public interface CourseDAO {
    void insertCourse(String courseName, int professorId);
    void deleteCourseBy(int id);
    void updateCourseName(int id, String courseNewName);
    List<Course> retrieveAll();
}