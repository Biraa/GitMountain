package ch.fhnw.oop;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

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
    private Button button7;

    private TextField textField1;


    public Header(MountainPM model) {
        this.model = model;
        initializeControls();
        initializeFilter();
        makeColumRow();
        eventEvent();
    }

    private void initializeControls() {
        button1 = new Button("save");
        button2 = new Button("add");
        button3 = new Button("delete");
        button4 = new Button("Undo");
        button5 = new Button("Redo");
        button6 = new Button("6");
        button7 = new Button("7");

        textField1 = new TextField("Suche");


    }

    private void initializeFilter(){

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
        hBox.getChildren().addAll(button1, button2, button3, button4, button5);
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
    }

}
