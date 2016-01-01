package ch.fhnw.oop;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

/**
 * Created by Biraveen on 23.11.2015.
 */

public class MountainPM {
    private static final String FILE_NAME = "mountains.csv";

    private static final String TAB = ";";



    private final ObservableList<Resultat> resulate = FXCollections.observableArrayList();

    int i;
    int k;

    private final ObjectProperty<Resultat> selectedMountain = new SimpleObjectProperty<>();

    //UndoRedo
    private final ObservableList<Command> undoStack = FXCollections.observableArrayList();
    private final ObservableList<Command> redoStack = FXCollections.observableArrayList();

    //private final IntegerProperty selectedMountainId = new SimpleIntegerProperty(-1);
    private final IntegerProperty selectedMountainId = new SimpleIntegerProperty(-1);

    private final BooleanProperty undoDisabled = new SimpleBooleanProperty();
    private final BooleanProperty redoDisabled = new SimpleBooleanProperty();

    private final Resultat resultatProxy = new Resultat();

    private final ChangeListener propertyChangeListenerForUndoSupport = (observable, oldValue, newValue) -> {
        redoStack.clear();
        undoStack.add(0, new ValueChangeCommand(MountainPM.this, (Property) observable, oldValue, newValue));
    };



    public MountainPM() {
        //resulate.addAll(resultatList);
        resulate.addAll(readFromFile());

        i =resulate.size();
        k =resulate.size();

        undoDisabled.bind(Bindings.isEmpty(undoStack));
        redoDisabled.bind(Bindings.isEmpty(redoStack));

        //selectedMountainId.addListener((observable, oldValue, newValue) -> {
        selectedMountain.addListener((observable, oldSelection, newSelection) -> {
                    //Resultat oldSelection = resultatInt((int) oldValue);
                    //Resultat newSelection = resultatInt((int) newValue);

                    if (oldSelection != null) {
                        unbindFromProxy(oldSelection);
                        disableUndoSupport(oldSelection);
                    }

                    if (newSelection != null) {
                        bindToProxy(newSelection);
                        enableUndoSupport(newSelection);
                    }
                }

        );
        //setSelectedMountainId(0);
        this.setSelectedMountain(resulate.get(0));


        // selection changes are undoable
        selectedMountainProperty().addListener(propertyChangeListenerForUndoSupport);
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            return;
        }
        Command cmd = undoStack.get(0);
        undoStack.remove(0);
        redoStack.add(0, cmd);

        cmd.undo();
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            return;
        }
        Command cmd = redoStack.get(0);
        redoStack.remove(0);
        undoStack.add(0, cmd);

        cmd.redo();
    }


    public <T> void setPropertyValueWithoutUndoSupport(Property<T> property, T newValue){
        property.removeListener(propertyChangeListenerForUndoSupport);
        property.setValue(newValue);
        property.addListener(propertyChangeListenerForUndoSupport);
    }

    private Resultat resultatInt(int id) {
        Optional<Resultat> pmOptional = resulate.stream()
                .filter(resultat -> resultat.getBergId() == id)
                .findAny();
        return pmOptional.isPresent() ? pmOptional.get() : null;
    }

    private void disableUndoSupport(Resultat resultat) {
        resultat.heightProperty().removeListener(propertyChangeListenerForUndoSupport);
        resultat.nameProperty().removeListener(propertyChangeListenerForUndoSupport);
        resultat.cantonsProperty().removeListener(propertyChangeListenerForUndoSupport);
    }

    private void enableUndoSupport(Resultat resultat) {
        resultat.heightProperty().addListener(propertyChangeListenerForUndoSupport);
        resultat.nameProperty().addListener(propertyChangeListenerForUndoSupport);
        resultat.cantonsProperty().addListener(propertyChangeListenerForUndoSupport);
    }

    private void bindToProxy(Resultat resultat) {
        resultatProxy.heightProperty().bindBidirectional(resultat.heightProperty());
        resultatProxy.nameProperty().bindBidirectional(resultat.nameProperty());
        resultatProxy.cantonsProperty().bindBidirectional(resultat.cantonsProperty());
    }

    private void unbindFromProxy(Resultat resultat) {
        resultatProxy.heightProperty().unbindBidirectional(resultat.heightProperty());
        resultatProxy.nameProperty().unbindBidirectional(resultat.nameProperty());
        resultatProxy.cantonsProperty().unbindBidirectional(resultat.cantonsProperty());
    }



    //neue Liste für Suche

    FilteredList<Resultat> filteredData = new FilteredList<>(getResulate(), p -> true);


//    public MountainPM() {
//        resulate.addAll(readFromFile());
//
//    }

    private List<Resultat> readFromFile() {
        try (Stream<String> stream = getStreamOfLines(FILE_NAME)) {
            return stream.skip(1)                               // erste Zeile ist die Headerzeile; ueberspringen
                    .map(s -> new Resultat(s.split(TAB)))       // aus jeder Zeile ein Objekt machen
                    .collect(Collectors.toList());              // alles aufsammeln
        }
    }


    private Stream<String> getStreamOfLines(String fileName) {
        try {
            return Files.lines(getPath(fileName, true), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }


    private Path getPath(String fileName, boolean locatedInSameFolder) {
        try {
            if (!locatedInSameFolder) {
                fileName = "/" + fileName;
            }
            return Paths.get(getClass().getResource(fileName).toURI());
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void save() {
        try (BufferedWriter writer = Files.newBufferedWriter(getPath(FILE_NAME, true))) {
            writer.write("ID\tName\tGebiet\tKantone\tkmBis\tDominanz\tkanton\tmBis\tScherten\tName\tKantone\tGebiet\tBilbeschreibung");
            writer.newLine();
            resulate.stream().forEach(resultat -> {
                try {
                    writer.write(resultat.infoAsLine());
                    writer.newLine();
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            });
        } catch (IOException e) {
            throw new IllegalStateException("save failed");
        }
    }

    public void delete() {
        resulate.remove(selectedMountain.getValue());
        i--;
        undoStack.clear();
        redoStack.clear();
    }

    public void add() {
        //int i = resulate.size();
        //i++;
        Resultat r = new Resultat();
        r.setBergId(k++);

        resulate.add(i, r);

        undoStack.clear();
        redoStack.clear();

    }

    public void setFilterString(String newValue) {
        filteredData.setPredicate(mountain -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = newValue.toLowerCase();

            if (mountain.getName().toLowerCase().contains(lowerCaseFilter)) {
                System.out.println(mountain.getName());
                return true;
            } else {
                return false;
            }
        });
    }

    //Getter und Setter

    public ObservableList<Resultat> getResulate() {
        return resulate;
    }

    public Resultat getSelectedMountain() {
        return selectedMountain.get();
    }

    public ObjectProperty<Resultat> selectedMountainProperty() {
        return selectedMountain;
    }

    public void setSelectedMountain(Resultat selectedMountain) {
        this.selectedMountain.set(selectedMountain);
    }

    public FilteredList<Resultat> getFilteredData() {
        return filteredData;
    }

    public void setFilteredData(FilteredList<Resultat> filteredData) {
        this.filteredData = filteredData;
    }

    //UndoRedo

    public int getSelectedMountainId() {
        return selectedMountainId.get();
    }

    public IntegerProperty selectedMountainIdProperty() {
        return selectedMountainId;
    }

    public void setSelectedMountainId(int selectedMountainId) {
        this.selectedMountainId.set(selectedMountainId);
    }

    public Resultat getResultatProxy() {
        return resultatProxy;
    }

    public BooleanProperty undoDisabledProperty() {
        return undoDisabled;
    }

    public BooleanProperty redoDisabledProperty() {
        return redoDisabled;
    }


}
