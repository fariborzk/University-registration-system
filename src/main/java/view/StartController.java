package view;

import enums.Mode;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StartController extends ViewController {
    private static StartController startController = null;
    @FXML
    private RadioButton godRadio;
    @FXML
    private RadioButton professorRadio;
    @FXML
    private RadioButton studentRadio;
    @FXML
    private RadioButton departmentRadio;
    @FXML
    private TextField usernameField;
    public void start() {
        username = usernameField.getText();
        if (godRadio.isSelected()) {
            mode = Mode.GOD;
        }
        else if (professorRadio.isSelected()) {
            mode = Mode.PROFESSOR;
        }
        else if (studentRadio.isSelected()) {
            mode = Mode.STUDENT;

        }
        else if (departmentRadio.isSelected()) {
            mode = Mode.DEPARTMENT;
        }
        if (mode == null || username.equals("")) {
            createPopup(810, 720, 140, 30, 30, 50, "Red"
                    , "please input correctly your mode and username", ViewController.getStage());
        }
        else {
            usernameField.clear();
            if (mode == Mode.GOD) {
                try {
                    GodView.getStart();
                } catch (Exception e) {
                    System.out.println("Failed to start GodView");
                }
            }
            else if (mode == Mode.STUDENT) {
                try {
                    StudentLoginView.getStart();
                } catch (Exception e) {
                    System.out.println("Failed to start StudentView");
                }
            }
            else if (mode == Mode.DEPARTMENT) {
                try {
                    DepartmentLoginView.getStart();
                } catch (Exception e) {
                    System.out.println("Failed to start DepartmentView");
                }
            }
            else if (mode == Mode.PROFESSOR) {
                try {
                    ProfessorLoginView.getStart();
                } catch (Exception e) {
                    System.out.println("Failed to start ProfessorView");
                }
            }
        }
    }
    public static StartController getInstance() {
        if (startController == null)
            startController = new StartController();
        return startController;
    }
}
