package view;

import controller.Controller;
import enums.Edit;
import enums.Message;
import enums.Mode;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public abstract class ViewController {
    public static String CourseGuide = "this is Course segment and have fields : \n" +
            "courseName, credits,\ndepartment and professor";
    public static String DepartmentGuide = "this is Department segment and have fields : \n" +
            "department name and Department Id";
    public static String StudentGuide = "this is Student segment and have fields : \n" +
            "student name, student id, birthday and department";
    public static String ProfessorGuide = "this is Professor segment and have fields : \n" +
            "professor name, birthday, department and rank";
    public static String GradeGuide = "this is Grade segment and have fields : \n" +
            "student id, course name and grade";
    protected Mode mode;
    protected String username;
    private static Stage stage;
    protected static Stage getStage() { return stage;}
    protected static void setStage(Stage primaryStage) { stage = primaryStage; }
    public void exit() {
        System.exit(0);
    }
    public Mode getMode() { return this.mode; }
    public String getUsername() { return this.username; }
    protected void checkAddStudent(ScrollPane studentBar, TextField studentName, TextField stuStudentId, TextField stuDepartmentId, TextField studentBirthday) {
        List<TextField> fields = Arrays.asList(studentName, stuStudentId, stuDepartmentId, studentBirthday);
        if (checkFieldsFill(fields)) {
            if (createStudent(studentName, stuStudentId, studentBirthday, stuDepartmentId) == Message.STUDENT_EXIST)
                createPopup(1100, 750, 20, 20, 30, 50, "Red", Message.STUDENT_EXIST.toString(), ViewController.getStage());
            else
                addStudentToBar(studentBar, Controller.getLastStudent());
            clearFields(fields);
        }
    }
    protected void checkAddProfessor(ScrollPane professorBar, TextField professorName, TextField departmentId, TextField birthday, TextField rank) {
        List<TextField> fields = Arrays.asList(professorName, departmentId, birthday, rank);
        if (checkFieldsFill(fields)) {
            if (createProfessor(professorName, departmentId, birthday, rank) == Message.PROFESSOR_EXIST)
                createPopup(1100, 750, 20, 20, 30, 50, "Red", Message.PROFESSOR_EXIST.toString(), ViewController.getStage());
            else
                addProfessorToBar(professorBar, Controller.getLastProfessor());
            clearFields(fields);
        }
    }
    protected void checkAddCourse(ScrollPane courseBar, TextField courseName, TextField crsDepartmentId, TextField credits, TextField crsProfessorName) {
        List<TextField> fields = Arrays.asList(courseName, crsDepartmentId, credits, crsProfessorName);
        if (checkFieldsFill(fields)) {
            if (createCourse(courseName, crsDepartmentId, credits, crsProfessorName) == Message.COURSE_EXIST)
                createPopup(1100, 750, 20, 20, 30, 50, "Red", Message.COURSE_EXIST.toString(), ViewController.getStage());
            else
                addCourseToBar(courseBar, Controller.getLastCourse(), false);
            clearFields(fields);
        }

    }
    protected void checkAddGrade(ScrollPane gradeBar, TextField grdStudentId, TextField grdCourseName, TextField grade) {
        List<TextField> fields = Arrays.asList(grdStudentId, grdCourseName, grade);
        if (checkFieldsFill(fields)) {
            Message message;
            if ((message = createGrade(grdStudentId, grdCourseName, grade)) == Message.STUDENT_NOT_EXIST)
                createPopup(1100, 750, 20, 20, 30, 50, "Red", Message.STUDENT_NOT_EXIST.toString(), ViewController.getStage());
            else if (message == Message.STUDENT_NOT_HAVE_COURSE)
                createPopup(1100, 750, 20, 20, 30, 50, "Red", Message.STUDENT_NOT_HAVE_COURSE.toString(), ViewController.getStage());
            else if (message == Message.GRADE_EXIST)
                createPopup(1100, 750, 20, 20, 30, 50, "Red", Message.GRADE_EXIST.toString(), ViewController.getStage());
            else
                addGradeToBar(gradeBar, Controller.getLastGrade());
            clearFields(fields);
        }
    }
    protected void checkAddDepartment(ScrollPane departmentBar, TextField departmentName, TextField departmentId) {
        List<TextField> fields = Arrays.asList(departmentName, departmentId);
        if (checkFieldsFill(fields)) {
            if (createDepartment(departmentName, departmentId) == Message.DEPARTMENT_EXIST)
                createPopup(1100, 750, 20, 20, 30, 50, "Red", Message.DEPARTMENT_EXIST.toString(), ViewController.getStage());
            else
                addDepartmentToBar(departmentBar, Controller.getLastDepartment());
            clearFields(fields);
        }
    }
    public Message createStudent(TextField studentName, TextField studentId, TextField birthday, TextField departmentId) {
        return Controller.getController().addStudent(studentName.getText(),
                studentId.getText(), birthday.getText(), departmentId.getText()); }
    public Message createProfessor(TextField professorName, TextField departmentId, TextField birthday, TextField rank) {
        return Controller.getController().addProfessor(professorName.getText(),
                departmentId.getText(), birthday.getText(), rank.getText()); }
    public Message createCourse(TextField courseName, TextField crsDepartmentId, TextField credits, TextField crsProfessorName) {
            return Controller.getController().addCourse(courseName.getText(), crsDepartmentId.getText(),
                    credits.getText(), crsProfessorName.getText());
    }
    public Message createGrade(TextField grdStudentId, TextField grdCourseName, TextField grade) {
        return Controller.getController().addGrade(grdStudentId.getText(), grdCourseName.getText(), grade.getText());
    }
    public Message createDepartment(TextField departmentName, TextField departmentId) {
        return Controller.getController().addDepartment(departmentName.getText(), departmentId.getText());
    }
    protected void addGradeToBar(ScrollPane gradeBar, GradeReport grade) {
        Label labelGrade = new Label(grade.getGrade());
        Label labelCourseName = new Label(grade.getCourse().getName());
        Label labelStudentId = new Label(grade.getStudent().getId());
        labelGrade.setPrefWidth(73);
        labelCourseName.setPrefWidth(130);
        labelStudentId.setPrefWidth(110);
        List<Label> labels = Arrays.asList(labelStudentId, labelCourseName, labelGrade);
        addNodesToBar(labels, gradeBar, false);
    }
    protected void addDepartmentToBar(ScrollPane departmentBar, Department department) {
        Label labelName = new Label(department.getName());
        Label labelId = new Label(department.getId());
        labelName.setPrefWidth(130);
        labelId.setPrefWidth(130);
        List<Label> labels = Arrays.asList(labelName, labelId);
        addNodesToBar(labels, departmentBar, false);
    }
    protected void addCourseToBar(ScrollPane courseBar, Course course, boolean selective) {
        List<Label> labels = createLabelCourse(course);
        addNodesToBar(labels, courseBar, selective);

    }
    protected void addProfessorToBar(ScrollPane bar, Professor professor) {
        Label labelName = new Label(professor.getName());
        Label labelBirthday = new Label(professor.getBirthday().toString());
        Label labelDepId = new Label((professor.getDepartment() == null ) ? "NULL" : professor.getDepartment().getId());
        Label labelRank = new Label(professor.getRank().toString());
        labelName.setPrefWidth(165);
        labelDepId.setPrefWidth(150);
        labelBirthday.setPrefWidth(130);
        labelBirthday.setPrefWidth(130);
        List<Label> labels = Arrays.asList(labelName, labelDepId, labelBirthday, labelRank);
        addNodesToBar(labels, bar, false);
    }
    protected void addStudentToBar(ScrollPane bar, Student student) {
        Label labelName = new Label(student.getName());
        Label labelId = new Label(student.getId());
        Label labelDepartment = new Label((student.getDepartment() == null) ?"NULL" : student.getDepartment().getId());
        Label labelBirthday = new Label(student.getBirthday().toString());
        labelName.setPrefWidth(110);
        labelId.setPrefWidth(90);
        labelDepartment.setPrefWidth(110);
        labelBirthday.setPrefWidth(130);
        List<Label> labels = Arrays.asList(labelName, labelId, labelDepartment, labelBirthday);
        addNodesToBar(labels, bar, false);


    }
    protected List<Label> createLabelCourse(Course course) {
        Label labelName = new Label(course.getName());
        Label labelDepartmentId = new Label(course.getDepartment() == null ? "NULL" : course.getDepartment().getId());
        Label labelCredits = new Label(course.getCredits());
        Label labelProfName = new Label(course.getProfessor() == null ? "NULL" : course.getProfessor().getName());
        labelName.setPrefWidth(130);
        labelDepartmentId.setPrefWidth(130);
        labelCredits.setPrefWidth(90);
        labelProfName.setPrefWidth(130);
        return Arrays.asList(labelName, labelDepartmentId, labelCredits, labelProfName);
    }
    protected void addNodesToBar(List<Label> labels, ScrollPane bar, boolean doseSelective) {
        HBox hBox = new HBox();
        for (Label label : labels) {
            label.setPrefHeight(30);
            label.setAlignment(Pos.valueOf("CENTER"));
            hBox.getChildren().add(label);

        }
        if (doseSelective) {
            hBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    ProfessorController.loadCourseStudents(labels.get(0).getText());
                }
            });
        }
        ((VBox) bar.getContent()).getChildren().add(hBox);
    }
    protected void checkEditStudent2Course(ScrollPane bar, TextField studentId, TextField courseName, Edit type) {
        List<TextField> fields = Arrays.asList(studentId, courseName);
        if (checkFieldsFill(fields)) {
            Message message;
            if ((message = Controller.getEditStudent2Course(studentId.getText(), courseName.getText(), type)) == Message.STUDENT_NOT_EXIST) {
                createPopup(1100, 750, 20, 20, 30, 50, "Red", Message.STUDENT_NOT_EXIST.toString(), ViewController.getStage());
            }
            else if (message == Message.COURSE_NOT_EXIST) {
                    createPopup(1100, 750, 20, 20, 30, 50, "Red", Message.COURSE_NOT_EXIST.toString(), ViewController.getStage());
            }
            else
                editStudent2Course(bar, studentId.getText(), courseName.getText(), type);
            clearFields(fields);

        }
    }
    protected void editStudent2Course(ScrollPane bar, String studentId, String courseName, Edit type) {
        Label labelId = new Label(studentId);
        Label labelName = new Label(courseName);
        Label  labelType = new Label(type.toString());
        labelName.setPrefWidth(130);
        labelId.setPrefWidth(110);
        labelType.setPrefWidth(70);
        addNodesToBar(Arrays.asList(labelId, labelName, labelType), bar, false);
    }
    protected void clearFields(List<TextField> fields) {
        for (TextField field : fields)
            field.clear();
    }
    protected static void Guide(Label label, String string) {
        label.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                createPopup(1100, 750, 120, 65, 30, 50,
                        "#26C526FF", string, ViewController.stage);
            }
        });
    }
    protected boolean checkFieldsFill(List<TextField> fields) {
        for (TextField field : fields) {
            if (field != null && field.getText().equals("")) {
                createPopup(1100, 750, 50, 20, 30, 50,
                        "Red", "you should fill all fields", ViewController.getStage());
                return false;
            }
        }
        return true;
    }
    protected static void createPopup(double popX, double popY, int butX, int butY, int butHeight, int butWidth,
                                      String colorBack, String text, Stage stage) {
        Label label = new Label(text);
        label.setStyle("-fx-text-fill: black");
        label.setStyle("-fx-background-color: " + colorBack);
        Button button = new Button("Ok");
        button.setPrefHeight(butHeight);
        button.setPrefWidth(butWidth);
        button.setLayoutX(butX);
        button.setLayoutY(butY);
        Pane pane = new Pane(label, button);
        Popup popup = new Popup();
        popup.getContent().add(pane);
        popup.setAnchorX(popX);
        popup.setAnchorY(popY);
        popup.show(stage);
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                popup.hide();
            }
        });
    }
    public void backToStart() {
        ViewController.getStage().close();
        StartView.getStage().show();
    }
    public void loadCourses(ScrollPane courseBar, boolean select) {
        ArrayList<Course> courses = Controller.getCourses();
        for (Course course : courses)
            addCourseToBar(courseBar, course, select);
    }
    public void loadProfessors(ScrollPane professorBar) {
        ArrayList<Professor> professors = Controller.getProfessors();
        for (Professor professor : professors)
            addProfessorToBar(professorBar, professor);
    }
    public void loadDepartments(ScrollPane departmentBar) {
        ArrayList<Department> departments = Controller.getDepartments();
        for (Department department : departments)
            addDepartmentToBar(departmentBar, department);
    }
    public void loadStudents(ScrollPane studentBar) {
        ArrayList<Student> students = Controller.getStudents();
        for (Student student : students)
            addStudentToBar(studentBar, student);
    }
    public void loadGrades(ScrollPane gradeBar) {
        ArrayList<GradeReport> grades = Controller.getGrades();
        for (GradeReport grade : grades)
            addGradeToBar(gradeBar, grade);
    }
}
