package UI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Steve on 20/10/2016.
 */
public class GraphController implements Initializable {

    public VBox vBoxLabelContainer;
    public VBox vBoxLabelValueContainer;

    @FXML
    public LineChart moodGraph;

    @FXML
    public Hyperlink hyperLinkLabelValue;

    @FXML
    public Label currentSiteLabelValue;

    @FXML
    public Label minimumSiteLabelValue;

    @FXML
    public Label maximumSiteLabelValue;

    @FXML
    public Label averageSiteLabelValue;

    @FXML
    public Label noteLabelValue;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO initalize data
    }

}
