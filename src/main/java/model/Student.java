package model;

import enums.Message;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private static ArrayList<Student> students = new ArrayList<>();
    private String id;
    private String name;
    private LocalDate birthday;
    private Department department;
    private String strBirthday;
    private HashMap<Course, GradeReport> courses;
    public Student(String id, String name, String birthday, String department) {
        this.id = id;
        this.strBirthday = birthday;
        this.name = name;
        this.birthday = LocalDate.of(Integer.parseInt(birthday.substring(0, 4)), Integer.parseInt(birthday.substring(5, 7)),
                Integer.parseInt(birthday.substring(8, 10)));
        this.department = Department.getDepartment(department);
        if (this.department != null)
          this.department.setNewStudent(this);
        this.courses = new HashMap<>();
        students.add(this);
    }

    public static Message setGrade(String studentId, String courseName, String grade) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                for (Course course : student.courses.keySet()) {
                    if (course.getName().equals(courseName)) {
                        if (student.courses.get(course) != null)
                            return Message.GRADE_EXIST;
                        student.courses.put(course, GradeReport.createNewGrade(student, course, grade));
                        return Message.GRADE_ADDED;
                    }
                }
            }
        }
        return Message.STUDENT_NOT_HAVE_COURSE;
    }

    public static Student getStudent(String studentId, String studentName) {
        for (Student student : students) {
            if (student.getName().equals(studentName) && student.getId().equals(studentId))
                return student;
        }
        return null;
    }
    public static Student getStudent(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId))
                return student;
        }
        return null;
    }
    public static ArrayList<Student> getStudents() { return students; }
    public String getName() { return this.name; }
    public String getId() { return this.id; }
    public LocalDate getBirthday() { return this.birthday; }
    public String getStringBirthday() { return this.strBirthday;}
    public Department getDepartment() { return this.department; }
    public HashMap<Course, GradeReport> getCourses() { return this.courses; }
    public static boolean doseStudentExist(String studentId) {
        for (Student student : students) {
            if (student.id.equals(studentId))
                return true;
        }
        return false;
    }
    public static void createNewStudent(String id, String name, String birthday, String departmentId) { new Student(id, name, birthday, departmentId); }
    public static Student getLastStudent() { return students.get(students.size() - 1); }

    public Course getCourse(String courseName) {
        for (Course course : courses.keySet()) {
            if (course.getName().equals(courseName))
                return course;
        }
        return null;
    }
}
