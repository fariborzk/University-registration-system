package model;
import enums.AcademicRank;


import java.time.LocalDate;
import java.util.*;
public class Professor {
    private static ArrayList<Professor> professors = new ArrayList<>();
    private String name;
    private LocalDate birthday;
    private Department department;
    private AcademicRank rank;
    private ArrayList<Course> courses;
    public Professor(String name, String departmentId, String birthday, AcademicRank rank) {
        this.name = name;
        this.department = Department.getDepartment(departmentId);
        if (department != null)
            this.department.setNewProfessor(this);
        System.out.println(birthday);
        this.birthday = LocalDate.of(Integer.parseInt(birthday.substring(0, 4)), Integer.parseInt(birthday.substring(5, 7)),
                Integer.parseInt(birthday.substring(8, 10)));
        this.rank = rank;
        this.courses = new ArrayList<>();
        professors.add(this);
    }

    public static Professor getLastProfessor() { return professors.get(professors.size() - 1); }

    public static void createNewProfessor(String professorName, String departmentId, String birthday, AcademicRank rank) {
        new Professor(professorName, departmentId, birthday, rank);
    }
    public static Professor getProfessor (String name, String departmentName) {
        for (Professor professor : professors) {
            if (professor.getName().equals(name) && professor.getDepartment().getName().equals(departmentName))
                return professor;
        }
        return null;
    }
    public static Professor getProfessor(String name) {
        for (Professor professor : professors) {
             if (professor.getName().equals(name))
                 return professor;
        }
        return null;
    }
    public static ArrayList<Professor> getProfessors() { return professors; }
    public String getName() { return this.name; }
    public LocalDate getBirthday() { return this.birthday; }
    public Department getDepartment() { return this.department; }
    public AcademicRank getRank() { return this.rank; }
    public ArrayList<Course> getCourses() { return this.courses; }
    public void setNewCourse(Course course) { this.courses.add(course); }
    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Professor)
            return this.birthday.equals(((Professor) obj).birthday) && this.name.equals(((Professor) obj).name) &&
                    this.department.equals(((Professor) obj).department) && this.rank.equals(((Professor) obj).rank);
        return false;
    }
    public static boolean DoesProExist(String name, String birthDay, String departmentId, AcademicRank rank) {
        LocalDate birthDay1 = LocalDate.of(Integer.parseInt(birthDay.substring(0, 4)), Integer.parseInt(birthDay.substring(5, 7)),
                Integer.parseInt(birthDay.substring(8, 10)));
        for (Professor professor : professors) {
            if (professor.department.getId().equals(departmentId) && professor.name.equals(name) && rank == professor.rank
            && birthDay1 == professor.getBirthday())
                return true;
        }
        return false;
    }
}
