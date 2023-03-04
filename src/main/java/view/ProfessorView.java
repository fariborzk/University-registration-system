package view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Professor;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfessorView extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(getClass().getResource("/fxml/ProfessorMode.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        ViewController.setStage(primaryStage);
        primaryStage.show();
    }
    public static void getStart(Professor professor) throws Exception{
        ProfessorView professorView = new ProfessorView();
        ProfessorController.setProfessorLoggedIn(professor);
        ViewController.getStage().close();
        professorView.start(new Stage());
    }
}
