package view;

import application.Boot;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import model.Website;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Stephen Adu on 23/02/2017.
 */
public class MoodGraphController {

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);


    @FXML
    private CategoryAxis xAxis;
    @FXML
    private CategoryAxis yAxis;


    @FXML
    private LineChart<String, Integer> moodGraph;

    private Boot boot;

    @FXML
    public void initialize(){
        xAxis.setLabel("Time");
    }

    public void setBoot(Boot boot){
       this.boot = boot;
    }

    public void initializeData() {
        Runnable r = () -> {
            try {
                Platform.runLater(() -> {
                    moodGraph.getData().clear();
                    for (Website website : boot.getWebsites()) {
                        ArrayList<Integer> averageValue = website.calculateAverage();
                        XYChart.Series<String,Integer> series = new XYChart.Series<>();
                        series.setName(website.getUrl());
                        for (int i = 0; i < averageValue.size(); i++) {
                            String xValue = ("test" + i);
                            series.getData().add(new XYChart.Data<>(xValue, averageValue.get(i)));
                        }
                        moodGraph.getData().add(series);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        scheduler.scheduleAtFixedRate(r, 0, 10, TimeUnit.SECONDS);
    }






}
