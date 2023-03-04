package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class GodController extends ViewController implements Initializable {
    private static GodController Instance = null;
    @FXML
    private Label courseLab;
    @FXML
    private Label studentLab;
    @FXML
    private Label gradeLab;
    @FXML
    private Label professorLab;
    @FXML
    private Label departmentLab;
    @FXML
    private TextField studentName;
    @FXML
    private TextField stuStudentId;
    @FXML
    private TextField studentBirthday;
    @FXML
    private TextField stuDepartmentId;
    @FXML
    private TextField professorName;
    @FXML
    private TextField departmentName;
    @FXML
    private TextField grdCourseName;
    @FXML
    private TextField grdStudentId;
    @FXML
    private TextField proDepartmentId;
    @FXML
    private TextField courseName;
    @FXML
    private TextField departmentId;
    @FXML
    private TextField crsDepartmentId;
    @FXML
    private TextField professorBirthday;
    @FXML
    private TextField credits;
    @FXML
    private TextField grade;
    @FXML
    private TextField professorRank;
    @FXML
    private TextField crsProfessorName;
    @FXML
    private ScrollPane studentBar;
    @FXML
    private ScrollPane courseBar;
    @FXML
    private ScrollPane professorBar;
    @FXML
    private ScrollPane gradeBar;
    @FXML
    private ScrollPane departmentBar;

    public GodController(){
        super();
        Instance = this;
    }
    public void connectHandlers() {
        Guide(courseLab, ViewController.CourseGuide);
        Guide(departmentLab, ViewController.DepartmentGuide);
        Guide(gradeLab, ViewController.GradeGuide);
        Guide(professorLab, ViewController.ProfessorGuide);
        Guide(studentLab, ViewController.StudentGuide);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        connectHandlers();
        loadCourses(courseBar, false);
        loadDepartments(departmentBar);
        loadGrades(gradeBar);
        loadProfessors(professorBar);
        loadStudents(studentBar);
    }
    public void getAddStudent() { checkAddStudent(studentBar, studentName, stuStudentId, stuDepartmentId, studentBirthday); }
    public void getAddProfessor() { checkAddProfessor(professorBar, professorName, proDepartmentId, professorBirthday, professorRank); }
    public void getAddCourse() { checkAddCourse(courseBar, courseName, crsDepartmentId, credits, crsProfessorName); }
    public void getAddDepartment() { checkAddDepartment(departmentBar, departmentName, departmentId); }
    public void getAddGrade() { checkAddGrade(gradeBar, grdStudentId, grdCourseName, grade); }
}
