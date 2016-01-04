package ch.fhnw.oop;

import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


/**
 * Created by Biraveen on 01.12.2015.
 */
public class Header extends GridPane {

    MountainPM model;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;


    Image icon1;
    Image icon2;
    Image icon3;
    Image icon4;
    Image icon5;
    Image icon6;


    private TextField textField1;


    public Header(MountainPM model) {
        this.model = model;
        initializeControls();
        initializeFilter();
        makeColumRow();
        eventEvent();
        addBindings();
    }

    private void initializeControls() {
        icon1 = new Image("ch/fhnw/oop/icons/save.png");
        ImageView imageView1 = new ImageView(icon1);
        button1 = new Button("", imageView1);
        button1.setId("save");
        button1.setTooltip(new Tooltip("save"));

        icon2 = new Image("ch/fhnw/oop/icons/add.png");
        ImageView imageView2 = new ImageView(icon2);
        button2 = new Button("", imageView2);
        button2.setId("add");
        button2.setTooltip(new Tooltip("add"));

        icon3 = new Image("ch/fhnw/oop/icons/delete.png");
        ImageView imageView3 = new ImageView(icon3);
        button3 = new Button("", imageView3);
        button3.setId("delete");
        button3.setTooltip(new Tooltip("delete"));

        icon4 = new Image("ch/fhnw/oop/icons/undo.png");
        ImageView imageView4 = new ImageView(icon4);
        button4 = new Button("", imageView4);
        button4.setId("undo");
        button4.setTooltip(new Tooltip("undo"));

        icon5 = new Image("ch/fhnw/oop/icons/redo.png");
        ImageView imageView5 = new ImageView(icon5);
        button5 = new Button("", imageView5);
        button5.setId("redo");
        button5.setTooltip(new Tooltip("redo"));

        icon6 = new Image("ch/fhnw/oop/icons/maps.png");
        ImageView imageView6 = new ImageView(icon6);
        imageView6.setFitHeight(48);
        imageView6.setFitWidth(53);
        button6 = new Button("", imageView6);
        button6.setId("maps");
        button6.setTooltip(new Tooltip("Google Maps"));

        textField1 = new TextField("Suche");


    }

    private void initializeFilter() {

        textField1.textProperty().addListener((observable, oldValue, newValue) -> {
            model.setFilterString(newValue);
        });

    }


    public void makeColumRow() {
        ColumnConstraints cc = new ColumnConstraints(); //Spalte
        cc.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(cc, cc);

        RowConstraints rc = new RowConstraints(); //Zeile
        rc.setVgrow(Priority.ALWAYS);
        getRowConstraints().addAll(rc);

        add(addHbox1(), 0, 0);
        add(addHbox2(), 1, 0);
    }

    public HBox addHbox1() {
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(5);
        hBox.getChildren().addAll(button1, button2, button3, button4, button5, button6);
        return hBox;
    }

    public HBox addHbox2() {
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(5);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().addAll(textField1);
        return hBox;
    }

    private void eventEvent() {
        button1.setOnAction(event -> model.save());
        button3.setOnAction(event -> model.delete());
        button2.setOnAction(event -> model.add());

        //UndoRedo
        button4.setOnAction(event -> model.undo());
        button5.setOnAction(event -> model.redo());

        //Google Maps
        button6.setOnAction(event -> {

            String name = model.getSelectedMountain().getName();

            final WebView browser = new WebView();
            final WebEngine webEngine = browser.getEngine();
            webEngine.load("https://www.google.ch/maps/search/" + name);

            StackPane secondaryLayout = new StackPane();
            secondaryLayout.getChildren().add(browser);

            Scene secondScene = new Scene(secondaryLayout, 1000, 600);

            Stage secondStage = new Stage();
            secondStage.setTitle("Second Stage");
            secondStage.setScene(secondScene);

            secondStage.show();
        });
    }

    public void addBindings() {
        button4.disableProperty().bind(model.undoDisabledProperty());
        button5.disableProperty().bind(model.redoDisabledProperty());
    }
}
