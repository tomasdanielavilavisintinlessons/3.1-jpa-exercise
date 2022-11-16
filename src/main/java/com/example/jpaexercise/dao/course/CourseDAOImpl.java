package com.example.jpaexercise.dao.course;

import com.example.jpaexercise.connection.ConnectionHandler;
import com.example.jpaexercise.connection.ConnectionHandlerImpl;
import com.example.jpaexercise.model.Course;
import com.example.jpaexercise.model.Person;
import com.example.jpaexercise.model.Professor;
import com.example.jpaexercise.utils.ResultSetUtility;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    private ConnectionHandler connectionHandler;

    private static CourseDAO INSTANCE = new CourseDAOImpl();

    private CourseDAOImpl() {
        this.connectionHandler = ConnectionHandlerImpl.getInstance();
    }

    public static CourseDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public void insertCourse(String courseName, int professorId) {
        connectionHandler.getConnection().getTransaction().begin();

        Professor professor = connectionHandler.getConnection().find(Professor.class, professorId);
        Course course = new Course(courseName, professor);
        connectionHandler.getConnection().persist(course);

        connectionHandler.getConnection().getTransaction().commit();
    }

    @Override
    public void deleteCourseBy(int id) {
        connectionHandler.getConnection().getTransaction().begin();

        Person courseToDelete = connectionHandler.getConnection().find(Person.class, id);
        connectionHandler.getConnection().remove(courseToDelete);

        connectionHandler.getConnection().getTransaction().commit();
    }

    @Override
    public void updateCourseName(int id, String newCourseName) {
        connectionHandler.getConnection().getTransaction().begin();

        Course courseToUpdate = connectionHandler.getConnection().find(Course.class, id);
        courseToUpdate.setName(newCourseName);

        connectionHandler.getConnection().getTransaction().commit();
    }

    @Override
    public List<Course> retrieveAll() {
        List<Course> result = new ArrayList<>();

        Query query = connectionHandler.getConnection().createQuery("SELECT c FROM Course c");
        result = query.getResultList();

        return result;
    }
}
