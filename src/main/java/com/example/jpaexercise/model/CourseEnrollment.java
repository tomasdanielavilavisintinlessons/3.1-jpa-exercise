package com.example.jpaexercise.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "course_enrollments")
public class CourseEnrollment implements Serializable {
    @EmbeddedId
    private CourseEnrollmentId composedKey;

    public CourseEnrollment(){}

    public CourseEnrollment(Course course, Student student) {
        this.composedKey = new CourseEnrollmentId(course, student);
    }

    private Course getCourse() {
        return composedKey.getCourse();
    }

    private Student getStudent() {
        return composedKey.getStudent();
    }

    @Override
    public String toString() {
        return "Course name: " + getCourse().getName() + ", student id: "+ getStudent().getStudentId();
    }
}
