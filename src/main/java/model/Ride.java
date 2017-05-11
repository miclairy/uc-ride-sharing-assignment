package model;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


public class Ride implements Comparable<Ride> {

    public enum RideState{
        Done, Cancelled, Booked, Running
    }

    private Trip trip;
    private int availableSeats;
    private Set<Passenger> passengers = new HashSet<>();
    private LocalDate date;
    private RideState state;
    private LocalTime time;
    private String cancelationReason;

    private SimpleStringProperty name;
    private SimpleStringProperty startDate;
    private SimpleStringProperty startTime;
    private SimpleStringProperty rideState;


    public Ride(Trip trip, int availableSeats, LocalDate date) {
        this.trip = trip;
        if (availableSeats > trip.getCar().getNumSeats()){
            this.availableSeats = trip.getCar().getNumSeats();
        } else {
            this.availableSeats = availableSeats;
        }
        this.date = date;

        changeRideState(RideState.Running);
        name = trip.getNameProperty();
        startDate = new SimpleStringProperty(date.toString());
        if (!trip.getStopTimes().isEmpty()) {
            List<LocalTime> times = new ArrayList<>(trip.getStopTimes().values());
            Collections.sort(times);
            time = times.get(0);
            String earliest = times.get(0).toString();
            startTime = new SimpleStringProperty(earliest);
        } else {
            startTime = new SimpleStringProperty("not known");
        }
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

    public void bookPassenger(Driver driver, Passenger passenger){
        if (availableSeats > 0 && !passengers.contains(passenger)) {
            passengers.add(passenger);
            availableSeats--;
            passenger.bookRide(this);
        }
        if (availableSeats == 0){
            driver.getRides().remove(this);
        }

    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public String getDetails() {
        String details =  "\nCar: " + trip.getCar().toString() +
                "\n Route Length: " + trip.getLength().toMinutes() + "\nNumber of Stops: " + trip.getStopTimes().size() +
                "\nAvailable Seats: " + availableSeats;
        return details;
    }


    @Override
    public int compareTo(Ride o) {
        int compare = date.compareTo(o.getDate());
        if (compare == 0){
            compare = time.compareTo(o.time);
        }
        return compare;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name.get();
    }


    public String getStartDate() {
        return startDate.get();
    }


    public String getStartTime() {
        return startTime.get();
    }

    public LocalTime getTime() {
        return time;
    }

    public String getRideState() {
        return rideState.get();
    }

    public void changeRideState(RideState newState) {
        state = newState;
        rideState = new SimpleStringProperty(state.name());
    }

    public void cancelRide(String reason) {
        rideState = new SimpleStringProperty(RideState.Cancelled.name());
        Data.getDriverUser().getRides().remove(this);
        cancelationReason = reason;
    }

    public String getCancelationReason() {
        return cancelationReason;
    }
}
