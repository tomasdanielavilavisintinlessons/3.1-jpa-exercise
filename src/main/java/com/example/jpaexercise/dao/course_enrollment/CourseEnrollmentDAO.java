package com.example.jpaexercise.dao.course_enrollment;

import com.example.jpaexercise.model.Course;
import com.example.jpaexercise.model.CourseEnrollment;
import com.example.jpaexercise.model.Student;

import java.util.List;

public interface CourseEnrollmentDAO {
    void insertEnrollment(int studentId, int courseId);
    void deleteEnrollmentBy(int studentId, int courseId);
    List<Student> retrieveStudentsEnrolledToACourseTaughtBy(int professorId);
    List<Student> retrieveEnrollmentCountByStudent(int numberOfCourses);
    List<CourseEnrollment> retrieveAll();
}
