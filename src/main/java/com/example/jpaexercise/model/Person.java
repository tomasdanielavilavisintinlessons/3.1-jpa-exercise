package com.example.jpaexercise.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "people")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int age;

    public Person() {}

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
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

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "id: " + id + ", " + name + ", " + surname + ", " + age;
    }
}
