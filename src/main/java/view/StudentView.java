package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Student;

import java.io.IOException;

public class StudentView extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(getClass().getResource("/fxml/StudentMode.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        ViewController.setStage(primaryStage);
        primaryStage.show();
    }
    public static void getStart(Student student) throws Exception{
        StudentController.setLoggedInStudent(student);
        StudentView studentView = new StudentView();
        ViewController.getStage().close();
        studentView.start(new Stage());
    }
}
