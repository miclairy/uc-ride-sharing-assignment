package model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Passenger extends Account {

    private List<Ride> bookedRides = new ArrayList<>();

    public void addRide(Ride ride){
        bookedRides.add(ride);
    }

    public ObservableList<Ride> getBookedRides() {
        return FXCollections.observableArrayList(bookedRides);
    }
}
