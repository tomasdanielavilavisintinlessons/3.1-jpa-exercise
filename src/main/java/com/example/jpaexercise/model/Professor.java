package com.example.jpaexercise.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "professors")
public class Professor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String subject;
    @Column(name = "assumption_year")
    private int assumptionYear;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personId", referencedColumnName = "id")
    Person person;

    public Professor() {}

    public Professor(Person person, String subject, int assumptionYear) {
        this.subject = subject;
        this.assumptionYear = assumptionYear;
        this.person = person;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getIProfessorId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public int getAssumptionYear() {
        return assumptionYear;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "id: " + id + ", " + person.getName() + ", " + person.getSurname() + ", sj: " + subject + ", ay: " + assumptionYear;
    }
}
