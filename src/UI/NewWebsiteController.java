package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created on 17/10/2016.
 */
public class NewWebsiteController implements Initializable {


    @FXML
    public Button cancelButton;
    @FXML
    public Button addButton;
    @FXML
    public TextField urlField;
    @FXML
    public AnchorPane newWebsitePane;


    public void addHandler(ActionEvent actionEvent) {
        System.out.println("Added website.");
    }

    public void cancelHandler(ActionEvent actionEvent) {
        System.out.println("Canceled adding website.");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
