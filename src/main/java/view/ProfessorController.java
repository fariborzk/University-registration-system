package view;

import controller.Controller;
import enums.Edit;
import enums.Message;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Course;
import model.Department;
import model.Professor;
import model.Student;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ProfessorController extends ViewController implements Initializable {
    private static Professor loggedInProfessor;
    private static ProfessorController instance;
    private static Pane infoPane;
    @FXML
    private Pane info;
    @FXML
    private ScrollPane courseBar;
    @FXML
    private ScrollPane departmentProfessors;
    @FXML
    private ScrollPane editBar;
    @FXML
    private ScrollPane studentInfo;
    @FXML
    private TextField courseName;
    @FXML
    private TextField credits;
    @FXML
    private TextField editCourseName;
    @FXML
    private TextField editStudentId;
    private Course presentCourse;
    public ProfessorController() {
        super();
        instance = this;
    }
    public static void setProfessorLoggedIn(Professor professor) { loggedInProfessor = professor; }

    public static void loadCourseStudents(String courseName) {
        for (Student student : Controller.getCourseStudents(Controller.getCourse(courseName)))
            instance.addStudentToBar(instance.studentInfo, student);
        instance.info.setVisible(true);
    }
    public void close() {
        if (info.getClip().isVisible()) {
            ((VBox) editBar.getContent()).getChildren().remove(1, ((VBox) editBar.getContent()).getChildren().size());
            info.setVisible(false);
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        info.setVisible(false);
        loadProfessors(loggedInProfessor.getDepartment());
        loadProfessorsCourses();
    }
    public void getAddStudent2Course() {
        List<TextField> fields = Arrays.asList(editStudentId, editCourseName);
        if (checkFieldsFill(fields)) {
            Message message;
            if (Controller.doesProHasCourse(loggedInProfessor, editCourseName.getText()))
                createPopup(1100, 750, 20, 20, 30, 50, "Red", Message.PROF_HAS_NOT_COURSE.toString(), ViewController.getStage());
            else if (Controller.doesStudentHasCourse(editCourseName.getText(), editStudentId.getText()))
                createPopup(1100, 750, 20, 20, 30, 50, "Red", Message.STUDENT_HAVE_COURSE.toString(), ViewController.getStage());
            else {
                editStudent2Course(editBar, editStudentId.getText(), editCourseName.getText(), Edit.ADD);
                clearFields(fields);
            }
        }
    }
    public void getDeleteStudent() {
        List<TextField> fields = Arrays.asList(editStudentId, editCourseName);
        if (checkFieldsFill(fields)) {
            Message message;
            if (Controller.doesProHasCourse(loggedInProfessor, editCourseName.getText()))
                createPopup(1100, 750, 20, 20, 30, 50, "Red", Message.PROF_HAS_NOT_COURSE.toString(), ViewController.getStage());
            else if (!Controller.doesStudentHasCourse(editCourseName.getText(), editStudentId.getText()))
                createPopup(1100, 750, 20, 20, 30, 50, "Red", Message.STUDENT_NOT_HAVE_COURSE.toString(), ViewController.getStage());
            else {
                editStudent2Course(editBar, editStudentId.getText(), editCourseName.getText(), Edit.DELETE);
                clearFields(fields);
            }
        }
    }
    public void getAddCourse() { checkAddCourse(courseBar, courseName, new TextField(loggedInProfessor.getDepartment().getName()),
            credits, new TextField(loggedInProfessor.getName())); }
    private void loadProfessors(Department department) {
        ArrayList<Professor> professors = Controller.getDepartmentProfessors(department);
        for (Professor professor : professors)
            addProfessorToBar(departmentProfessors, professor);
    }
    public void loadProfessorsCourses() {
        ArrayList<Course> courses = Controller.getProfessorCourses(loggedInProfessor);
        for (Course course : courses) {
            presentCourse = course;
            addCourseToBar(courseBar, course, true);
        }
    }
}
