package ch.fhnw.oop;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Biraveen on 23.11.2015.
 */
public class MountainPM {
    private static final String FILE_NAME = "mountains.csv";

    private static final String TAB = ";";

    private final ObservableList<Resultat> resulate = FXCollections.observableArrayList();

    private final ObjectProperty<Resultat> selectedMountain = new SimpleObjectProperty<>();

    public MountainPM() {
        resulate.addAll(readFromFile());

    }

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

    public void delete(){
        resulate.remove(selectedMountain.getValue());
    }

    public void add(){
        int i = resulate.size();
        Resultat r = new Resultat();
        r.setBergId(i);
        resulate.add(i, r);
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

}
