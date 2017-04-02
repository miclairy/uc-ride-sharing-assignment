package model;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;


public class Ride {

    private Trip trip;
    private int availableSeats;
    private Set<Passenger> passengers = new HashSet<>();

    public Ride(Trip trip, int availableSeats) {
        this.trip = trip;
        if (availableSeats > trip.getCar().getNumSeats()){
            this.availableSeats = trip.getCar().getNumSeats();
        } else {
            this.availableSeats = availableSeats;
        }
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void addPassenger(Passenger passenger) {
        if (availableSeats > 0){
            availableSeats -= 1;
            passengers.add(passenger);
        }

    }
}
