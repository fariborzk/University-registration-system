package model;

import java.util.ArrayList;

public class Department {
    private static ArrayList<Department> departments = new ArrayList<>();
    private String name;
    private String id;
    private ArrayList<Student> students;
    private ArrayList<Professor> professors;
    private ArrayList<Course> courses;
    public Department(String name, String id) {
        this.name = name;
        this.id = id;
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
        departments.add(this);
    }

    public static Department getDepartmentWithId(String departmentId) {
        for (Department department : departments) {
            if (department.id.equals(departmentId))
                return department;
        }
        return null;
    }
    public static void createNewDepartment(String departmentName, String departmentId) { new Department(departmentName, departmentId); }
    public static ArrayList<Department> getDepartments() { return departments; }
    public String getName() { return this.name; }
    public String getId() { return this.id; }
    public ArrayList<Course> getCourses() { return this.courses; }
    public ArrayList<Student> getStudents() { return this.students; }
    public ArrayList<Professor> getProfessors() {return this.professors; }
    public void setNewStudent(Student student) { this.students.add(student); }
    public void setNewProfessor(Professor professor) { this.professors.add(professor); }
    public void setNewCourse(Course course) { this.courses.add(course); }
    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Department)
            return this.name.equals(((Department) obj).name) && this.id.equals(((Department) obj).id);
        return false;
    }
    public static Department getDepartment(String departmentId) {
        for (Department department : departments) {
            if (department.id.equals(departmentId))
                return department;
        }
        return null;
    }
    public static Department getDepartmentWithName(String departmentName) {
        for (Department department : departments) {
            if (department.id.equals(departmentName))
                return department;
        }
        return null;
    }
    public static boolean doesDepartmentExist(String name, String id) {
        for (Department department : departments) {
            if (department.id.equals(id) || department.name.equals(name))
                return true;
        }
        return false;
    }
    public static Department getLastDepartment() { return departments.get(departments.size() -1); }
}
