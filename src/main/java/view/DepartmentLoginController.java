package view;
import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Department;
public class DepartmentLoginController extends ViewController{
    private static DepartmentLoginController Instance = null;
    @FXML
    private TextField departmentName;
    public DepartmentLoginController() {
        super();
        Instance = this;
    }
    public void login() throws Exception{
        if (departmentName.getText().equals(""))
            createPopup(900, 500, 50, 20, 30, 50,
                    "Red", "you should fill all fields", ViewController.getStage());
        else {
            Department department = Controller.getDepartment(departmentName.getText());
            if (department == null) {
                createPopup(850, 500, 90, 20, 30, 50,
                        "Red", "the Department doesn't exist try again", ViewController.getStage());
            }
            else {
                DepartmentView.getStart(department);
            }
        }
    }
}
