package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


public class Data {

    public static ObservableSet<StopPoint> stopPoints = FXCollections.observableSet();
    public static ObservableList<StopPoint> stopPointsList = FXCollections.observableArrayList(stopPoints);
    private static ObservableList<Ride> sharedRides = FXCollections.observableArrayList();

    public static void setDataListeners() {
        SetChangeListener<StopPoint> listner = change -> {
            stopPointsList.clear();
            stopPointsList.addAll(stopPoints);
        };
        stopPoints.addListener(listner);
    }

    public static ObservableList<Ride> getSharedRides() {
        return sharedRides;
    }

    public ArrayList<StopPoint> getStopPoints() {
        return new ArrayList<>();
    }

    public static ObservableList<StopPoint> stopPointsSearch(String searchString) {
        ObservableList<StopPoint> searchResult = FXCollections.observableArrayList();
        if (searchString.isEmpty()) {
            return Data.stopPointsList.sorted();
        } else {
            for (StopPoint stopPoint : Data.stopPointsList.sorted()) {
                if (stopPoint.toString().contains(searchString)) {
                    searchResult.add(stopPoint);
                }
            }
            return searchResult;
        }
    }

    public static ObservableList<Ride> ridesForStopPoint(StopPoint stopPoint) {
        ObservableList<Ride> result = FXCollections.observableArrayList();
        for (Ride ride : sharedRides) {
            if (ride.getTrip().getRoute().getStops().contains(stopPoint)) {
                result.add(ride);
            }
        }
        return result;
    }


    public static Collection<Ride> filterRides(String filter) {
        Collection<Ride> result = new ArrayList<>();
        for (Ride ride : sharedRides) {
            if (ride.getTrip().getDirection().equals(filter)) {
                result.add(ride);
            }
        }
        return result;
    }
}
