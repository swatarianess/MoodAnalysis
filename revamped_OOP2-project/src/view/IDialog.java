package view;

import application.Boot;
import javafx.stage.Stage;

/**
 * Created by Stephen Adu on 22/02/2017.
 */
public interface IDialog {

    /**
     *  Set the main application for the Dialog
     */
    void setBoot(Boot boot);

    /**
     *
     *  Sets the stage for the dialog
     *
     * @param dialogStage The stage to assign the Dialog to.
     */
    void setDialogStage(Stage dialogStage);

    /**
     * @return Returns <b>true</b> if the add button is clicked, false otherwise.
     */
    boolean isAddClicked();

}
