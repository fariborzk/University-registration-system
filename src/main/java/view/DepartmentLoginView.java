package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class DepartmentLoginView extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource("/fxml/DepartmentModeLogin.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        ViewController.setStage(primaryStage);
        primaryStage.show();
    }
    public static void getStart() throws Exception {
        DepartmentLoginView departmentLoginView = new DepartmentLoginView();
        ViewController.getStage().close();
        departmentLoginView.start(new Stage());
    }
}
