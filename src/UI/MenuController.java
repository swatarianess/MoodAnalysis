package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;

public class MenuController {

    @FXML
    public StackPane stackPane;

    @FXML
    public LineChart moodGraphChart;
    //The Menu Bar
    @FXML
    private MenuBar menuBar;

    //The Menu Options
    @FXML
    private Menu fileMenu;
    @FXML
    private Menu editMenu;
    @FXML
    private Menu engineMenu;
    @FXML
    private Menu graphMenu;
    @FXML
    private Menu helpMenu;

    //File Menu
    @FXML
    private MenuItem itemExit;


    //Edit Menu
    @FXML
    private MenuItem itemAddWebsite;
    @FXML
    private MenuItem itemAddThread;

    //Engine Menu
    @FXML
    private MenuItem itemSwitchEngine;
    @FXML
    private MenuItem itemShowThreadList;
    @FXML
    private MenuItem itemStartEngine;
    @FXML
    private MenuItem itemStopEngine;
    @FXML
    private MenuItem itemShowEnginePerformance;

    //Graph Menu
    @FXML
    private MenuItem itemShowMoodOverview;
    @FXML
    private MenuItem itemShowThreadsOfInterest;

    //Help Menu
    @FXML
    private MenuItem itemHelp;
    @FXML
    private MenuItem itemSettings;
    @FXML
    private MenuItem itemAbout;

    public void handleHelp(ActionEvent actionEvent) {
        actionEvent.notify(); System.out.println("Clicked: " + itemHelp.getText());
    }


    public void handleAddWebsite(ActionEvent actionEvent) {
        //TODO show dialog?
        System.out.println("Opening 'add website' dialog");
    }
}
