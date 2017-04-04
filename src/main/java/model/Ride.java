package model;

import java.util.HashSet;
import java.util.Set;


public class Ride {

    private Trip trip;
    private int availableSeats;
    private Set<Passenger> passengers = new HashSet<>();
    private Driver driver;

    public Ride(Trip trip, int availableSeats) {//TODO add date
        this.trip = trip;
        if (availableSeats > trip.getCar().getNumSeats()){
            this.availableSeats = trip.getCar().getNumSeats();
        } else {
            this.availableSeats = availableSeats;
        }
    }

    public Ride(Trip trip, int availableSeats, Driver driver) {//TODO add date
        this.trip = trip;
        if (availableSeats > trip.getCar().getNumSeats()){
            this.availableSeats = trip.getCar().getNumSeats();
        } else {
            this.availableSeats = availableSeats;
        }
        this.driver = driver;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public Trip getTrip() {
        return trip;
    }

    public String toString() {
        return trip.getName();
    }

    public void bookPassenger(Passenger passenger){
        if (availableSeats > 0) {
            passengers.add(passenger);
            availableSeats--;
            passenger.addRide(this);
        }

    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public String getDetails() {
        String details = "Driver: " + driver + "\nGrade: " + driver.getGrade() + "\nCar: " + trip.getCar().toString() +
                "\n Route Length: " + trip.getLength() + "\nNumber of Stops: " + trip.getStopTimes().size();
        return details;
    }
}
