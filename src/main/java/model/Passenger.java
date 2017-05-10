package model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Passenger extends Account {

    private List<Ride> bookedRides = new ArrayList<>();

    public boolean bookRide(Ride ride){
        if (ride.getRideState() != Ride.RideState.Cancelled.name()) {
            bookedRides.add(ride);
            return true;
        }
        return false;
    }

    public ObservableList<Ride> getBookedRides() {
        return FXCollections.observableArrayList(bookedRides);
    }
}
