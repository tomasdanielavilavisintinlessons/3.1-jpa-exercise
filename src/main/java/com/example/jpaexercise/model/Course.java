package com.example.jpaexercise.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "courses")
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "course_name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professorId", referencedColumnName = "id")
    private Professor professor;

    public Course() {}

    public Course(String name, Professor professor) {
        this.name = name;
        this.professor = professor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Professor getProfessor() {
        return professor;
    }

    @Override
    public String toString() {
        return " id: " + id + ", name: " + name + ", professor: " + professor.getPerson().getSurname();
    }
}
