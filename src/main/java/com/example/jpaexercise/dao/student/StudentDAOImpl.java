package com.example.jpaexercise.dao.student;

import com.example.jpaexercise.connection.ConnectionHandler;
import com.example.jpaexercise.connection.ConnectionHandlerImpl;
import com.example.jpaexercise.model.Person;
import com.example.jpaexercise.model.Professor;
import com.example.jpaexercise.model.Student;
import com.example.jpaexercise.utils.ResultSetUtility;
import jakarta.persistence.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private ConnectionHandler connectionHandler;

    private static StudentDAO INSTANCE = new StudentDAOImpl();

    private StudentDAOImpl() {
        this.connectionHandler = ConnectionHandlerImpl.getInstance();
    }

    public static StudentDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public void insertStudent(Person person, int yearOfStudy, int enrollmentYear) {
        connectionHandler.getConnection().getTransaction().begin();

        Student student = new Student(person, yearOfStudy, enrollmentYear);
        connectionHandler.getConnection().persist(student);

        connectionHandler.getConnection().getTransaction().commit();
    }

    @Override
    public void deleteStudentBy(int id) {
        connectionHandler.getConnection().getTransaction().begin();

        Student studentToDelete = connectionHandler.getConnection()
                .find(Student.class, id);
        connectionHandler.getConnection().remove(studentToDelete);

        connectionHandler.getConnection().getTransaction().commit();
    }

    @Override
    public List<Student> retrieveFreeStudents() {
        List<Student> result = new ArrayList<>();

        Query query = connectionHandler.getConnection().createQuery(
                """
                    SELECT s
                    FROM Student s
                    WHERE s NOT IN(
                        SELECT ce.id.student
                        FROM CourseEnrollment ce 
                        WHERE s = ce.id.student
                    )
                  """);
        result = query.getResultList();

        return result;
    }

    @Override
    public List<Student> retrieveAll() {
        List<Student> result = new ArrayList<>();

        Query query = connectionHandler.getConnection().createQuery("SELECT s FROM Student s");
        result = query.getResultList();

        return result;
    }
}
