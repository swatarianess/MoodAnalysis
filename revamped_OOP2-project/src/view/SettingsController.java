package view;

import application.Boot;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stephen Adu on 23/02/2017.
 */
public class SettingsController {

    @FXML
    private TextField pathMainConfigs;
    @FXML
    private TextField pathEngineConfig;
    @FXML
    private ComboBox<Integer> loggingLevelComboBox;
    @FXML
    private ComboBox<Integer> warningLevelComboBox;
    @FXML
    private Slider intervalBetweenChecksSlider;
    @FXML
    private CheckBox ignoreRobotsCheckBox;
    @FXML
    private ComboBox<Integer> threadPriorityComboBox;

    @FXML
    private TextField minPagesTextField;
    @FXML
    private TextField maxPagesTextField;

    @FXML
    private CheckBox startEngineOnStartupCheckBox;
    @FXML
    private Slider timeoutForThreadSlider;

    @FXML
    private Button cancelSettingsButton;
    @FXML
    private Button applySettingsButton;
    @FXML
    private Button saveButton;

    private Boot boot;


    public void initialize(){
        List<Integer> integerList = new ArrayList<>();
        integerList.addAll(Arrays.asList(1,2,3,4,5,6));
        loggingLevelComboBox.setItems(FXCollections.observableArrayList(integerList));
        warningLevelComboBox.setItems(FXCollections.observableArrayList(integerList));
        integerList.clear();
        integerList.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
        threadPriorityComboBox.setItems(FXCollections.observableArrayList(integerList));

    }

    public void setBoot(Boot boot) {
        this.boot = boot;
    }




}
