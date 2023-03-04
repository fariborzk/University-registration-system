package model;

import java.util.ArrayList;

public class Course {
    private static ArrayList<Course> courses = new ArrayList<>();
    private String name;
    private String credits;
    private Department department;
    private Professor professor;
    private ArrayList<Student> students;
    public Course(String name, String credits, String departmentId, String professorName) {
        this.name = name;
        this.credits = credits;
        this.department = Department.getDepartmentWithId(departmentId);
        this.professor = Professor.getProfessor(professorName);
        if (department != null)
            department.setNewCourse(this);
        if (professor != null)
            this.professor.setNewCourse(this);
        this.students = new ArrayList<>();
        courses.add(this);
    }
    public ArrayList<Student> getStudents() { return this.students; }
    public static Course getLastCourse() { return courses.get(courses.size() - 1); }
    public static ArrayList<Course> getCourses() { return courses; }

    public static Course getCourse(String courseName) {
        for (Course course : courses) {
            if (course.getName().equals(courseName))
                return course;
        }
        return null;
    }
    public String getName() { return this.name; }
    public String getCredits() { return this.credits; }
    public Department getDepartment() { return this.department; }
    public Professor getProfessor() { return this.professor; }
    public void setDepartment(Department department) { this.department = department; }
    public void setProfessor(Professor professor) { this.professor = professor; }
    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Course)
            return this.professor.equals(((Course) obj).professor) && this.name.equals(((Course) obj).name) &&
                    this.credits == ((Course) obj).credits && this.department.equals(((Course) obj).department);
        return false;
    }
    public static boolean doesCourseExist(String courseName, String crsDepartmentId, String credits, String crsProfessorName) {
        for (Course course : courses) {
            if (course.name.equals(courseName) && course.department.getId().equals(crsDepartmentId) && course.credits.equals(credits)
            && course.professor.getName().equals(crsProfessorName))
                return true;
        }
        return false;
    }
    public static void createNewCourse(String courseName, String crsDepartmentId, String credits, String crsProfessorName) {
        new Course(courseName, credits, crsDepartmentId, crsProfessorName);
    }
}
