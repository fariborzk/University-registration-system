package controller;
import enums.AcademicRank;
import enums.Edit;
import enums.Message;
import javafx.scene.control.TextField;
import model.*;

import java.util.ArrayList;

public class Controller {
    private static Controller Instance = null;
    public static Controller getController() {
        if (Instance == null)
            Instance = new Controller();
        return Instance;
    }

    public static Student getStudent(String studentId, String studentName) { return Student.getStudent(studentId, studentName); }
    public static Professor getProfessor(String professorName, String departmentName) { return Professor.getProfessor(professorName, departmentName); }
    public static GradeReport getLastGrade() { return GradeReport.getLastGrade(); }
    public static ArrayList<Course> getCourses() { return Course.getCourses(); }
    public static ArrayList<Student> getStudents() { return Student.getStudents(); }
    public static ArrayList<Professor> getProfessors() { return Professor.getProfessors(); }
    public static ArrayList<Professor> getDepartmentProfessors(Department department) { return department.getProfessors(); }
    public static ArrayList<Department> getDepartments() { return Department.getDepartments(); }
    public static ArrayList<GradeReport> getGrades() { return GradeReport.getGrades(); }
    public static Message getEditStudent2Course(String studentId, String courseName, Edit type) {
        Student student;
        Course course;
        if ((student = Student.getStudent(studentId)) == null)
            return Message.STUDENT_NOT_EXIST;
        else if ((course = student.getCourse(courseName)) == null)
            return Message.STUDENT_NOT_HAVE_COURSE;
        if (type == Edit.DELETE)
            deleteStudentFromCourse(student, course);
        else
            addStudent2Course(student, course);
        return Message.STUDENT_EDITED_IN_COURSE;

    }
    public static void addStudent2Course(Student student, Course course) {
        student.getCourses().put(course, null);
        course.getStudents().add(student);
    }
    public static void deleteStudentFromCourse(Student student, Course course) {
        student.getCourses().remove(course);
        course.getStudents().remove(student);
    }

    public static ArrayList<Course> getProfessorCourses(Professor loggedInProfessor) { return loggedInProfessor.getCourses(); }

    public static ArrayList<Student> getCourseStudents(Course presentCourse) { return presentCourse.getStudents(); }

    public static Course getCourse(String courseName) { return Course.getCourse(courseName); }

    public static boolean doesProHasCourse(Professor professor, String courseName) {
        for (Course course : professor.getCourses())
            if (course.getName().equals(courseName))
                return true;
        return false;
    }

    public static boolean doesStudentHasCourse(String courseName, String studentId) {
        for (Course course : Student.getStudent(studentId).getCourses().keySet()) {
            if (course.getName().equals(courseName))
                return true;
        }
        return false;
    }

    public Message addStudent(String studentName, String studentId, String birthday, String departmentId) {
        if (Student.doseStudentExist(studentId))
            return Message.STUDENT_EXIST;
        Student.createNewStudent(studentId, studentName, birthday, departmentId);
        return Message.STUDENT_ADDED;
    }
    public Message addProfessor(String  professorName, String  departmentId, String birthday, String strRank) {
        AcademicRank rank;
        if (Professor.DoesProExist(professorName, birthday, departmentId, rank = AcademicRank.getEnum(strRank)))
            return Message.PROFESSOR_EXIST;
        Professor.createNewProfessor(professorName, departmentId, birthday, rank);
        return Message.PROFESSOR_ADDED;
    }
    public Message addCourse(String courseName, String crsDepartmentId, String credits, String crsProfessorName) {
        if (Course.doesCourseExist(courseName, crsDepartmentId, credits, crsProfessorName))
            return Message.COURSE_EXIST;
        Course.createNewCourse(courseName, crsDepartmentId, credits, crsProfessorName);
        return Message.COURSE_ADDED;
    }
    public Message addDepartment(String departmentName, String departmentId) {
        if (Department.doesDepartmentExist(departmentName, departmentId))
            return Message.DEPARTMENT_EXIST;
        Department.createNewDepartment(departmentName, departmentId);
        return Message.DEPARTMENT_ADDED;
    }
    public static Student getLastStudent() { return Student.getLastStudent(); }
    public static Course getLastCourse() { return Course.getLastCourse(); }
    public static Professor getLastProfessor() { return Professor.getLastProfessor(); }
    public static Department getLastDepartment() { return Department.getLastDepartment(); }
    public Message addGrade(String studentId, String courseName, String grade) {
        if (!Student.doseStudentExist(studentId))
            return Message.STUDENT_NOT_EXIST;
        return Student.setGrade(studentId, courseName, grade);
    }
    public static Department getDepartment(String name) { return Department.getDepartmentWithName(name); }
}
