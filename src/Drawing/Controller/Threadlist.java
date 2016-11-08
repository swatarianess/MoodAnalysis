package Drawing.Controller;

import Drawing.Model.Overseer;
import Engine.WebsiteData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * @author Steve
 */
public class Threadlist implements Initializable {

    @FXML
    public TableColumn nameColumn;
    @FXML
    public TableColumn urlColumn;
    @FXML
    public TableColumn moodColumn;
    @FXML
    public TableView threadListTable;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<WebsiteData> data = new Overseer().getWebsiteObList();
        nameColumn.setCellFactory(
                new PropertyValueFactory<WebsiteData,Integer>("name")
        );
    }

}
