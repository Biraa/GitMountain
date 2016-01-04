package ch.fhnw.oop;

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
    }

    private void initializeControls() {
        header = new Header(model);
        tabele = new Tabele(model);
        editor = new Editor(model);
    }

    private void layoutControls() {
        setTop(header);
        setCenter(addSplitePane());
    }

    public SplitPane addSplitePane() {
        SplitPane splitPane = new SplitPane();
        splitPane.setPrefSize(400, 200);
        splitPane.getItems().setAll(tabele, editor);
        splitPane.setDividerPositions(0.25);

        return splitPane;
    }

}
