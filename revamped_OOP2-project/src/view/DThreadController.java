package view;

import application.Boot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Webpage;
import model.Website;

/**
 * Created by Stephen Adu on 23/02/2017.
 */
public class DThreadController implements IDialog {
    @FXML
    private Button addButton;
    @FXML
    private Button cancelButton;
    @FXML
    private ChoiceBox<String> websitesComboBox;
    @FXML
    private TextField addThreadTextField;
    @FXML
    private AnchorPane newThreadAnchorPane;

    private Boot boot;
    private Stage dialogStage;
    private boolean addClicked = false;

    /**
     * Set the main application for the Dialog
     */
    @Override
    public void setBoot(Boot boot) {
        this.boot = boot;

        for (Website w: boot.getWebsites()) {
            websitesComboBox.getItems().add(w.getUrl());
        }

        if (websitesComboBox.getItems().size() > 0){
            websitesComboBox.setValue(websitesComboBox.getItems().get(0));
        }

    }

    /**
     * Sets the stage for the dialog
     *
     * @param dialogStage The stage to assign the Dialog to.
     */
    @Override
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * @return Returns <b>true</b> if the add button is clicked, false otherwise.
     */
    @Override
    public boolean isAddClicked() {
        return addClicked;
    }


    public void handleAddThread(ActionEvent actionEvent) {
        String siteTitle = websitesComboBox.getValue();
        if (siteTitle == null){
            //Show alert
        }

        for (Website w : boot.getWebsites()){
            if (w.getWebsiteTitle().equals(siteTitle)){
                Webpage newPage = new Webpage(w.getUrl()+addThreadTextField.getText(),w);
                addClicked = boot.addPage(newPage);
                dialogStage.close();
                return;
            }
        }


    }


    public void handleCancel(ActionEvent actionEvent) {
        dialogStage.close();
    }
}
