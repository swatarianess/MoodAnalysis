package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created on 17/10/2016.
 */
public class newWebsiteController {

    @FXML
    public Button cancelButton;
    @FXML
    public Button addButton;
    @FXML
    public TextField urlField;


    public void addHandler(ActionEvent actionEvent) {
        System.out.println("Added website.");
    }

    public void cancelHandler(ActionEvent actionEvent) {
        System.out.println("Canceled adding website.");
    }
}
