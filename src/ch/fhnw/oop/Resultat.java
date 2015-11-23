package ch.fhnw.oop;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Biraveen on 23.11.2015.
 */
public class Resultat {
    private final StringProperty id                 = new SimpleStringProperty();
    private final StringProperty name               = new SimpleStringProperty();
    private final StringProperty height             = new SimpleStringProperty();
    private final StringProperty type               = new SimpleStringProperty();
    private final StringProperty region             = new SimpleStringProperty();
    private final StringProperty range              = new SimpleStringProperty();
    private final StringProperty isolation          = new SimpleStringProperty();
    private final StringProperty isolationPoint     = new SimpleStringProperty();
    private final StringProperty prominence         = new SimpleStringProperty();
    private final StringProperty prominencePoint    = new SimpleStringProperty();
    private final StringProperty caption            = new SimpleStringProperty();


    public Resultat(String[] line) {
        setId(line[0]);
        setName(line[1]);
        setHeight(line[2]);
        setType(line[3]);
        setRegion(line[4]);
        setRange(line[5]);
        setIsolation(line[6]);
        setIsolationPoint(line[7]);
        setProminence(line[8]);
        setIsolationPoint(line[9]);
        setCaption(line[10]);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Resultat resultat = (Resultat) o;

        return getId().equals(resultat.getId());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public String infoAsLine(){
        return String.join("\t",
                getId(),
                getName(),
                getHeight(),
                getType(),
                getRegion(),
                getRange(),
                getIsolation(),
                getIsolationPoint(),
                getProminence(),
                getIsolationPoint(),
                getCaption()
        );
    }


    @Override
    public String toString() {
        return infoAsLine();
    }


    //Getter Und Setter

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getHeight() {
        return height.get();
    }

    public StringProperty heightProperty() {
        return height;
    }

    public void setHeight(String height) {
        this.height.set(height);
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getRange() {
        return range.get();
    }

    public StringProperty rangeProperty() {
        return range;
    }

    public void setRange(String range) {
        this.range.set(range);
    }

    public String getRegion() {
        return region.get();
    }

    public StringProperty regionProperty() {
        return region;
    }

    public void setRegion(String region) {
        this.region.set(region);
    }

    public String getIsolation() {
        return isolation.get();
    }

    public StringProperty isolationProperty() {
        return isolation;
    }

    public void setIsolation(String isolation) {
        this.isolation.set(isolation);
    }

    public String getIsolationPoint() {
        return isolationPoint.get();
    }

    public StringProperty isolationPointProperty() {
        return isolationPoint;
    }

    public void setIsolationPoint(String isolationPoint) {
        this.isolationPoint.set(isolationPoint);
    }

    public String getProminence() {
        return prominence.get();
    }

    public StringProperty prominenceProperty() {
        return prominence;
    }

    public void setProminence(String prominence) {
        this.prominence.set(prominence);
    }

    public String getProminencePoint() {
        return prominencePoint.get();
    }

    public StringProperty prominencePointProperty() {
        return prominencePoint;
    }

    public void setProminencePoint(String prominencePoint) {
        this.prominencePoint.set(prominencePoint);
    }

    public String getCaption() {
        return caption.get();
    }

    public StringProperty captionProperty() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption.set(caption);
    }
}

