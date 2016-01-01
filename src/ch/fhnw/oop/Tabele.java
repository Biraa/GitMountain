package ch.fhnw.oop;

import javafx.beans.property.ObjectProperty;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by Biraveen on 29.11.2015.
 */
public class Tabele extends TableView<Resultat> {
    MountainPM model;

    public Tabele(MountainPM model) {
        this.model = model;

        makeTableView();
        select();
        //setPrefWidth(500);
    }


    private void makeTableView() {

        //setItems(model.getResulate());

        //setItems(model.getFilteredData());


        //TableView<Resultat> tableView = new TableView<>(model.getResulate()); ES IST REDUNDANT WEIL TABELE VOM TABLEVIEW ERBT!!!

        TableColumn<Resultat, Number> idCol = new TableColumn<>("id");
        idCol.setPrefWidth(50);
        idCol.setCellValueFactory(cell -> cell.getValue().bergIdProperty());

        TableColumn<Resultat, String> nameCol = new TableColumn<>("name");
        nameCol.setPrefWidth(200);
        nameCol.setCellValueFactory(cell -> cell.getValue().nameProperty());

        TableColumn<Resultat, Number> heightCol = new TableColumn<>("Höhe");
        heightCol.setPrefWidth(100);
        heightCol.setCellValueFactory(cell -> cell.getValue().heightProperty());

        TableColumn<Resultat, String> cantonsCol = new TableColumn<>("Kanton");
        cantonsCol.setPrefWidth(50);
        cantonsCol.setCellValueFactory(cell -> cell.getValue().cantonsProperty());


        cantonsCol.setCellFactory(cell -> new TabelCell());

        getColumns().addAll(idCol, nameCol, heightCol, cantonsCol);

        SortedList<Resultat> sortedList = new SortedList<>(model.getFilteredData());
        sortedList.comparatorProperty().bind(comparatorProperty());

        setItems(sortedList);

  }


//    public void select2(){
//        model.selectedMountainProperty().addListener(
//                (observable, oldSelection, newSelection) -> selectionModelProperty().setValue());
//    }


    public void select() {
        getSelectionModel().selectedItemProperty().addListener(
                (observable, oldSelection, newSelection) -> model.setSelectedMountain(newSelection));


//        getSelectionModel().selectedItemProperty().addListener(
//                (observable, oldSelection, newSelection) -> {
//                    try {
//                        model.setSelectedMountainId(newSelection.getBergId());
//                    } catch (NullPointerException e) {
//
//                    }
//                });
    }

//    public void select() {
//        getSelectionModel().selectedItemProperty().addListener(
//                (observable, oldSelection, newSelection) -> model.setSelectedMountain(newSelection));
//
//
//        getSelectionModel().selectedItemProperty().addListener(
//                (observable, oldSelection, newSelection) -> {
//                    if (newSelection == null) {
//                        model.setSelectedMountainId(1);
//                    } else {
//                        model.setSelectedMountainId(newSelection.getBergId());
//                    }
//                }
//        );
//    }




    @Override
    public void scrollTo(Resultat object) {
        super.scrollTo(model.getResulate().size());
    }
}
