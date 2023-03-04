package view;

import enums.Edit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class DepartmentController extends ViewController implements Initializable {
    @FXML
    private Label professorLab;
    @FXML
    private Label courseLab;
    @FXML
    private Label studentLab;
    @FXML
    private Label gradeLab;
    @FXML
    private ScrollPane studentBar;
    @FXML
    private ScrollPane courseBar;
    @FXML
    private ScrollPane professorBar;
    @FXML
    private ScrollPane editBar;
    @FXML
    private TextField studentName;
    @FXML
    private TextField stuDepartmentId;
    @FXML
    private TextField stuStudentId;
    @FXML
    private TextField studentBirthday;
    @FXML
    private TextField crsDepartmentId;
    @FXML
    private TextField professorName;
    @FXML
    private TextField professorBirthday;
    @FXML
    private TextField professorRank;
    @FXML
    private TextField courseName;
    @FXML
    private TextField credits;
    @FXML
    private TextField crsProfessorName;
    @FXML
    private TextField editCourseName;
    @FXML
    private TextField editStudentId;
    @FXML
    private TextField proDepartmentId;
    public DepartmentController() {
        super();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) { connectHandlers(); }
    public void connectHandlers() {
        Guide(courseLab, ViewController.CourseGuide);
        Guide(gradeLab, ViewController.GradeGuide);
        Guide(professorLab, ViewController.ProfessorGuide);
        Guide(studentLab, ViewController.StudentGuide);
    }
    public void getAddStudent() { checkAddStudent(studentBar, studentName, stuStudentId, stuDepartmentId, studentBirthday); }
    public void getAddProfessor() { checkAddProfessor(professorBar, professorName, proDepartmentId, professorBirthday, professorRank); }
    public void getAddCourse() { checkAddCourse(courseBar, courseName, crsDepartmentId, credits, crsProfessorName); }
    public void getAddStudent2Course() { checkEditStudent2Course(editBar, editStudentId, editCourseName, Edit.ADD); }
    public void getDeleteStudent() { checkEditStudent2Course(editBar, editStudentId, editCourseName, Edit.DELETE); }
}
