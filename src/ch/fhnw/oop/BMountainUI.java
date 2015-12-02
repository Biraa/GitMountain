package ch.fhnw.oop;


import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class BMountainUI extends BorderPane {

//    private Button button1;
//    private Button button2;
//    private Button button3;
//    private Button button4;
//    private Button button5;
//    private Button button6;
//    private Button button7;
//
//    private TextField textField1;
//    private TextField textField2;
//    private TextField textField3;
//    private TextField textField4;
//    private TextField textField5;
//    private TextField textField6;
//    private TextField textField7;
//    private TextField textField8;
//    private TextField textField9;
//    private TextField textField10;
//    private TextField textField11;
//    private TextField textField12;
//
//    private Label label1;
//    private Label label2;
//    private Label label3;
//    private Label label4;
//    private Label label5;
//    private Label label6;
//    private Label label7;
//    private Label label8;
//    private Label label9;
//    private Label label10;
//    private Label label11;
//    private Label label12;
//    private Label label13;
//    private Label label14;

    MountainPM model;
    Editor editor;
    Tabele tabele;
    Header header;

    public BMountainUI( MountainPM model) {
        this.model = model;
        initializeControls();
        layoutControls();
        //eventEvent();
    }

    private void initializeControls() {
        header = new Header(model);
        tabele = new Tabele(model);
        editor = new Editor(model);
    }

//    private void initializeControls() {
//        button1=new Button("save");
//        button2=new Button("add");
//        button3=new Button("delete");
//        button4=new Button("left");
//        button5=new Button("right");
//        button6=new Button("6");
//        button7=new Button("7");
//
//        textField1=new TextField("Suche");
//        textField2=new TextField();
//        textField3=new TextField();
//        textField4=new TextField();
//        textField5=new TextField();
//        textField6=new TextField();
//        textField7=new TextField();
//        textField8=new TextField();
//        textField9=new TextField();
//        textField10=new TextField();
//        textField11=new TextField();
//        textField12=new TextField();
//
//        label1=new Label();
//        label2=new Label();
//        label3=new Label();
//        label4=new Label("Name");
//        label5=new Label("Dominanz");
//        label6=new Label("km bis");
//        label7=new Label("Typ");
//        label8=new Label("Kantone");
//        label9=new Label("Bildunterschrift");
//        label10=new Label("Höhe");
//        label11=new Label("Scharten");
//        label12=new Label("m bis");
//        label13=new Label("Region");
//        label14 = new Label("Gebiet");
//
//    }
    private void layoutControls(){
        //setTop(addHbox());
        //setTop(addGridPane1());
        //setTop(new Header(model));
        setTop(header);
        setCenter(addSplitePane());
    }

//    public HBox addHbox1(){
//        HBox hBox = new HBox();
//        hBox.setPadding(new Insets(10));
//        hBox.setSpacing(5);
//
//        hBox.getChildren().addAll(edit.getButton1(),edit.getButton2(),edit.getButton3(),edit.getButton4(),edit.getButton5());
//        return hBox;
//    }
//
//    public HBox addHbox2(){
//        HBox hBox = new HBox();
//        hBox.setPadding(new Insets(10));
//        hBox.setSpacing(5);
//        hBox.setAlignment(Pos.BOTTOM_RIGHT);
//
//        hBox.getChildren().addAll(edit.getTextField1());
//        return hBox;
//    }


    public SplitPane addSplitePane(){
        SplitPane splitPane = new SplitPane();
        //splitPane.setOrientation(Orientation.HORIZONTAL);
        splitPane.setPrefSize(400,200);
        //splitPane.getItems().setAll(addSLVA(), addGridPane2());
        //splitPane.getItems().setAll(addTableView(), addGridPane2());

        //splitPane.getItems().setAll(new Tabele(model), addGridPane2());
        splitPane.getItems().setAll(tabele, editor);
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

//    public void addTableView2(){

//        //MountainPM model= new MountainPM();
//        //TableView<Resultat> tableView = new TableView<>(model.getResulate());
//
//        TableColumn<Resultat, Number> idCol = new TableColumn<>("id");
//        idCol.setCellValueFactory(cell -> cell.getValue().bergIdProperty());
//
//        TableColumn<Resultat, String> nameCol = new TableColumn<>("name");
//        nameCol.setCellValueFactory(cell -> cell.getValue().nameProperty());
//
//        TableColumn<Resultat, Number> heightCol = new TableColumn<>("Höhe");
//        heightCol.setCellValueFactory(cell -> cell.getValue().heightProperty());
//
//
//        tableView.getColumns().addAll(idCol, nameCol, heightCol);
//
//        return tableView;

//        return new Tabele(model).makeTableView();


//    }


//    public GridPane addGridPane1(){
//        GridPane gridPane = new GridPane();
//
//        ColumnConstraints cc = new ColumnConstraints(); //Spalte
//        cc.setHgrow(Priority.ALWAYS);
//        gridPane.getColumnConstraints().addAll(cc,cc);
//
//        RowConstraints rc = new RowConstraints(); //Zeile
//        rc.setVgrow(Priority.ALWAYS);
//        gridPane.getRowConstraints().addAll(rc);
//
//        gridPane.add(addHbox1(),0,0);
//        gridPane.add(addHbox2(),1,0);
//
//        return gridPane;
//
//    }

//    public ImageView addImageView(){
//        Image image = new Image("ch/fhnw/oop/resources/bmw.jpg");
//        ImageView imageView = new ImageView(image);
//        imageView.setFitWidth(220);
//        //imageView.setFitHeight(220);
//        imageView.setPreserveRatio(true);
//        //imageView.setCache(true);
//
//        return imageView;
//    }

//    public GridPane addGridPane2(){
//        GridPane gridPane = new GridPane();
//
//        ColumnConstraints cc = new ColumnConstraints(); //Spalte
//        cc.setHgrow(Priority.ALWAYS);
//        gridPane.getColumnConstraints().addAll(cc,cc,cc,cc);
//
//        RowConstraints rc = new RowConstraints(); //Zeile
//        rc.setVgrow(Priority.ALWAYS);
//        gridPane.getRowConstraints().addAll(rc,rc,rc,rc,rc,rc,rc,rc,rc,rc,rc,rc);
//
//        gridPane.add(edit.getLabel1(), 0, 0);
//        gridPane.add(edit.getLabel2(), 0, 1);
//        gridPane.add(edit.getLabel3(), 0, 2);
//        gridPane.add(edit.getLabel4(), 0, 6);
//        gridPane.add(edit.getLabel5(), 0, 7);
//        gridPane.add(edit.getLabel6(), 0, 8);
//        gridPane.add(edit.getLabel7(), 0, 9);
//        gridPane.add(edit.getLabel8(), 0, 10);
//        gridPane.add(edit.getLabel9(), 0, 11);
//        gridPane.add(edit.getLabel10(), 2, 6);
//        gridPane.add(edit.getLabel11(), 2, 7);
//        gridPane.add(edit.getLabel12(), 2, 8);
//        gridPane.add(edit.getLabel13(), 2, 9);
//        gridPane.add(edit.getLabel14(), 2, 10);
//
//        gridPane.add(edit.getTextField2(), 1 ,6);
//        gridPane.add(edit.getTextField3(), 1, 7);
//        gridPane.add(edit.getTextField4(), 1, 8);
//        gridPane.add(edit.getTextField5(), 1, 9);
//        gridPane.add(edit.getTextField6(), 1, 10);
//        gridPane.add(edit.getTextField7(), 1, 11, 3, 1);
//        gridPane.add(edit.getTextField8(), 3, 6);
//        gridPane.add(edit.getTextField9(), 3, 7);
//        gridPane.add(edit.getTextField10(), 3, 8);
//        gridPane.add(edit.getTextField11(), 3, 9);
//        gridPane.add(edit.getTextField12(), 3, 10);
//
//        gridPane.add(addImageView(), 3,  0);
//
//        gridPane.setPadding(new Insets(10,10,10,10));
//
//        return gridPane;
//
//    }

//    private void eventEvent(){
//        tableView.setOnMouseClicked(event -> {
//            label1.textProperty().bindBidirectional(tableView.getSelectionModel().getSelectedItem().nameProperty());
//            label2.textProperty().bindBidirectional(tableView.getSelectionModel().getSelectedItem().heightProperty(), new NumberStringConverter());
//            label3.textProperty().bindBidirectional(tableView.getSelectionModel().getSelectedItem().regionProperty());
//            textField2.textProperty().bindBidirectional(tableView.getSelectionModel().getSelectedItem().nameProperty());
//            textField3.textProperty().bindBidirectional(tableView.getSelectionModel().getSelectedItem().prominenceProperty(), new NumberStringConverter());
//            textField4.textProperty().bindBidirectional(tableView.getSelectionModel().getSelectedItem().prominencePointProperty());
//            textField5.textProperty().bindBidirectional(tableView.getSelectionModel().getSelectedItem().typeProperty());
//            textField6.textProperty().bindBidirectional(tableView.getSelectionModel().getSelectedItem().cantonsProperty());
//            textField7.textProperty().bindBidirectional(tableView.getSelectionModel().getSelectedItem().captionProperty());
//            textField8.textProperty().bindBidirectional(tableView.getSelectionModel().getSelectedItem().heightProperty(), new NumberStringConverter());
//            textField9.textProperty().bindBidirectional(tableView.getSelectionModel().getSelectedItem().isolationProperty(), new NumberStringConverter());
//            textField10.textProperty().bindBidirectional(tableView.getSelectionModel().getSelectedItem().isolationPointProperty());
//            textField11.textProperty().bindBidirectional(tableView.getSelectionModel().getSelectedItem().regionProperty());
//            textField12.textProperty().bindBidirectional(tableView.getSelectionModel().getSelectedItem().rangeProperty());
//
//        });
//
//    }

}
