package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ProfessorLoginView extends Application {
    private static Stage stage = null;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource("/fxml/ProfessorModeLogin.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        ViewController.setStage(primaryStage);
        primaryStage.show();
    }
    public static void getStart() throws Exception {
        ProfessorLoginView professorLoginView = new ProfessorLoginView();
        ViewController.getStage().close();
        professorLoginView.start(new Stage());
    }
}
