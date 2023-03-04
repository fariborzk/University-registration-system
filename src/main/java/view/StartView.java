package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartView extends Application {
    private static Stage stage;
    public void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(getClass().getResource("/fxml/StartView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        ViewController.setStage(primaryStage);
        stage = primaryStage;
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }
    public static Stage getStage() { return stage; }
}

