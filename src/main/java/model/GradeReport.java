package model;

import java.util.ArrayList;

public class GradeReport {
    private static ArrayList<GradeReport> grades = new ArrayList<>();
    private Student student;
    private Course course;
    private String grade;
    public GradeReport(Course course, Student student, String grade) {
        this.course = course;
        this.student = student;
        this.grade = grade;
        grades.add(this);
    }

    public static GradeReport createNewGrade(Student student, Course course, String grade) { return new GradeReport(course, student, grade); }

    public static ArrayList<GradeReport> getGrades() { return grades; }
    public Course getCourse() { return this.course; }
    public Student getStudent() { return this.student; }
    public String getGrade() { return this.grade; }
    @Override
    public String toString() {
        return student.getId() + " : " + course.getName() + " - ";
    }
    public static GradeReport getLastGrade() { return grades.get(grades.size() - 1); }
}
