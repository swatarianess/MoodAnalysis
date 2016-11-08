package Drawing.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


/**
 * Created by Steve on 21/10/2016.
 */
public class NewThreadController{


    @FXML
    public TextField addThreadTextField;
    @FXML
    public ComboBox websitesComboBox;

    //Buttons
    @FXML
    public Button cancelButton;
    @FXML
    public Button addButton;
    public AnchorPane newThreadAnchorPane;


    public void handleAddThread(ActionEvent actionEvent) {

    }
}
