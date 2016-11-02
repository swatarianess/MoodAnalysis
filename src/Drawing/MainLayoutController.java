package Drawing;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainLayoutController implements Initializable {

    //The Menu Bar
    @FXML
    public MenuBar menuBar;

    //The Menu Options
    @FXML
    public Menu fileMenu;
    @FXML
    public Menu editMenu;
    @FXML
    public Menu engineMenu;
    @FXML
    public Menu graphMenu;
    @FXML
    public Menu helpMenu;

    //File Menu
    @FXML
    public MenuItem itemExit;

    //Edit Menu
    @FXML
    public MenuItem itemAddWebsite;
    @FXML
    public MenuItem itemAddThread;

    //Engine Menu
    @FXML
    public MenuItem itemSwitchEngine;
    @FXML
    public MenuItem itemShowThreadList;
    @FXML
    public MenuItem itemStartEngine;
    @FXML
    public MenuItem itemStopEngine;
    @FXML
    public MenuItem itemShowEnginePerformance;

    //Graph Menu
    @FXML
    public MenuItem itemShowMoodOverview;
    @FXML
    public MenuItem itemShowThreadsOfInterest;

    //Help Menu
    @FXML
    public MenuItem itemHelp;
    @FXML
    public MenuItem itemSettings;
    @FXML
    public MenuItem itemAbout;
    @FXML
    public BorderPane innerBodyBorderPane;
    public BorderPane rootBodyPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleHelp(ActionEvent actionEvent) {
        System.out.println("Opening: " + itemHelp.getText());
    }

    @FXML
    public void handleAddWebsite(ActionEvent actionEvent) {
        System.out.println("Opening: " + itemAddWebsite.getText());
        try{
            URL webSiteUrl = getClass().getResource(Main.NEW_WEBSITE_SCREEN_FXML);
            AnchorPane websitePane = FXMLLoader.load(webSiteUrl);
            BorderPane borderPane = Main.getRoot();
            borderPane.setCenter(websitePane);
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void handleAbout(ActionEvent actionEvent) {
        System.out.println("Opening: " + itemAbout.getText());
    }

    public void handleSettings(ActionEvent actionEvent) {
        System.out.println("Opening: " + itemSettings.getText());
    }

    public void handleThreadsOfInterest(ActionEvent actionEvent) {
        System.out.println("Opening: " + itemShowThreadsOfInterest.getText());
    }

    public void handleShowMoodOverview(ActionEvent actionEvent) {
        System.out.println("Opening: " + itemShowMoodOverview.getText());
        try{
            URL webSiteUrl = getClass().getResource(Main.GRAPHS_SCREEN_FXML);
            SplitPane websitePane = FXMLLoader.load(webSiteUrl);
            BorderPane borderPane = Main.getRoot();
            borderPane.setCenter(websitePane);
            System.out.println("Set Centre to: " + websitePane.getId());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void handleShowEnginePerformance(ActionEvent actionEvent) {
        System.out.println("Opening: " + itemShowEnginePerformance.getText());
    }

    public void handleStopEngine(ActionEvent actionEvent) {
        System.out.println("Opening: " + itemStopEngine.getText());
    }

    public void handleStartEngine(ActionEvent actionEvent) {
        System.out.println("Opening: " + itemStartEngine.getText());
    }

    public void handleShowThreadList(ActionEvent actionEvent) {
        System.out.println("Opening: " + itemShowThreadList.getText());
    }

    public void handleSwitchEngine(ActionEvent actionEvent) {
        System.out.println("Opening: " + itemSwitchEngine.getText());

    }

    public void handleAddThread(ActionEvent actionEvent) {
        System.out.println("Opening: " + itemAddThread.getText());
        try{
            URL newThreadPaneUrl = getClass().getResource(Main.NEW_THREAD_SCREEN_FXML);
            BorderPane newThreadPane = FXMLLoader.load(newThreadPaneUrl);
            BorderPane borderPane = Main.getRoot();
            borderPane.setCenter(newThreadPane);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void handleExit(ActionEvent actionEvent) {
        System.out.println("Opening: " + itemExit.getText());
    }


}
