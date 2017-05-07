package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by clbmi on 8/05/2017.
 */
public class Search {

    private static ObservableList<Ride> sharedRides = Data.getSharedRides();

    public static ObservableList<StopPoint> stopPointsSearch(String searchString) {
        Set<StopPoint> searchResult = new HashSet<>();
        if (searchString.isEmpty()) {
            return Data.stopPointsList.sorted();
        } else {
            for (StopPoint stopPoint : Data.stopPointsList.sorted()) {
                if (stopPoint.toString().toLowerCase().contains(searchString.toLowerCase())) {
                    searchResult.add(stopPoint);
                }
            }
            ObservableList<StopPoint> stops = FXCollections.observableArrayList();
            stops.addAll(searchResult);
            return stops.sorted();
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
            if (ride.getTrip().getDirection().toLowerCase().equals(filter.toLowerCase())) {
                result.add(ride);
            }
        }
        return result;
    }
}
