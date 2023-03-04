package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GodView extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = FXMLLoader.load(getClass().getResource("/fxml/GodMode.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        ViewController.setStage(stage);
        stage.show();
    }
    public static void getStart() throws Exception {
        GodView godView = new GodView();
        ViewController.getStage().close();
        godView.start(new Stage());
    }
}
