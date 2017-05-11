package model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class Passenger extends Account {

    private List<Ride> bookedRides = new ArrayList<>();
    private Set<Ride> notifiedRides = new HashSet<>();

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

    public Set<Ride> getNotifiedRides() {
        return notifiedRides;
    }
}
