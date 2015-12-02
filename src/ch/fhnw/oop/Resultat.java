package ch.fhnw.oop;

import javafx.beans.property.*;

/**
 * Created by Biraveen on 23.11.2015.
 */
public class Resultat {
    private final IntegerProperty bergId            = new SimpleIntegerProperty();
    private final StringProperty name               = new SimpleStringProperty();
    private final DoubleProperty height             = new SimpleDoubleProperty();
    private final StringProperty type               = new SimpleStringProperty();
    private final StringProperty region             = new SimpleStringProperty();
    private final StringProperty cantons            = new SimpleStringProperty();
    private final StringProperty range              = new SimpleStringProperty();
    private final DoubleProperty isolation          = new SimpleDoubleProperty();
    private final StringProperty isolationPoint     = new SimpleStringProperty();
    private final DoubleProperty prominence         = new SimpleDoubleProperty();
    private final StringProperty prominencePoint    = new SimpleStringProperty();
    private final StringProperty caption            = new SimpleStringProperty();


    public Resultat(String[] line) {
        setBergId(Integer.parseInt(line[0]));
        setName(line[1]);
        setHeight(Double.parseDouble(line[2]));
        setType(line[3]);
        setRegion(line[4]);
        setCantons(line[5]);
        setRange(line[6]);
        setIsolation(Double.parseDouble(line[7]));
        setIsolationPoint(line[8]);
        setProminence(Double.parseDouble(line[9]));
        setProminencePoint(line[10]);
        setCaption(line[11]);
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

        return getBergId()==(resultat.getBergId());
    }

    @Override
    public int hashCode() {
        return bergId.hashCode();
    }

    public String infoAsLine(){
        return String.join(";",
                Integer.toString(getBergId()),
                getName(),
                Double.toString(getHeight()),
                getType(),
                getRegion(),
                getCantons(),
                getRange(),
                Double.toString(getIsolation()),
                getIsolationPoint(),
                Double.toString(getProminence()),
                getProminencePoint(),
                getCaption()
        );
    }


    @Override
    public String toString() {
        return infoAsLine();
    }


    //Getter Und Setter

    public double getIsolation() {
        return isolation.get();
    }

    public DoubleProperty isolationProperty() {
        return isolation;
    }

    public void setIsolation(double isolation) {
        this.isolation.set(isolation);
    }

    public int getBergId() {
        return bergId.get();
    }

    public IntegerProperty bergIdProperty() {
        return bergId;
    }

    public void setBergId(int bergId) {
        this.bergId.set(bergId);
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

    public double getHeight() {
        return height.get();
    }

    public DoubleProperty heightProperty() {
        return height;
    }

    public void setHeight(double height) {
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

    public String getRegion() {
        return region.get();
    }

    public StringProperty regionProperty() {
        return region;
    }

    public void setRegion(String region) {
        this.region.set(region);
    }

    public String getCantons() {
        return cantons.get();
    }

    public StringProperty cantonsProperty() {
        return cantons;
    }

    public void setCantons(String cantons) {
        this.cantons.set(cantons);
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

    public String getIsolationPoint() {
        return isolationPoint.get();
    }

    public StringProperty isolationPointProperty() {
        return isolationPoint;
    }

    public void setIsolationPoint(String isolationPoint) {
        this.isolationPoint.set(isolationPoint);
    }

    public double getProminence() {
        return prominence.get();
    }

    public DoubleProperty prominenceProperty() {
        return prominence;
    }

    public void setProminence(double prominence) {
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

