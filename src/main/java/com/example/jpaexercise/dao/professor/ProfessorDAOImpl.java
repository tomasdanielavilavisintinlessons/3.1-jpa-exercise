package com.example.jpaexercise.dao.professor;

import com.example.jpaexercise.connection.ConnectionHandler;
import com.example.jpaexercise.connection.ConnectionHandlerImpl;
import com.example.jpaexercise.model.Person;
import com.example.jpaexercise.model.Professor;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class ProfessorDAOImpl implements ProfessorDAO {
    private ConnectionHandler connectionHandler;

    private static ProfessorDAO INSTANCE = new ProfessorDAOImpl();

    private ProfessorDAOImpl() {
        this.connectionHandler = ConnectionHandlerImpl.getInstance();
    }

    public static ProfessorDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public void insertProfessor(Person person, String subject, int assumption_year) {
        connectionHandler.getConnection().getTransaction().begin();

        Professor professor = new Professor(person, subject, assumption_year);
        connectionHandler.getConnection().persist(professor);

        connectionHandler.getConnection().getTransaction().commit();
    }

    @Override
    public void deleteProfessorBy(int id) {
        connectionHandler.getConnection().getTransaction().begin();

        Professor professorToDelete = connectionHandler.getConnection()
                .find(Professor.class, id);
        connectionHandler.getConnection().remove(professorToDelete);

        connectionHandler.getConnection().getTransaction().commit();
    }

    @Override
    public void updateProfessorTaughtSubject(int id, String newSubjectName) {
        connectionHandler.getConnection().getTransaction().begin();

        Professor professorToUpdate = connectionHandler.getConnection().find(Professor.class, id);
        professorToUpdate.setSubject(newSubjectName);

        connectionHandler.getConnection().getTransaction().commit();
    }

    @Override
    public List<Professor> retrieveWorkingProfessors() {
        List<Professor> result = new ArrayList<>();

        Query query = connectionHandler.getConnection().createQuery(
                """
                    SELECT professor
                    FROM Course
                  """);
        result = query.getResultList();

        return result;
    }

    @Override
    public List<Professor> retrieveFreeProfessors() {
        List<Professor> result = new ArrayList<>();

        Query query = connectionHandler.getConnection().createQuery(
            """
                SELECT p 
                FROM Professor p
                WHERE p NOT IN(
                    SELECT professor
                    FROM Course 
                )
              """);
        result = query.getResultList();

        return result;
    }

    @Override
    public List<Professor> retrieveAll() {
        List<Professor> result = new ArrayList<>();

        Query query = connectionHandler.getConnection().createQuery("SELECT p FROM Professor p");
        result = query.getResultList();

        return result;
    }
}
