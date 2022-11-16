package com.example.jpaexercise.service.course_enrollment;

import com.example.jpaexercise.model.CourseEnrollment;
import com.example.jpaexercise.model.Student;

import java.util.List;

public interface CourseEnrollmentService {
    void insertEnrollment(int studentId, int courseId);
    void deleteEnrollmentBy(int studentId, int courseId);
    List<Student> retrieveStudentsEnrolledToACourseTaughtBy(int professorId);
    List<Student> retrieveEnrollmentCountByStudent(int numberOfCourses);
    List<CourseEnrollment> retrieveAll();
}
