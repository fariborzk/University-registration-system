package view;

import enums.Edit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import model.Course;
import model.Student;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class StudentController extends ViewController implements Initializable {
    private static Student studentLoggedIn = null;
    @FXML
    private Label courseLab;
    @FXML
    private ScrollPane courseBar;
    @FXML
    private ScrollPane studentCourseBar;
    @FXML
    private ScrollPane studentGradeBar;
    @FXML
    private ScrollPane addCourseBar;
    @FXML
    private TextField courseName;
    @FXML
    private TextField studentId;
    public static void setLoggedInStudent(Student student) { studentLoggedIn = student; }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connectHandlers();
    }
    public void setStudentLoggedIn(Student student) { studentLoggedIn = student; }
    public void connectHandlers() {
        Guide(courseLab, ViewController.CourseGuide);
        loadCourses(courseBar, false);
        LoadStudentGrades();
        LoadStudentCourses();

    }
    private void LoadStudentGrades() {
        for (Course course : studentLoggedIn.getCourses().keySet()) {
            Label labelName = new Label(course.getName());
            Label labelId = new Label(studentLoggedIn.getId());
            Label labelGrade = new Label(studentLoggedIn.getCourses().get(course).getGrade());
            labelName.setPrefWidth(130);
            labelId.setPrefWidth(110);
            labelGrade.setPrefWidth(73);
            addNodesToBar(Arrays.asList(labelId, labelName, labelGrade), studentGradeBar, false);
        }
    }
    private void LoadStudentCourses() {
        for (Course course : studentLoggedIn.getCourses().keySet()) {
            List<Label> labels = createLabelCourse(course);
            Label labelGrade = new Label(studentLoggedIn.getCourses().get(course).getGrade());
            labelGrade.setPrefWidth(80);
            labels.add(labelGrade);
            addNodesToBar(labels, studentCourseBar, false);
        }
    }
    public void getAddStudent() { checkEditStudent2Course(addCourseBar, studentId, courseName, Edit.ADD); }
}
