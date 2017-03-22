package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by clbmi on 18/03/2017.
 */
public class Data {

    public static ObservableSet<StopPoint> stopPoints = FXCollections.observableSet();
    public static ObservableList<StopPoint> stopPointsList = FXCollections.observableArrayList(stopPoints);

    public static void setDataListeners() {
        SetChangeListener<StopPoint> listner = change -> {
            stopPointsList.clear();
            stopPointsList.addAll(stopPoints);
        };
        stopPoints.addListener(listner);
    }

    public ArrayList<StopPoint> getStopPoints() {
        return new ArrayList<>();
    }
}
