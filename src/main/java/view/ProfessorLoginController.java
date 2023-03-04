package view;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Professor;
import model.Student;

public class ProfessorLoginController extends ViewController {
    @FXML
    private TextField professorName;
    @FXML
    private TextField departmentName;
    public void login() throws Exception{
        if (departmentName.getText().equals("") | professorName.getText().equals(""))
            createPopup(900, 500, 50, 20, 30, 50,
                    "Red", "you should fill all fields", ViewController.getStage());
        else {
            Professor professor = Controller.getProfessor(professorName.getText(), departmentName.getText());
            if (professor == null)
                createPopup(850, 500, 90, 20, 30, 50,
                        "Red", "the Professor doesn't exist try again", ViewController.getStage());
            else
                ProfessorView.getStart(professor);
        }
    }
}
