package enums;

public enum Message {
    STUDENT_ADDED("Student Added successfully"),
    DEPARTMENT_ADDED("Department Added Successfully"),
    PROFESSOR_ADDED("Professor Added Successfully"),
    GRADE_ADDED("Grade Added Successfully"),
    COURSE_ADDED("Course Added Successfully"),
    STUDENT_EXIST("Student exist"),
    PROFESSOR_EXIST("Professor exist"),
    COURSE_EXIST("Course exist"),
    DEPARTMENT_EXIST("Department exist"),
    GRADE_EXIST("Grade exist"),
    STUDENT_NOT_EXIST("Student doesn't exist"),
    STUDENT_NOT_HAVE_COURSE("Student haven't course"),
    COURSE_NOT_EXIST("Course doesn't exist"),
    PROF_HAS_NOT_COURSE("the Professor hasn't course"),
    STUDENT_EDITED_IN_COURSE("student edited in course"),
    STUDENT_HAVE_COURSE("the student have course");
    private String text;
    private Message(String text) {
        this.text = text;
    }
    @Override
    public String toString() { return this.text; }
}
