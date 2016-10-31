package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends Application {

    static final String PACKAGE = "scenes/";

    private static final String MAIN_SCREEN_FXML = "MainLayout.fxml";

    public static final String GRAPH_SCREEN = "Graph";
    static final String GRAPHS_SCREEN_FXML = "graph.fxml";

    static final String NEW_THREAD_SCREEN = "New_Thread_Screen";
    static final String NEW_THREAD_SCREEN_FXML = "NewThread.fxml";

    static final String NEW_WEBSITE_SCREEN = "New_Website";
    static final String NEW_WEBSITE_SCREEN_FXML = "NewWebsite.fxml";

    static final String EMPTY_FXML = "empty.fxml";

    private static BorderPane root = new BorderPane();

    public static BorderPane getRoot(){
        return root;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        URL menuBarUrl = getClass().getResource(MAIN_SCREEN_FXML);
        URL emptyPane = getClass().getResource(EMPTY_FXML);

        MenuBar menuBar = FXMLLoader.load(menuBarUrl);
        AnchorPane empty = FXMLLoader.load(emptyPane);

        root.setTop(menuBar);
        root.setCenter(empty);

        Scene scene = new Scene(root, 600, 400);
        System.out.println(" 'Root' Children size: " + root.getChildren().size());
        System.out.println(" 'Root' Array Contains: " + Arrays.deepToString(root.getChildren().toArray()));


        primaryStage.setScene(scene);
        primaryStage.setTitle("Mood Analyser");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
