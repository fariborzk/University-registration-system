package view;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Department;

public class DepartmentView extends Application {
    private static Department department = null;
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = FXMLLoader.load(getClass().getResource("/fxml/DepartmentMode.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        ViewController.setStage(stage);
        stage.show();
    }
    public static void getStart(Department department) throws Exception{
        DepartmentView departmentView = new DepartmentView();
        DepartmentView.department = department;
        ViewController.getStage().close();
        departmentView.start(new Stage());
    }
}
