package view;

import application.Boot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Webpage;
import model.Website;

/**
 * Created by Stephen Adu on 23/02/2017.
 */
public class DWebsiteController implements IDialog {

    @FXML
    private TextField   urlField;
    @FXML
    private Button      cancelButton;
    @FXML
    private Button      addButton;


    private boolean     addClicked = false;
    private Boot        boot;
    private Stage       dialogeStage;
    private Website     additionalWebsite;


    /**
     * Set the main application for the Dialog
     *
     * @param boot
     */
    @Override
    public void setBoot(Boot boot) {
        this.boot = boot;
    }

    /**
     * Sets the stage for the dialog
     *
     * @param dialogStage The stage to assign the Dialog to.
     */
    @Override
    public void setDialogStage(Stage dialogStage) {
        this.dialogeStage = dialogStage;
    }

    /**
     * @return Returns <b>true</b> if the add button is clicked, false otherwise.
     */
    @Override
    public boolean isAddClicked() {
        return addClicked;
    }

    @FXML
    public void handleAdd(ActionEvent actionEvent) {
        additionalWebsite =     new Website(urlField.getText());
        addClicked =                boot.addSite(additionalWebsite);
        Webpage homePage =      new Webpage(additionalWebsite.getUrl(),additionalWebsite);

        boot.addPage(homePage);
        dialogeStage.close();
    }

    @FXML
    public void handleCancel(ActionEvent actionEvent) {
        dialogeStage.close();
    }

    public Website getAdditionalWebsite() {
        return additionalWebsite;
    }

}
