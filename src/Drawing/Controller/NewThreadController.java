package Drawing;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Steve on 21/10/2016.
 */
public class NewThreadController implements Initializable {

    @FXML
    public TextField addThreadTextField;
    //Buttons
    @FXML
    public Button cancelButton;
    @FXML
    public Button addButton;
    public BorderPane newThreadAnchorPane;
    public ChoiceBox websitesChoiceBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleAddThread(ActionEvent actionEvent) {

    }
}
