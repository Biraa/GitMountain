package ch.fhnw.oop;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.util.converter.NumberStringConverter;

/**
 * Created by Biraveen on 29.11.2015.
 */
public class Editor extends GridPane {

    MountainPM model;

    public Editor(MountainPM model) {
        this.model = model;
        initializeControls();
        addValueChangedListeners();
        makeRightImageSize();
        makeColumRow();

    }

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

    private ImageView imageView1;

    private void initializeControls() {

        textField2 = new TextField();
        textField3 = new TextField();
        textField4 = new TextField();
        textField5 = new TextField();
        textField6 = new TextField();
        textField7 = new TextField();
        textField8 = new TextField();
        textField9 = new TextField();
        textField10 = new TextField();
        textField11 = new TextField();
        textField12 = new TextField();

        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label("Name");
        label5 = new Label("Dominanz");
        label6 = new Label("km bis");
        label7 = new Label("Typ");
        label8 = new Label("Kantone");
        label9 = new Label("Bildunterschrift");
        label10 = new Label("Höhe");
        label11 = new Label("Scharten");
        label12 = new Label("m bis");
        label13 = new Label("Region");
        label14 = new Label("Gebiet");

        imageView1 = new ImageView();


    }

    public void addValueChangedListeners() {
        model.selectedMountainProperty().addListener((observableValue, oldSelection, newSelection) -> {
            // unbind von allen Properties auf oldSelection
            //bind von allen Properties auf newSelection

            // z.B. für 'name'
            if (oldSelection != null) {
                label1.textProperty().unbindBidirectional(oldSelection.nameProperty());
                label2.textProperty().unbindBidirectional(oldSelection.heightProperty());
                label3.textProperty().unbindBidirectional(oldSelection.regionProperty());

                textField2.textProperty().unbindBidirectional(oldSelection.nameProperty());
                textField3.textProperty().unbindBidirectional(oldSelection.prominenceProperty());
                textField4.textProperty().unbindBidirectional(oldSelection.prominencePointProperty());
                textField5.textProperty().unbindBidirectional(oldSelection.typeProperty());
                textField6.textProperty().unbindBidirectional(oldSelection.cantonsProperty());
                textField7.textProperty().unbindBidirectional(oldSelection.captionProperty());
                textField8.textProperty().unbindBidirectional(oldSelection.heightProperty());
                textField9.textProperty().unbindBidirectional(oldSelection.isolationProperty());
                textField10.textProperty().unbindBidirectional(oldSelection.isolationPointProperty());
                textField11.textProperty().unbindBidirectional(oldSelection.regionProperty());
                textField12.textProperty().unbindBidirectional(oldSelection.rangeProperty());

                imageView1.imageProperty().unbindBidirectional(oldSelection.image1Property());


            }
            if (newSelection != null) {
                label1.textProperty().bindBidirectional(newSelection.nameProperty());
                label2.textProperty().bindBidirectional(newSelection.heightProperty(), new NumberStringConverter());
                label3.textProperty().bindBidirectional(newSelection.regionProperty());

                textField2.textProperty().bindBidirectional(newSelection.nameProperty());
                textField3.textProperty().bindBidirectional(newSelection.prominenceProperty(), new NumberStringConverter());
                textField4.textProperty().bindBidirectional(newSelection.prominencePointProperty());
                textField5.textProperty().bindBidirectional(newSelection.typeProperty());
                textField6.textProperty().bindBidirectional(newSelection.cantonsProperty());
                textField7.textProperty().bindBidirectional(newSelection.captionProperty());
                textField8.textProperty().bindBidirectional(newSelection.heightProperty(), new NumberStringConverter());
                textField9.textProperty().bindBidirectional(newSelection.isolationProperty(), new NumberStringConverter());
                textField10.textProperty().bindBidirectional(newSelection.isolationPointProperty());
                textField11.textProperty().bindBidirectional(newSelection.regionProperty());
                textField12.textProperty().bindBidirectional(newSelection.rangeProperty());

                imageView1.imageProperty().bindBidirectional(newSelection.image1Property());
            }
        });
    }

    public void makeColumRow() {
        ColumnConstraints cc = new ColumnConstraints(); //Spalte
        cc.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(cc, cc, cc, cc);

        RowConstraints rc = new RowConstraints(); //Zeile
        rc.setVgrow(Priority.ALWAYS);
        getRowConstraints().addAll(rc, rc, rc, rc, rc, rc, rc, rc, rc, rc, rc, rc);

        add(label1, 0, 0);
        add(label2, 0, 1);
        add(label3, 0, 2);
        add(label4, 0, 6);
        add(label5, 0, 7);
        add(label6, 0, 8);
        add(label7, 0, 9);
        add(label8, 0, 10);
        add(label9, 0, 11);
        add(label10, 2, 6);
        add(label11, 2, 7);
        add(label12, 2, 8);
        add(label13, 2, 9);
        add(label14, 2, 10);

        add(textField2, 1, 6);
        add(textField3, 1, 7);
        add(textField4, 1, 8);
        add(textField5, 1, 9);
        add(textField6, 1, 10);
        add(textField7, 1, 11, 3, 1);
        add(textField8, 3, 6);
        add(textField9, 3, 7);
        add(textField10, 3, 8);
        add(textField11, 3, 9);
        add(textField12, 3, 10);

        //add(addImageView(), 3, 0);
        add(imageView1, 3, 0);

        setPadding(new Insets(10, 10, 10, 10));
    }

    public void makeRightImageSize(){
        imageView1.setFitHeight(300);
        imageView1.setFitWidth(300);
        imageView1.isSmooth();
    }
    public ImageView addImageView() {
        int id;
        try {
            id = model.selectedMountainProperty().getValue().getBergId();
        }catch (NullPointerException e){
            id=1;
        }
        Image image = new Image("ch/fhnw/oop/mountainpictures/"+id+"-1.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(220);
        //imageView.setFitHeight(220);
        imageView.setPreserveRatio(true);
        //imageView.setCache(true);

        return imageView;
    }

//    public ImageView addImageView(MountainPM model) {
//        //String foto = model.;
//        Image image = new Image("ch/fhnw/oop/resources/bmw.jpg");
//        ImageView imageView = new ImageView(image);
//        imageView.setFitWidth(220);
//        //imageView.setFitHeight(220);
//        imageView.setPreserveRatio(true);
//        //imageView.setCache(true);
//
//        return imageView;
//    }



}
