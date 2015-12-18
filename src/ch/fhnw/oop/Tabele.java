package ch.fhnw.oop;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by Biraveen on 29.11.2015.
 */
public class Tabele extends TableView<Resultat> {
    MountainPM model;

    public Tabele(MountainPM model) {
        this.model = model;
        select();
        makeTableView();
    }



    private void makeTableView() {

        //setItems(model.getResulate());

        setItems(model.getFilteredData());

        //TableView<Resultat> tableView = new TableView<>(model.getResulate()); ES IST REDUNDANT WEIL TABELE VOM TABLEVIEW ERBT!!!

        TableColumn<Resultat, Number> idCol = new TableColumn<>("id");
        idCol.setCellValueFactory(cell -> cell.getValue().bergIdProperty());

        TableColumn<Resultat, String> nameCol = new TableColumn<>("name");
        nameCol.setCellValueFactory(cell -> cell.getValue().nameProperty());

        TableColumn<Resultat, Number> heightCol = new TableColumn<>("Höhe");
        heightCol.setCellValueFactory(cell -> cell.getValue().heightProperty());

        TableColumn<Resultat, String> cantonsCol = new TableColumn<>("Kanton");
        cantonsCol.setCellValueFactory(cell -> cell.getValue().cantonsProperty());


        cantonsCol.setCellFactory(cell -> new TabelCell());

        getColumns().addAll(idCol, nameCol, heightCol, cantonsCol);

    }


    public void select() {
        getSelectionModel().selectedItemProperty().addListener(
                (observable, oldSelection, newSelection) -> model.setSelectedMountain(newSelection));
    }

    @Override
    public void scrollTo(Resultat object) {
        super.scrollTo(model.getResulate().size());
    }
}
