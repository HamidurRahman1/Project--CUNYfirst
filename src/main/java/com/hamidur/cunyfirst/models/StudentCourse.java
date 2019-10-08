package com.hamidur.cunyfirst.models;

import com.hamidur.cunyfirst.models.modelProps.CourseStatus;
import com.hamidur.cunyfirst.models.modelProps.Grade;

import java.util.Objects;

public class StudentCourse
{
    private Student student;
    private Course course;
    private Term term;
    private CourseStatus courseStatus;
    private Grade grade;

    public StudentCourse() {}

    public StudentCourse(Student student, Course course, Term term, CourseStatus courseStatus, Grade grade) {
        this.student = student;
        this.course = course;
        this.term = term;
        this.courseStatus = courseStatus;
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public CourseStatus getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(CourseStatus courseStatus) {
        this.courseStatus = courseStatus;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentCourse)) return false;
        StudentCourse that = (StudentCourse) o;
        return Objects.equals(getStudent(), that.getStudent()) &&
                Objects.equals(getCourse(), that.getCourse()) &&
                Objects.equals(getTerm(), that.getTerm()) &&
                getCourseStatus() == that.getCourseStatus() &&
                getGrade() == that.getGrade();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudent(), getCourse(), getTerm(), getCourseStatus(), getGrade());
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "student=" + student.getStudentId() +
                ", course=" + course.getCourseName().getValue() + " " + course.getCourseLevel().getValue() +
                ", term=" + term +
                ", courseStatus=" + courseStatus.getValue() +
                ", grade=" + grade.getValue() +
                '}';
    }
}
