package view;

import application.Boot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Webpage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Stephen Adu on 23/02/2017.
 */
public class ThreadListController{
    @FXML
    public TableView<Webpage>               threadListTable;
    @FXML
    public TableColumn<Webpage, String>     urlColumn;
    @FXML
    public TableColumn<Webpage, Number>     valueColumn;

    private Boot boot;

    public ThreadListController(){

    }

    public void setBoot(Boot boot){
        this.boot = boot;
        threadListTable.setItems(boot.getWebpages());
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        urlColumn.setCellValueFactory(cellData -> cellData.getValue().urlProperty());
        valueColumn.setCellValueFactory(cellData -> cellData.getValue().valueProperty());
    }


    public void handleDelete(ActionEvent actionEvent) {
        int indexOfSelected = threadListTable.getSelectionModel().getSelectedIndex();
        if (indexOfSelected >= 0){
            boot.getWebpages().remove(indexOfSelected);
        } else {
            System.out.println("No threads selected.");
        }


    }
}
