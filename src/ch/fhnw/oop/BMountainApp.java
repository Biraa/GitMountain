package ch.fhnw.oop;

/**
 * Created by Biraveen on 21.11.2015.
 */
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BMountainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent rootPanel = new BMountainUI();

        Scene scene = new Scene(rootPanel);

        String stylesheet = getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);


        primaryStage.setTitle("Mountains");
        primaryStage.setScene(scene);
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(700);

        primaryStage.setHeight(700);
        primaryStage.setWidth(1000);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}