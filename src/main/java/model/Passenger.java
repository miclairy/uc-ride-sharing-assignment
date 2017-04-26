package model;


import java.util.ArrayList;
import java.util.Collection;

public class Passenger extends Account {

    private Collection<Ride> bookedRides = new ArrayList<>();

    public void addRide(Ride ride){
        bookedRides.add(ride);
    }

    public Collection<Ride> getBookedRides() {
        return bookedRides;
    }
}
