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

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Biraveen on 23.11.2015.
 */
public class MountainPM {
    private static final String FILE_NAME = "mountains.csv";

    private static final String TAB = ";";

    private final ObservableList<Resultat> resulate = FXCollections.observableArrayList();

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


    public ObservableList<Resultat> getResulate() {
        return resulate;
    }

}
