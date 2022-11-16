package com.example.jpaexercise.service.professor;

import com.example.jpaexercise.model.Professor;

import java.util.List;

public interface ProfessorService {
    void insertProfessor(String name, String surname, int age, String subject, int assumption_year);
    void deleteProfessorBy(int id);
    void updateProfessorTaughtSubject(int id, String newSubjectName);
    List<Professor> retrieveWorkingProfessors();
    List<Professor> retrieveFreeProfessors();
    List<Professor> retrieveAll();
}
