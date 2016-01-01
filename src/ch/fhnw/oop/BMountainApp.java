package ch.fhnw.oop;

/**
 * Created by Biraveen on 21.11.2015.
 */

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BMountainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        MountainPM model = new MountainPM();
        Parent rootPanel = new BMountainUI(model);
        Scene scene = new Scene(rootPanel);

        String stylesheet = getClass().getResource("resources/style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);


        primaryStage.setTitle("Mountains");
        primaryStage.setScene(scene);
        primaryStage.setMinHeight(800);
        primaryStage.setMinWidth(1000);

        primaryStage.setHeight(800);
        primaryStage.setWidth(1350);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
