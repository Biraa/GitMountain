package ch.fhnw.oop;


import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class BMountainUI extends BorderPane {

    MountainPM model;
    Editor editor;
    Tabele tabele;
    Header header;

    public BMountainUI(MountainPM model) {
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

    private void layoutControls() {
        //setTop(addHbox());
        //setTop(addGridPane1());
        //setTop(new Header(model));
        setTop(header);
        setCenter(addSplitePane());
    }

    public SplitPane addSplitePane() {
        SplitPane splitPane = new SplitPane();
        //splitPane.setOrientation(Orientation.HORIZONTAL);
        splitPane.setPrefSize(400, 200);
        splitPane.getItems().setAll(tabele, editor);
        splitPane.setDividerPositions(0.25);

        return splitPane;
    }

    public ListView addSLVA() { //SimpelListViewApp
        ListView<String> listView = new ListView<>();


        listView.setItems(FXCollections.observableArrayList(
                        "Row 1", "Row 2", "Long Row 3", "Row 4", "Row 5", "Row 6",
                        "Row 7", "Row 8", "Row 9", "Row 10", "Row 11", "Row 12", "Row 13",
                        "Row 14", "Row 15", "Row 16", "Row 17", "Row 18", "Row 19", "Row 20")
        );

        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        return listView;

    }

    public TableView addTableView() {
        TableView table = new TableView();
        table.setEditable(true);

        TableColumn id = new TableColumn("ID");
        TableColumn name = new TableColumn("Name");
        TableColumn hoehe = new TableColumn("Höhe");

        id.setMinWidth(100);
        name.setMinWidth(100);
        hoehe.setMinWidth(100);

        table.getColumns().addAll(id, name, hoehe);

        return table;

    }

}
