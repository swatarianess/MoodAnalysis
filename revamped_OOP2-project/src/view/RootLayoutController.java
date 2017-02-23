package view;

import application.Boot;
import controller.engines.primitive.PrimitiveEngine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

/**
 * Created by Stephen Adu on 22/02/2017.
 */
public class RootLayoutController{

    @FXML
    public BorderPane rootLayout;
    @FXML
    public MenuItem primitiveEngineMI;
    @FXML
    public MenuItem advancedEngineMI;

    private boolean isRunning;
    private Boot boot;

    public void setBoot(Boot boot){
        this.boot = boot;
    }

    public boolean isRunning(){
        return isRunning;
    }

    @FXML
    public void handleExit(ActionEvent actionEvent) {
        handleStopEngine(actionEvent);
        boot.stop();
        System.exit(0);
    }

    @FXML
    public void handleAddWebsite(ActionEvent actionEvent) throws IOException {
        showDialog("../view/DWebsite.fxml","New Website"); //TODO: add check that added successfully.
    }

    @FXML
    public void handleAddThread(ActionEvent actionEvent) throws IOException {
        showDialog("../view/DThread.fxml","New Thread");  //TODO: add check that added successfully.
    }

    @FXML
    public void handleShowThreadList(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(boot.getClass().getResource("../view/ThreadList.fxml"));

            BorderPane root = loader.load();
            ThreadListController controller = loader.getController();
            controller.setBoot(boot);

            boot.setCentred(root,720,1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleStartEngine(ActionEvent actionEvent) {
        boot.startEngine();
    }

    @FXML
    public void handleStopEngine(ActionEvent actionEvent) {
        boot.stopEngine();
    }

    @FXML
    public void handleShowEnginePerformance(ActionEvent actionEvent) {
    }

    @FXML
    public void handleShowMoodOverview(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(boot.getClass().getResource("../view/MoodGraph.fxml"));
            SplitPane root = loader.load();

            MoodGraphController graphController = loader.getController();
            graphController.setBoot(boot);
            graphController.initializeData();
            boot.setCentred(root, 720, 1024);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void handleThreadsOfInterest(ActionEvent actionEvent) {
    }

    @FXML
    public void handleHelp(ActionEvent actionEvent) {
    }

    @FXML
    public void handleSettings(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(boot.getClass().getResource("../view/Settings.fxml"));

            AnchorPane root = loader.load();
            SettingsController settingsController = loader.getController();
            settingsController.setBoot(boot);

            boot.setCentred(root, 720, 1024);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleAbout(ActionEvent actionEvent) {
        showAlert(Alert.AlertType.INFORMATION, boot.getPrimaryStage(), "About", null,
                "MoodAnalyser v0.2 \n\n Created by: Stephen Adu");
    }

    @FXML
    public void handleSwitchToPrimitiveEng(ActionEvent actionEvent) {
        try{
            boot.setEngine(new PrimitiveEngine(boot.getWebsites(),5,5000,5, Thread.NORM_PRIORITY));
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR,boot.getPrimaryStage(),"Error","Could not read words!","List of words could not be read. \n Please Try again.");
        }
    }

    private static void showAlert(Alert.AlertType type, Window window, String title, String header, String content) {
        Alert error = new Alert(type);
        error.initOwner(window);
        error.setTitle(title);
        error.setHeaderText(header);
        error.setContentText(content);

        error.showAndWait();
    }

    private boolean showDialog(String url, String title) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource(url));
            AnchorPane root = loader.load();

            Stage stage = new Stage();
            stage.initOwner(boot.getPrimaryStage());
            stage.setScene(new Scene(root));
            stage.setTitle(title);

            IDialog controller = loader.getController();
            controller.setDialogStage(stage);
            controller.setBoot(boot);
            stage.showAndWait();
            return controller.isAddClicked();
        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }


}
