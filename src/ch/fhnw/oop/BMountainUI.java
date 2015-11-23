package ch.fhnw.oop;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class BMountainUI extends BorderPane {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;

    private TextField textField1;
    private TextField textField2;
    private TextField textField3;
    private TextField textField4;
    private TextField textField5;
    private TextField textField6;
    private TextField textField7;
    private TextField textField8;
    private TextField textField9;
    private TextField textField10;
    private TextField textField11;
    private TextField textField12;

    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;
    private Label label5;
    private Label label6;
    private Label label7;
    private Label label8;
    private Label label9;
    private Label label10;
    private Label label11;
    private Label label12;
    private Label label13;
    private Label label14;


    public BMountainUI() {
        initializeControls();
        layoutControls();
        eventEvent();
    }

    private void initializeControls() {
        button1=new Button("save");
        button2=new Button("add");
        button3=new Button("delete");
        button4=new Button("left");
        button5=new Button("right");
        button6=new Button("6");
        button7=new Button("7");

        textField1=new TextField("Suche");
        textField2=new TextField("1");
        textField3=new TextField("2");
        textField4=new TextField("3");
        textField5=new TextField("4");
        textField6=new TextField("5");
        textField7=new TextField("6");
        textField8=new TextField("7");
        textField9=new TextField("8");
        textField10=new TextField("9");
        textField11=new TextField("10");
        textField12=new TextField("11");

        label1=new Label("Alpentürm");
        label2=new Label("2022.00m");
        label3=new Label("Alpstein");
        label4=new Label("Name");
        label5=new Label("Dominanz");
        label6=new Label("km bis");
        label7=new Label("Typ");
        label8=new Label("Kantone");
        label9=new Label("Bildunterschrift");
        label10=new Label("Höhe");
        label11=new Label("Scharten");
        label12=new Label("m bis");
        label13=new Label("Region");
        label14=new Label("Gebiet");

    }
    private void layoutControls(){
        //setTop(addHbox());
        setTop(addGridPane1());
        setCenter(addSplitePane());
    }

    public HBox addHbox1(){
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(5);

        hBox.getChildren().addAll(button1,button2,button3,button4,button5);
        return hBox;
    }

    public HBox addHbox2(){
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(5);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);

        hBox.getChildren().addAll(textField1);
        return hBox;
    }

    public SplitPane addSplitePane(){
        SplitPane splitPane = new SplitPane();
        //splitPane.setOrientation(Orientation.HORIZONTAL);
        splitPane.setPrefSize(400,200);
        //splitPane.getItems().setAll(addSLVA(), addGridPane2());
        splitPane.getItems().setAll(addTableView(), addGridPane2());
        splitPane.setDividerPositions(0.25);

        return splitPane;
    }

    public ListView addSLVA(){ //SimpelListViewApp
        ListView<String> listView = new ListView<>();


        listView.setItems(FXCollections.observableArrayList(
                        "Row 1", "Row 2", "Long Row 3", "Row 4", "Row 5", "Row 6",
                        "Row 7", "Row 8", "Row 9", "Row 10", "Row 11", "Row 12", "Row 13",
                        "Row 14", "Row 15", "Row 16", "Row 17", "Row 18", "Row 19", "Row 20")
        );

        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        return listView;

    }

    public TableView addTableView(){
        TableView table = new TableView();
        table.setEditable(true);

        TableColumn id = new TableColumn("ID");
        TableColumn name = new TableColumn("Name");
        TableColumn hoehe = new TableColumn("Höhe");

        id.setMinWidth(100);
        name.setMinWidth(100);
        hoehe.setMinWidth(100);

        table.getColumns().addAll(id, name,hoehe);

        return table;

    }


    public GridPane addGridPane1(){
        GridPane gridPane = new GridPane();

        ColumnConstraints cc = new ColumnConstraints(); //Spalte
        cc.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(cc,cc);

        RowConstraints rc = new RowConstraints(); //Zeile
        rc.setVgrow(Priority.ALWAYS);
        gridPane.getRowConstraints().addAll(rc);

        gridPane.add(addHbox1(),0,0);
        gridPane.add(addHbox2(),1,0);

        return gridPane;

    }

    public ImageView addImageView(){
        Image image = new Image("ch/fhnw/oop/resources/bmw.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(220);
        //imageView.setFitHeight(220);
        imageView.setPreserveRatio(true);
        //imageView.setCache(true);

        return imageView;
    }

    public GridPane addGridPane2(){
        GridPane gridPane = new GridPane();

        ColumnConstraints cc = new ColumnConstraints(); //Spalte
        cc.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(cc,cc,cc,cc);

        RowConstraints rc = new RowConstraints(); //Zeile
        rc.setVgrow(Priority.ALWAYS);
        gridPane.getRowConstraints().addAll(rc,rc,rc,rc,rc,rc,rc,rc,rc,rc,rc,rc);

        gridPane.add(label1, 0, 0);
        gridPane.add(label2, 0, 1);
        gridPane.add(label3, 0, 2);
        gridPane.add(label4, 0, 6);
        gridPane.add(label5, 0, 7);
        gridPane.add(label6, 0, 8);
        gridPane.add(label7, 0, 9);
        gridPane.add(label8, 0, 10);
        gridPane.add(label9, 0, 11);
        gridPane.add(label10, 2, 6);
        gridPane.add(label11, 2, 7);
        gridPane.add(label12, 2, 8);
        gridPane.add(label13, 2, 9);
        gridPane.add(label14, 2, 10);

        gridPane.add(textField2, 1 ,6);
        gridPane.add(textField3, 1, 7);
        gridPane.add(textField4, 1, 8);
        gridPane.add(textField5, 1, 9);
        gridPane.add(textField6, 1, 10);
        gridPane.add(textField7, 1, 11, 3, 1);
        gridPane.add(textField8, 3, 6);
        gridPane.add(textField9, 3, 7);
        gridPane.add(textField10, 3, 8);
        gridPane.add(textField11, 3, 9);
        gridPane.add(textField12, 3, 10);

        gridPane.add(addImageView(), 3,  0);

        gridPane.setPadding(new Insets(10,10,10,10));

        return gridPane;

    }

    private void eventEvent(){

    }
}
