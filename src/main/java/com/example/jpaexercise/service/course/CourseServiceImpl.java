package com.example.jpaexercise.service.course;

import com.example.jpaexercise.dao.course.CourseDAO;
import com.example.jpaexercise.dao.course.CourseDAOImpl;
import com.example.jpaexercise.model.Course;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private CourseDAO courseDAO;
    private static CourseService INSTANCE = new CourseServiceImpl();

    private CourseServiceImpl() {
        this.courseDAO = CourseDAOImpl.getInstance();
    }

    public static CourseService getInstance() {
        return INSTANCE;
    }

    @Override
    public void insertCourse(String courseName, int professorId) {
        this.courseDAO.insertCourse(courseName, professorId);
    }

    @Override
    public void deleteCourseBy(int id) {
        this.courseDAO.deleteCourseBy(id);
    }

    @Override
    public void updateCourseName(int id, String courseNewName) {
        this.courseDAO.updateCourseName(id, courseNewName);
    }

    @Override
    public List<Course> retrieveAll() {
        return this.courseDAO.retrieveAll();
    }
}
