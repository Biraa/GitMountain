package ch.fhnw.oop;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * Created by Biraveen on 23.11.2015.
 */
public class TableViewUI extends VBox {
    private final MountainPM model;

    private TableView<Resultat> tabelle;


    public TableViewUI(MountainPM model) {
        this.model = model;
        initializeControls();
        layoutControls();
        addEventHandlers();
        addValueChangedListeners();
        addBindings();
    }

    public void initializeControls() {
        tabelle = initializeResultatTabelle();
    }

    private TableView<Resultat> initializeResultatTabelle() {
        TableView<Resultat> tableView = new TableView<>(model.getResulate());

        TableColumn<Resultat, String> idCol = new TableColumn<>("id");
        TableColumn<Resultat, String> nameCol = new TableColumn<>("name");
        TableColumn<Resultat, String> heightCol = new TableColumn<>("Höhe");

        idCol.setCellValueFactory(cell -> cell.getValue().idProperty());
        nameCol.setCellValueFactory(cell -> cell.getValue().nameProperty());
        heightCol.setCellValueFactory(cell -> cell.getValue().heightProperty());

        tableView.getColumns().addAll(idCol, nameCol, heightCol);

        return tableView;
    }

    public void layoutControls() {
        setVgrow(tabelle, Priority.ALWAYS);

        getChildren().addAll(tabelle);
    }

    private void addEventHandlers() {
    }

    private void addValueChangedListeners() {
    }

    public void addBindings() {
    }

}
