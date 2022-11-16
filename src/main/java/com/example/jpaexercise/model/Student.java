package com.example.jpaexercise.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "students")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "year_of_study")
    private int yearOfStudy;
    @Column(name = "enrollment_year")
    private int enrollmentYear;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personId", referencedColumnName = "id")
    private Person person;

    public Student() {}

    public Student(Person person, int yearOfStudy, int enrollmentYear) {
        this.person = person;
        this.yearOfStudy = yearOfStudy;
        this.enrollmentYear = enrollmentYear;
    }

    public int getStudentId() {
        return id;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "id: " + id + ", " + person.getName() + ", " + person.getSurname()
                + ", ey:" + enrollmentYear + ", ys:" + yearOfStudy;
    }
}
