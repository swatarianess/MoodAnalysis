package Drawing.Controller;

import Drawing.Main;
import Engine.WebsitePool;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.Executor;


public class MainLayoutController{

    @FXML
    public BorderPane rootLayout;
    private Stage stage;


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void handleHelp(ActionEvent actionEvent) throws IOException {
        System.out.println("Opening help menuItem");
    }

    public void handleAddWebsite(ActionEvent actionEvent) throws IOException {
        System.out.println("Opening: AddWebsite menuItem");
        createPopup(Main.NEW_WEBSITE_SCREEN_FXML,400,130);
    }

    public void handleAbout(ActionEvent actionEvent) throws IOException {
        System.out.println("Opening: About menuItem");
    }

    public void handleSettings(ActionEvent actionEvent) throws IOException {
        System.out.println("Opening: Settings menuItem");
        Node settings = FXMLLoader.load(getClass().getResource("../" + Main.PACKAGE + Main.SETTINGS_FXML));
        setMiddle(settings,731,900);
    }

    public void handleThreadsOfInterest(ActionEvent actionEvent) throws IOException {
        System.out.println("Opening: Threads_of_Interest menuItem");
        Node threadsOfInterest = FXMLLoader.load(getClass().getResource("../" + Main.PACKAGE + Main.THREADS_OF_INTEREST));
        setMiddle(threadsOfInterest,530,950);
    }

    public void handleShowMoodOverview(ActionEvent actionEvent) throws IOException {
        System.out.println("Opening: Show_Mood_Overview menuItem");
        Node addWeb = FXMLLoader.load(getClass().getResource("../" + Main.PACKAGE + Main.GRAPHS_SCREEN_FXML));
        setMiddle(addWeb,731,800);
    }

    public void handleShowEnginePerformance(ActionEvent actionEvent) throws IOException {
        System.out.println("Opening: Show_Engine_Performance menuItem");
    }

    public void handleStopEngine(ActionEvent actionEvent) throws IOException {
        System.out.println("Opening: Stop_Engine menuItem");
    }

    public void handleStartEngine(ActionEvent actionEvent) throws IOException {
        System.out.println("Opening: Start_Engine menuItem");
        Executor executor = Runnable::run;
        executor.execute(new WebsitePool());

    }

    public void handleShowThreadList(ActionEvent actionEvent) throws IOException {
        System.out.println("Opening: Show_ThreadList menuItem");
        Node threadList = FXMLLoader.load(getClass().getResource("../"+ Main.PACKAGE + Main.THREAD_LIST));
        setMiddle(threadList,500,750);
    }

    public void handleAddThread(ActionEvent actionEvent) throws IOException {
        System.out.println("Opening: Add_Thread menuItem");
        createPopup(Main.NEW_THREAD_SCREEN_FXML,420,160);

    }

    public void handleExit(ActionEvent actionEvent) {
        System.out.println("Opening: Exit menuItem");
        stage.close();
    }

    private Stage getStage(){
        return stage;
    }

    private void setMiddle(Node value, double minHeight, double minWidth) {
        AnchorPane newCenter = value == null ? new AnchorPane() : new AnchorPane(value);
        rootLayout.setCenter(newCenter);

        if (value != null) {
            AnchorPane.setBottomAnchor(value, 0.0);
            AnchorPane.setLeftAnchor(value, 0.0);
            AnchorPane.setRightAnchor(value, 0.0);
            AnchorPane.setTopAnchor(value, 0.0);
        }

        getStage().setHeight(minHeight + 50);
        getStage().setWidth(minWidth);
        getStage().centerOnScreen();
    }

    private void createPopup(String screen, int width, int height) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(Main.PACKAGE+screen));
        AnchorPane rootGroup = fxmlLoader.load();

        Scene scene = new Scene(rootGroup, width, height);
        scene.setFill(Color.TRANSPARENT);

        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(we -> System.out.println("Closing..."));
        primaryStage.setResizable(false);
        primaryStage.show();
    }



}
