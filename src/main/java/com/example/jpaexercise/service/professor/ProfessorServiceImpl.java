package com.example.jpaexercise.service.professor;

import com.example.jpaexercise.dao.person.PersonDAO;
import com.example.jpaexercise.dao.person.PersonDAOImpl;
import com.example.jpaexercise.dao.professor.ProfessorDAO;
import com.example.jpaexercise.dao.professor.ProfessorDAOImpl;
import com.example.jpaexercise.model.Person;
import com.example.jpaexercise.model.Professor;

import java.util.List;

public class ProfessorServiceImpl implements ProfessorService {
    private PersonDAO personDAO;
    private ProfessorDAO professorDAO;
    
    private static ProfessorService INSTANCE = new ProfessorServiceImpl();

    private ProfessorServiceImpl() {
        personDAO = PersonDAOImpl.getInstance();
        professorDAO = ProfessorDAOImpl.getInstance();
    }

    public static ProfessorService getInstance() {
        return INSTANCE;
    }

    @Override
    public void insertProfessor(
            String name, String surname, int age,
            String subject, int assumption_year) {
        Person person = new Person(name, surname, age);
        professorDAO.insertProfessor(person, subject, assumption_year);
    }

    @Override
    public void deleteProfessorBy(int id) {
       professorDAO.deleteProfessorBy(id);
    }

    @Override
    public void updateProfessorTaughtSubject(int id, String newSubjectName) {
        professorDAO.updateProfessorTaughtSubject(id, newSubjectName);
    }

    @Override
    public List<Professor> retrieveWorkingProfessors() {
        return professorDAO.retrieveWorkingProfessors();
    }

    @Override
    public List<Professor> retrieveFreeProfessors() {
        return professorDAO.retrieveFreeProfessors();
    }

    @Override
    public List<Professor> retrieveAll() {
        return professorDAO.retrieveAll();
    }
}
