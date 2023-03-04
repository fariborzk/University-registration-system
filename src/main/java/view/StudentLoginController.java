package view;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Student;

public class StudentLoginController extends ViewController{
    @FXML
    private TextField studentId;
    @FXML
    private TextField studentName;
    public void login() {
        if (studentId.getText().equals("") | studentName.getText().equals(""))
            createPopup(900, 500, 50, 20, 30, 50,
                    "Red", "you should fill all fields", ViewController.getStage());
        else {
            Student student = Controller.getStudent(studentId.getText(), studentName.getText());
            if (student == null)
                createPopup(850, 500, 90, 20, 30, 50,
                    "Red", "the Student doesn't exist try again", ViewController.getStage());
            else
                try {
                    StudentView.getStart(student);
                }catch (Exception e) {
                    System.out.println("Failed to load studentMode View");
                }
        }
    }
}
