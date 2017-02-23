package Drawing;

import Drawing.Controller.MainLayoutController;
import Engine.WebsiteData;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Observable;

public class Main extends Application {

    public static final String PACKAGE = "Views/";

    //Constants
    private static final String MAIN_SCREEN_FXML = "MainLayout.fxml";

    public static final String GRAPHS_SCREEN_FXML = "graph.fxml";

    public static final String SETTINGS_FXML = "Settings.fxml";

    public static final String NEW_THREAD_SCREEN_FXML = "NewThread.fxml";

    public static final String NEW_WEBSITE_SCREEN_FXML = "NewWebsite.fxml";

    public static final String THREADS_OF_INTEREST = "ThreadsOfInterest.fxml";
    public static final String THREAD_LIST = "ThreadList.fxml";


    public static ObservableList<WebsiteData> websiteDatas = FXCollections.observableArrayList();
    public static ObservableList<WebsiteData> threadData = FXCollections.observableArrayList();
    public HashSet<String> wordValues = new HashSet<>();
    public HashMap<String,Integer> wordValues1 = new HashMap<>();
    public static Integer checkingInterval = 20; //Seconds to check page again

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(PACKAGE+MAIN_SCREEN_FXML));
        BorderPane rootGroup = fxmlLoader.load();

        final MainLayoutController controller = fxmlLoader.getController();
        controller.setStage(primaryStage);

        Scene scene = new Scene(rootGroup, 500,500);
        scene.setFill(Color.TRANSPARENT);

        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(we -> System.out.println("Stage is closing..."));
        primaryStage.setResizable(false);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }


}
