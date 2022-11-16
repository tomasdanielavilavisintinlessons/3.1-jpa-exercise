package com.example.jpaexercise.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CourseEnrollmentId implements Serializable {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseId", referencedColumnName = "id")
    private Course course;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId", referencedColumnName = "id")
    private Student student;

    public CourseEnrollmentId() {}

    public CourseEnrollmentId(Course course, Student student) {
        this.course = course;
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseEnrollmentId)) return false;
        CourseEnrollmentId that = (CourseEnrollmentId) o;
        return getCourse().equals(that.getCourse()) && getStudent().equals(that.getStudent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourse(), getStudent());
    }
}
