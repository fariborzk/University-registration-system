package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StudentLoginView extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane root  = FXMLLoader.load(getClass().getResource("/fxml/StudentModeLogin.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        ViewController.setStage(stage);
        stage.show();
    }
    protected static void getStart() throws Exception{
        StudentLoginView studentLoginView = new StudentLoginView();
        ViewController.getStage().close();
        studentLoginView.start(new Stage());
    }
}
